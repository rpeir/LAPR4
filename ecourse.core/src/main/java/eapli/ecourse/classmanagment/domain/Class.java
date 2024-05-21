package eapli.ecourse.classmanagment.domain;

import eapli.ecourse.student.domain.Student;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.time.domain.DateTimeInterval;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;


/**
 * Represents a class of a course, which can be recurring or extra.
 */
@Entity
@Table
public class Class implements AggregateRoot<Long> {

    /**
     * Class identifier
     * ORM primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Class title
     */
    @Column(nullable = false)
    private Designation classTitle;

    /**
     * Time period of the class
     */
    @Column(nullable = false)
    private DateTimeInterval timePeriod;

    /**
     * Course to which the class belongs
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="courseId")
    private Course course;

    /**
     * Class type
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassType classType;

    /**
     * Teacher responsible for the class
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="email")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "enrolled_students",
            joinColumns = @JoinColumn(name = "classTitle"),
            inverseJoinColumns = @JoinColumn(name = "email"))
    private List<Student> enrolledStudents;

    protected Class() {
        // for ORM only
    }

    public Class(String classTitle,  Course course, DateTimeInterval timePeriod, List<Student> enrolledStudents, Teacher teacher, ClassType classType) {
        this.classTitle=Designation.valueOf(classTitle);
        setCourse(course);
        setTimePeriod(timePeriod);
        setEnrolledStudents(enrolledStudents);
        setTeacher(teacher);
        setClassType(classType);
    }

    private void setEnrolledStudents(List<Student> enrolledStudents) {
        Preconditions.nonNull(enrolledStudents, "Enrolled students should not be null");
        Preconditions.ensure(!enrolledStudents.isEmpty(), "Enrolled students should not be empty");
        this.enrolledStudents = enrolledStudents;
    }

    private void setClassType(ClassType classType) {
        Preconditions.nonNull(classType, "Class type should not be null");
        this.classType = classType;
    }

    private void setTeacher(Teacher teacher) {
        Preconditions.nonNull(teacher, "Teacher should not be null");
        this.teacher = teacher;
    }

    private void setTimePeriod(DateTimeInterval timePeriod) {
        Preconditions.nonNull(timePeriod, "Time period should not be null");
        Preconditions.ensure(timePeriod.end().getTime().before(course.closeDate()), "End date should be before course close date");
        this.timePeriod = timePeriod;
    }

    private void setCourse(Course course) {
        Preconditions.nonNull(course, "Course should not be null");
        this.course = course;
    }

    @Override
    public boolean equals(Object obj) {
        return DomainEntities.areEqual(this, obj);
    }

    @Override
    public boolean sameAs(Object other) {
        if (other.getClass() != this.getClass())
            return false;
        final Class that = (Class) other;
        if (this == that)
            return true;
        return (this.classTitle.equals(that.classTitle)
                && this.timePeriod.equals(that.timePeriod)
                && this.course.equals(that.course)
                && this.teacher.equals(that.teacher)
                && this.classType.equals(that.classType));
    }

    @Override
    public Long identity() {
        return this.id;
    }

    /**
     * Checks if a student is enrolled in the class
     * @param s student
     * @return true if the student is enrolled in the class, false otherwise
     */
    public boolean hasStudentEnrolled(Student s) {
        return enrolledStudents.contains(s);
    }

    /**
     * Returns the course to which the class belongs
     * @return course
     */
    public Course course() {
        return this.course;
    }

    /**
     * Returns the time period of the class
     * @return time period
     */
    public DateTimeInterval timePeriod() {
        return this.timePeriod;
    }

    /**
     * Returns the teacher of the class
     * @return teacher
     */
    public Teacher teacher() {
        return this.teacher;
    }

    @Override
    public String toString() {
        return this.classTitle.toString();
    }

    public String title() {
        return this.classTitle.toString();
    }
}
