package eapli.ecourse.courseenrollement.domain;

import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "enrollmentApplication")
public class EnrollmentApplication implements DomainEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    private Student student;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "courseEnrollmentId", referencedColumnName = "courseEnrollmentId")
    private CourseEnrollment courseEnrollment;

    public EnrollmentApplication(Student student, CourseEnrollment courseEnrollment) {
        Preconditions.noneNull(student, courseEnrollment);
        this.student = student;
        this.status = Status.PENDING;
        this.courseEnrollment = courseEnrollment;
    }

    public EnrollmentApplication(Student student, Status status) {
        this.student = student;
        this.status = status;
    }

    public EnrollmentApplication() {

    }

    public void acceptApplication() {
        this.status = Status.ACCEPTED;
    }

    public void rejectApplication() {
        this.status = Status.REJECTED;
    }

    public boolean isPending() {
        return this.status.equals(Status.PENDING);
    }

    public boolean isAccepted() {
        return this.status.equals(Status.ACCEPTED);
    }

    public boolean isRejected() {
        return this.status.equals(Status.REJECTED);
    }

    public List<String> info() {
        List<String> data = new ArrayList<>();
        data.add(student.toString());
        data.add(status.toString());
        return data;
    }
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof EnrollmentApplication)) {
            return false;
        }
        final EnrollmentApplication that = (EnrollmentApplication) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.applicationId;
    }

    public Student student() {
        return this.student;
    }
}
