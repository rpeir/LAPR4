package eapli.ecourse.student.repositories;

import eapli.ecourse.student.domain.MechanographicNumber;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface StudentRepository extends DomainRepository<EmailAddress, Student>, LockableDomainRepository<EmailAddress, Student> {
        Iterable<Student> students();

        Optional<Student> findByMechanographicNumber(MechanographicNumber mechanicgraphNumber);

        Optional<Student> findByEmail(String string);
}
