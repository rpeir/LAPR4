package eapli.ecourse.teacher.repositories;

import eapli.ecourse.teacher.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface TeacherRepository  extends DomainRepository<EmailAddress, Teacher>, LockableDomainRepository<EmailAddress, Teacher> {
    Iterable<Teacher> availableTeachers();
    Optional<Teacher> findByEmail(EmailAddress email);

}
