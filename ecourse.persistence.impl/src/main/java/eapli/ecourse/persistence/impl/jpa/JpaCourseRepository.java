package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.ecourse.coursemanagement.domain.State;
import javax.persistence.*;

public class JpaCourseRepository extends JpaAutoTxRepository<Course, Long, String> implements CourseRepository {


    public JpaCourseRepository(TransactionalContext autoTx) {
        super(autoTx,"courseCode");
    }

    public JpaCourseRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "courseCode");
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> closeCourses() {
        String select = "Select c from Course c where c.state = :p";
        Query query = entityManager().createQuery(select);
        query.setParameter("p",State.CLOSE);
        return query.getResultList();
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> openCourses() {
        Query query = entityManager().createQuery("Select c from Course c where c.state = :p");
        query.setParameter("p",State.OPEN);
        return query.getResultList();
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> availableCourses() {
        Query query = entityManager().createQuery("Select c from Course c where c.state <> :p");
        query.setParameter("p",State.CLOSE);
        return query.getResultList();
    }

    @Override
    public  Iterable<Course> findAll(){
        Query query = entityManager().createQuery("select c from Course c");
        return query.getResultList();
    }

    /**
     * @param teacherId
     * @return
     */
    @Override
    public Iterable<Course> availableCoursesTeacher(EmailAddress teacherId) {
        String select = "SELECT c FROM Course c JOIN c.teacherList t WHERE t.id = :p";
        Query query = entityManager().createQuery(select);
        query.setParameter("p",teacherId);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> availableCoursesStudent() {
        Query query = entityManager().createQuery("Select c from Course c where c.state = :p");
        query.setParameter("p",State.ENROLL);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> enrollOrInProgressCourses() {
        Query query = entityManager().createQuery("Select c from Course c where c.state = :p or c.state = :q");
        query.setParameter("p",State.ENROLL);
        query.setParameter("q",State.INPROGRESS);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> findByTeacher(EmailAddress teacherId) {
        String select = "SELECT c FROM Course c JOIN c.teacherList t WHERE t.id = :p";
        Query query = entityManager().createQuery(select);
        query.setParameter("p",teacherId);
        return query.getResultList();
    }
}
