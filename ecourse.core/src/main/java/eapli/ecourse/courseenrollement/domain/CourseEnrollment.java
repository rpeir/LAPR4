package eapli.ecourse.courseenrollement.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.domain.State;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import org.hibernate.annotations.Cascade;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "courseEnrollment")
public class CourseEnrollment implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseEnrollmentId")
    private Long courseEnrollmentId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseEnrollment")
    private Set<EnrollmentApplication> enrollmentApplication;

    @OneToOne
    private Course course;

    public CourseEnrollment(Course course) {
        Preconditions.nonNull(course);
        this.enrollmentApplication = new HashSet<>();
        if (!course.isAvailableForEnrollments()) {
            throw new IllegalArgumentException("Course must be in enroll state");
        }else{this.course = course;}
    }

    public CourseEnrollment() {
        // for ORM only
    }


    public Set<EnrollmentApplication> enrollmentApplications() {
        return enrollmentApplication;
    }

    public boolean hasPendingApplications() {
        for (EnrollmentApplication enrollmentApplication : enrollmentApplication) {
            if (enrollmentApplication.isPending()) {
                return true;
            }
        }
        return false;
    }

    public EnrollmentApplication addApplication(Student student) {
        EnrollmentApplication newApplication = new EnrollmentApplication(student, this);
        this.enrollmentApplication.add(newApplication);
        return newApplication;
    }
    public List<String> info(EnrollmentApplication enrollmentApplication) {
        List<String> data = new ArrayList<>();
        data.add(this.course.toString());
        data.addAll(enrollmentApplication.info());
        return data;
    }

    public List<Student> enrolledStudents() {
        List<Student> students = new ArrayList<>();
        for (EnrollmentApplication enrollmentApplication : enrollmentApplication) {
            if (enrollmentApplication.isAccepted()) {
                students.add(enrollmentApplication.student());
            }
        }
        return students;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof CourseEnrollment)) return false;
        final CourseEnrollment that = (CourseEnrollment) other;
        if (this == that) return true;
        return this.course.sameAs(that.course())
                && this.enrollmentApplication.containsAll(that.enrollmentApplication);
    }




    public Course course() {
        return this.course;
    }

    /**
     * @return
     */
    @Override
    public String identity() {
        return this.course.identity();
    }

    public void addApplication(EnrollmentApplication enrollmentApplication) {
        this.enrollmentApplication.add(enrollmentApplication);
    }
}
