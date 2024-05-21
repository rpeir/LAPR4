package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.courseenrollement.domain.Status;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.domain.State;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCourseEnrollmentRepository extends JpaAutoTxRepository<CourseEnrollment, Long, String> implements CourseEnrollmentRepository {

    public JpaCourseEnrollmentRepository(TransactionalContext autoTx) {
        super(autoTx, "courseEnrollmentId");
    }

    public JpaCourseEnrollmentRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "courseEnrollmentId");
    }

    @Override
    public Optional<CourseEnrollment> findByCourse(Course course) {
        final Map<String, Object> params = new HashMap<>();
        params.put("course", course);
        return matchOne("e.course = :course", params);
    }

    @Override
    public Iterable<CourseEnrollment> hasPendingEnrollmentApplications() {
        Query query = entityManager().createQuery(
                "SELECT ce FROM CourseEnrollment ce INNER JOIN EnrollmentApplication ea ON ea.courseEnrollment = ce AND ea.status = :p");
        query.setParameter("p", Status.PENDING);
        return (Iterable<CourseEnrollment>) query.getResultList();
    }

    @Override
    public Iterable<CourseEnrollment> findEnrollmentsByStudent(Student student) {
        Query query = entityManager().createQuery(
                "SELECT ce FROM CourseEnrollment ce INNER JOIN EnrollmentApplication ea ON ea.courseEnrollment = ce AND ea.student = :p");
        query.setParameter("p", student);
        return (Iterable<CourseEnrollment>) query.getResultList();
    }

    /**
     * @param emailAddress
     * @return
     */
    @Override
    public Iterable<Course> coursesImEnrolled(EmailAddress emailAddress) {
        String select = "SELECT c FROM CourseEnrollment ce JOIN ce.course c " +
                "JOIN ce.enrollmentApplication app WHERE app.student.emailAddress = :s AND app.status = :p ";
        Query query = entityManager().createQuery(select);
        query.setParameter("p", Status.ACCEPTED);
        query.setParameter("s",emailAddress);
        return query.getResultList();
    }


}
