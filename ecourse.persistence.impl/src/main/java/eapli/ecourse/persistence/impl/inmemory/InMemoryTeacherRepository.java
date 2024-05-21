package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTeacherRepository extends InMemoryDomainRepository<Teacher, EmailAddress> implements TeacherRepository {

    static {
        InMemoryInitializer.init();
    }

    /**
     * @return
     */
    @Override
    public Iterable<Teacher> availableTeachers() {
        return match(Teacher::isAvailable);
    }

    @Override
    public Optional<Teacher> findByEmail(EmailAddress email) {
        return matchOne(e -> e.user().email().equals(email));
    }

}
