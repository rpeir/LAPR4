package eapli.ecourse.classmanagment.service;

import eapli.ecourse.classmanagment.domain.Class;
import eapli.ecourse.classmanagment.domain.ClassType;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.time.domain.DateTimeInterval;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.time.domain.model.DateInterval;
import eapli.framework.time.domain.model.TimeInterval;
import eapli.framework.validations.Preconditions;
import org.apache.commons.lang.time.DateUtils;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The application service for managing classes.
 */
@ApplicationService
public class ScheduleService {

    private final AuthorizationService authz;
    private final ClassRepository classes;

    /**
     * Default constructor
     */
    public ScheduleService() {
        authz = AuthzRegistry.authorizationService();
        classes = PersistenceContext.repositories().classes();
    }

    /**
     * Dependency injection constructor
     * @param authz authorization service
     * @param classes class repository
     */
    public ScheduleService(AuthorizationService authz, ClassRepository classes) {
        this.authz = authz;
        this.classes = classes;
    }

    /**
     * Checks if the students for a given course are available in the given day of the week and time period
     * @param course the course
     * @param date the day of the week
     * @param timePeriod the time period
     * @param courseEnrollment the course enrollment
     * @return true if the students are available, false otherwise
     */
    public boolean checkCourseStudentDisponibility(Course course, DayOfWeek date, TimeInterval timePeriod, CourseEnrollment courseEnrollment) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);

        Preconditions.nonNull(course);
        Preconditions.nonNull(date);
        Preconditions.nonNull(timePeriod);
        Preconditions.nonNull(courseEnrollment);

        Date endingDate = course.closeDate();
        List<Student> enrolledStudents = courseEnrollment.enrolledStudents();

        // for each day of the week until endingDate
        for (Date d = nextDateOfDayOfWeek(new Date(), date); d.before(endingDate); d = DateUtils.addWeeks(d, 1)) {
            DateTimeInterval interval = createDateInterval(d, timePeriod);
            Iterable<Class> classes = this.classes.findByTimePeriod(interval);

            // for each class on that day
            for (Class c : classes) {
                // for each student enrolled in the course
                for (Student s : enrolledStudents) {
                    // if the student is enrolled in the class
                    if (c.hasStudentEnrolled(s)) {
                        return false;
                    }
                }
            }

        }

        return true;
    }

    /**
     * Returns the next date of the given day of the week
     * @param date the date to start from
     * @param dayOfWeek the day of the week
     * @return the next date of the given day of the week
     */
    private Date nextDateOfDayOfWeek(Date date, DayOfWeek dayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        while (day != dayOfWeek.getValue()+1) {
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            day = calendar.get(Calendar.DAY_OF_WEEK);
        }
        return calendar.getTime();
    }

    /**
     * Creates a TimestampInterval from a Date and a TimeInterval
     * @param date the date
     * @param timePeriod the time period
     * @return the TimestampInterval
     */
    private DateTimeInterval createDateInterval(Date date, TimeInterval timePeriod) {
        Calendar.Builder builder = new Calendar.Builder();
        builder.setDate(date.getYear()+1900, date.getMonth(), date.getDate());
        builder.setTimeOfDay(timePeriod.start().get(Calendar.HOUR_OF_DAY), timePeriod.start().get(Calendar.MINUTE), 0);
        Calendar start = builder.build();
        builder = new Calendar.Builder();
        builder.setDate(date.getYear()+1900, date.getMonth(), date.getDate());
        builder.setTimeOfDay(timePeriod.end().get(Calendar.HOUR_OF_DAY), timePeriod.end().get(Calendar.MINUTE), 0);
        Calendar end = builder.build();
        return new DateTimeInterval(start,end);
    }

    /**
     * Schedules a recurring class for a given course, day of the week and time period
     * @param title the title of the class
     * @param course the course
     * @param date the day of the week
     * @param timePeriod the time period
     * @param courseEnrollment the course enrollment
     * @param teacher the teacher
     * @return the created classes
     * @throws IllegalArgumentException if there are classes for the given course and time period
     */
    public Iterable<Class> scheduleClass(String title, Course course,
                                         DayOfWeek date, TimeInterval timePeriod,
                                         CourseEnrollment courseEnrollment,
                                         Teacher teacher) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);

        Preconditions.nonNull(course);
        Preconditions.nonNull(date);
        Preconditions.nonNull(timePeriod);
        Preconditions.nonNull(courseEnrollment);
        Preconditions.nonNull(teacher);

        List<Class> createdClasses = new ArrayList<>();
        List<Student> students = courseEnrollment.enrolledStudents();
        Date endingDate = course.closeDate();

        // for each day of the week until endingDate
        for (Date d = nextDateOfDayOfWeek(new Date(), date); d.before(endingDate); d = DateUtils.addDays(d, 7)) {
            DateTimeInterval interval = createDateInterval(d, timePeriod);
            Iterable<Class> classes = this.classes.findByCourseAndTimePeriod(course, interval);
            if (classes.iterator().hasNext())
                throw new IllegalArgumentException("There are classes for the given course and time period");
            classes = this.classes.findByTeacherAndTimePeriod(teacher, interval);
            if (classes.iterator().hasNext())
                throw new IllegalArgumentException("The teacher is not available for the given time period");
        }

        // for each day of the week until endingDate
        for (Date d = nextDateOfDayOfWeek(new Date(), date); d.before(endingDate); d = DateUtils.addDays(d, 7)) {
            DateTimeInterval interval = createDateInterval(d, timePeriod);
            Class c = new Class(title, course, interval, students, teacher, ClassType.RECURRING_CLASS);
            createdClasses.add(c);
        }
        return classes.saveAll(createdClasses);
    }
}
