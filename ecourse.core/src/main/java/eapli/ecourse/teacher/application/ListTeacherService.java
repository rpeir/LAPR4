package eapli.ecourse.teacher.application;

import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

public class ListTeacherService {
    private AuthorizationService authz;
    private TeacherRepository teacherRepository;

    public ListTeacherService(AuthorizationService authz, TeacherRepository teacherRepository) {
        this.authz = authz;
        this.teacherRepository = teacherRepository;
    }

    public Iterable<Teacher> availableTeachers() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return teacherRepository.availableTeachers();
    }
}


