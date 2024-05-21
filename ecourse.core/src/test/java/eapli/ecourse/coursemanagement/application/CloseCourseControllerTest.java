package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CloseCourseControllerTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    // mock objects
    private final AuthorizationService unauthorizedAuthz = new AuthorizationService() {
//        @Override
//        public boolean isAuthenticatedUserAuthorizedTo(final Role... actions) {
//            throw new UnauthorizedException(dummyUser("X"), ECourseRoles.TEACHER_USER,ECourseRoles.STUDENT_USER);
//        }
    };

    private final AuthorizationService authorizedAuthz = new AuthorizationService() {
        @Override
        public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        }
    };

    private final CourseRepository repo = new CourseRepository() {
        /**
         * @return
         */
        @Override
        public Iterable<Course> closeCourses() {
            return null;
        }

        /**
         * @return
         */
        @Override
        public Iterable<Course> openCourses() {
            return null;
        }

        /**
         * @return
         */
        @Override
        public Iterable<Course> availableCourses() {
            return null;
        }

        @Override
        public <S extends Course> S save(S entity) {
            throw new IntegrityViolationException("");
        }

        @Override
        public Iterable<Course> findAll() {
            return null;
        }

        /**
         * @param teacherId
         * @return
         */
        @Override
        public Iterable<Course> availableCoursesTeacher(EmailAddress teacherId) {
            return null;
        }

        /**
         * @return
         */
        @Override
        public Iterable<Course> availableCoursesStudent() {
            return null;
        }

        @Override
        public Iterable<Course> enrollOrInProgressCourses() {
            return null;
        }

        @Override
        public Iterable<Course> findByTeacher(EmailAddress teacherId) {
            return null;
        }


        @Override
        public Optional<Course> ofIdentity(String id) {
            return Optional.empty();
        }

        @Override
        public void delete(Course entity) {

        }

        @Override
        public void deleteOfIdentity(String entityId) {

        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public Course lockItUp(Course entity) {
            return null;
        }

        @Override
        public Optional<Course> lockOfIdentity(String id) {
            return Optional.empty();
        }
    };

    @Test
    public void ensureWhenNotManagerFail(){
       Course course = new Course("course1","course1",10,100,"bootstrap course","10-05-2030");
       CloseCourseController ctrl = new CloseCourseController(unauthorizedAuthz,repo );
        assertThrows(RuntimeException.class,() -> ctrl.closeCourse(course));

    }
}