package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.student.domain.MechanographicNumber;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryStudentRepository extends InMemoryDomainRepository<Student, EmailAddress> implements StudentRepository {
static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Student> ofIdentity(EmailAddress id) {
        return matchOne(e -> e.user().email().equals(id));
    }

    public Iterable<Student> students() {
        return match(e -> true);
    }

    @Override
    public Optional<Student> findByMechanographicNumber(MechanographicNumber mechanicgraphNumber) {
        return matchOne(e -> e.mechanographicNumber().equals(mechanicgraphNumber));
    }
    @Override
    public Optional<Student> findByEmail(String string) {
        return matchOne(e -> e.user().email().toString().equals(string));
    }

}
