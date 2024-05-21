package eapli.ecourse.coursemanagement.domain;

import com.sun.istack.NotNull;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course implements AggregateRoot<String> {

    /**
     * ORM primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column(nullable = false, unique = true)
    private String courseCode;

    // @OneToOne
    @Column(nullable = false)
    private Designation courseTitle;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column
    private int minStudents;

    @Column
    private int maxStudents;

    @Column
    @Temporal(TemporalType.DATE)
    private Date closeDate;
    @Column
    private Description description;

    @ManyToMany
    private Set<Teacher> teacherList;

    public Course() {
        // for ORM only
    }


    public Course(String courseCode, String courseTitle, int minStudents, int maxStudents, String description, String closeDate) {
        setCourseCode(courseCode);
        this.courseTitle = Designation.valueOf(courseTitle);
        this.description = Description.valueOf(description);
        setNumberStudents(minStudents, maxStudents);
        this.state = State.CLOSE;
        this.teacherList = new HashSet<>();
        setCloseDate(closeDate);
    }

    private void setCloseDate(String closeDate) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date newDate = dateFormat.parse(closeDate);
            Date now = Calendar.getInstance().getTime();
            if (newDate.compareTo(now) <= 0)
                throw new IllegalArgumentException("Invalid date");
            this.closeDate = newDate;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid Date format");
        }
    }

    public void setCourseCode(String courseCode) {
        if (!courseCodeMeetsMinimumRequirements(courseCode))
            throw new IllegalArgumentException("Invalid course code");
        this.courseCode = courseCode;
    }

    public void setNumberStudents(int minStudents, int maxStudents) {
        if (!numberStudentsMeetsMinimumRequirements(minStudents, maxStudents))
            throw new IllegalArgumentException("Invalid number of students");
        this.minStudents = minStudents;
        this.maxStudents = maxStudents;
    }

    private static boolean courseCodeMeetsMinimumRequirements(final String courseCode) {
        return !StringPredicates.isNullOrEmpty(courseCode);
    }

    private static boolean numberStudentsMeetsMinimumRequirements(final int minStudents, final int maxStudents) {
        return minStudents < maxStudents && minStudents > 0;

    }

    @Override
    public boolean sameAs(Object other) {
        Course course = (Course) other;
        return this.equals(course) && this.description.equals(course.description) && this.courseTitle.equals(course.courseTitle);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }


    @Override
    public String identity() {
        return this.courseCode;
    }


    @Override
    public boolean hasIdentity(String id) {
        return id.equalsIgnoreCase(this.courseCode);
    }


    public void openCourse() {
        if (this.closeDate.before(Calendar.getInstance().getTime()))
            throw  new IllegalArgumentException("Cannot open Course with close date pasted.");
        this.state = State.OPEN;
    }

    public void closeCourse(){
        this.state = State.CLOSE;
    }

    public boolean isClosed() {
        return this.state.equals(State.CLOSE);
    }

    public boolean isOpen() {
        return  this.state.equals(State.OPEN);
    }

    public void addTeachers(Set<Teacher> teacherList){
        if(!this.state.equals(State.CLOSE)){
            for (Teacher teacher: teacherList){
                try {
                    this.teacherList.add(teacher);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }else {
            throw new RuntimeException("This action is not available for this course");
        }
    }

    public boolean isAvailableForEnrollments(){
        return this.state.equals(State.ENROLL);
    }

    public Date closeDate() {
        return this.closeDate;
    }

    public void changeEnrollmentState(@NotNull String state) {
        if (state.equalsIgnoreCase("open enrollments"))
            this.state = State.ENROLL;
        else if (state.equalsIgnoreCase("close enrollments"))
            this.state = State.INPROGRESS;
        else
            throw new IllegalArgumentException("Invalid state");
    }

    public boolean isEnrollOrInProgress() {
        return this.state.equals(State.ENROLL) || this.state.equals(State.INPROGRESS);
    }
    public boolean teachersContains(EmailAddress teacherId){
        return this.teacherList.stream().anyMatch(teacher -> teacher.identity().equals(teacherId));
    }
    @Override
    public String toString() {
        return courseTitle.toString();
    }
}

