package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.classmanagment.domain.Class;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.time.domain.DateTimeInterval;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.framework.time.domain.model.DateInterval;

import javax.persistence.Query;
import java.util.*;

public class JpaClassRepository extends JpaAutoTxRepository<Class, Long, Long> implements ClassRepository {

    public JpaClassRepository(TransactionalContext autoTx) {
        super(autoTx,"classTitle");
    }

    public JpaClassRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "classTitle");
    }

    @Override
    public Optional<Class> findByTitle(String title) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        return matchOne("e.title=:title", params);
    }

    @Override
    public Iterable<Class> saveAll(Iterable<Class> classes) {
        final List<Class> toReturn = new ArrayList<>();
        for (Class c : classes) {
            toReturn.add(save(c));
        }
        return toReturn;
    }

    @Override
    public Iterable<Class> findByCourse(Course course) {
        String select = "SELECT cl FROM Class cl JOIN cl.course co WHERE co = :p";
        Query query = entityManager().createQuery(select, Class.class);
        query.setParameter("p", course);
        return query.getResultList();
    }

    @Override
    public Iterable<Class> findByCourseAndTimePeriod(Course course, DateTimeInterval date) {
        String select = "Select c from Class c where c.course = :p and c.timePeriod = :d";
        Query query = entityManager().createQuery(select);
        query.setParameter("p", course);
        query.setParameter("d", date);
        return query.getResultList();
    }

    @Override
    public Iterable<Class> findByTeacherAndTimePeriod(Teacher teacher, DateTimeInterval date) {
        String select = "Select c from Class c where c.teacher = :p and c.timePeriod = :d";
        Query query = entityManager().createQuery(select);
        query.setParameter("p", teacher);
        query.setParameter("d", date);
        return query.getResultList();
    }

    @Override
    public Iterable<Class> findByTimePeriod(DateTimeInterval timeInterval) {
        String select = "Select c from Class c where c.timePeriod = :p";
        Query query = entityManager().createQuery(select);
        query.setParameter("p", timeInterval);
        return query.getResultList();
    }
}
