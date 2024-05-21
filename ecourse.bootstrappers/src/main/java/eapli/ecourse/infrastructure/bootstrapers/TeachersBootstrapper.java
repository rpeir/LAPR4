package eapli.ecourse.infrastructure.bootstrapers;

import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.teacher.domain.Acronym;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeachersBootstrapper extends SystemUsersBootstrapperBase implements Action {

    private static final HashSet<Role> TEACHER_ROLE = new HashSet<>();

    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    public TeachersBootstrapper() {
        TEACHER_ROLE.add(ECourseRoles.TEACHER_USER);
    }

    @Override
    public boolean execute() {
        create();
        return true;
    }

    private Teacher registerTeacher4() {
        String email = "user1@r.rro";
        SystemUser user3 = registerUser(email, "TeacherPassword10", "dummy", "dummy", email,TEACHER_ROLE);
        Teacher teacher3 = new Teacher(user3,Acronym.valueOf("USER3"),"USER3","USER3",new TPN("123456769"), new Date(), EmailAddress.valueOf("user1@r.rro"));
        return teacherRepository.save(teacher3);
    }

    private Teacher registerTeacher3() {
        String email = "user@b.rro";
        SystemUser user2 = registerUser(email, "TeacherPassword10", "dummy", "dummy", email,TEACHER_ROLE);
        Teacher teacher2 = new Teacher(user2, Acronym.valueOf("USER2"),"USER2","USER2",new TPN("123456780"), new Date(), EmailAddress.valueOf("user@b.rro"));
        return teacherRepository.save(teacher2);
    }

    private Teacher registerTeacher2() {
        String email = "a@b.ror";
        SystemUser user = registerUser(email, "TeacherPassword10", "dummy", "dummy", email, TEACHER_ROLE);
        return teacherRepository.save(
                new Teacher(user,Acronym.valueOf("USER1"),"USER1","USER1",new TPN("123456789"),
                        new Date(), EmailAddress.valueOf("a@b.ror")));
    }

    private Teacher registerTeacher1() {
        String email = "teacher1@email.org";
        SystemUser user = registerUser(email,"TeacherPassword10","Teacher","One", email, TEACHER_ROLE);
        return teacherRepository.save(
                new Teacher(user,Acronym.valueOf("TEACHER_ONE"),"TEACHER ONE","TEACHER ONE",new TPN("123456789"),
                        new Date(), EmailAddress.valueOf(email)));
    }

    private void create() {
        Teacher teacher1 = registerTeacher1(), teacher2 = registerTeacher2(),
                teacher3 = registerTeacher3(), teacher4 = registerTeacher4();

        CourseEnrollmentRepository ceRepository = PersistenceContext.repositories().courseEnrollments();

        Iterable<CourseEnrollment> courseEnrollments = ceRepository.findAll();
        CourseEnrollment ce = courseEnrollments.iterator().next();
        Course course = ce.course();
        course.addTeachers(Set.of(teacher1, teacher2, teacher3, teacher4));
        CourseRepository courseRepository = PersistenceContext.repositories().courses();
        courseRepository.save(course);

    }
}
