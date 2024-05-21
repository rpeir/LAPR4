package eapli.ecourse.usermanagement.service;

import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class FindLoggedECourseUser {
    private AuthorizationService authz;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public FindLoggedECourseUser(){
        this.authz = AuthzRegistry.authorizationService();
        this.studentRepository = PersistenceContext.repositories().students();
        this.teacherRepository = PersistenceContext.repositories().teachers();
    }

    public FindLoggedECourseUser(AuthorizationService authz, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.authz=authz;
        this.studentRepository=studentRepository;
        this.teacherRepository=teacherRepository;
    }

    public ECourseUser findLoggedECourseUser() {
        SystemUser user = authz.session().get().authenticatedUser(); //get authenticated user
        ECourseUser owner = null;
        if (user.roleTypes().contains(ECourseRoles.STUDENT_USER)) {
            Optional<Student> eUser = studentRepository.findByEmail(user.email().toString());
            if (eUser.isPresent()) {
                owner = eUser.get();
            } else {
                throw new IllegalStateException("User not found");
            }
        }
        if (user.roleTypes().contains(ECourseRoles.TEACHER_USER)) {
            Optional<Teacher> eUser = teacherRepository.findByEmail(user.email());
            if (eUser.isEmpty()) {
                throw new IllegalStateException("User not found");
            }
            owner = eUser.get();
        }
        return owner;
    }
    public ECourseUser findLoggedECourseUser(EmailAddress emailAddress){
        Optional<Student> student = studentRepository.findByEmail(String.valueOf(emailAddress));
        if(student.isPresent()){
            return student.get();
        }
        Optional<Teacher> teacher = teacherRepository.findByEmail(emailAddress);
        if(teacher.isPresent()){
            return teacher.get();
        }
        throw new IllegalStateException("User not found");
    }
}
