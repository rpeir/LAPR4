package eapli.ecourse.coursemanagement.domain;

import org.junit.jupiter.api.Test;
import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.teacher.domain.Acronym;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

import org.junit.*;
import  org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    public void ensureCourseCodeMustNotBeEmpty() {
        System.out.println("must have non-empty course code");

        assertThrows(IllegalArgumentException.class, () -> new Course("", "Java-1", 15, 100, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureCourseCodeMustNotBeNull() {
        System.out.println("must have a course code");

        assertThrows(IllegalArgumentException.class, () -> new Course(null, "Java-1", 15, 100, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureCourseTitleMustNotBeEmpty() {
        System.out.println("must have non-empty course title");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", "", 15, 100, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureCourseTitleMustNotBeNull() {
        System.out.println("must have a course title");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", null, 15, 100, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureMinStudentsMustNotBeNegative() {
        System.out.println("must have non-negative min students");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", "Java-1", -1, 100, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureMaxStudentsMustNotBeNegative() {
        System.out.println("must have non-negative max students");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", "Java-1", 15, -1, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureMinStudentsMustNotBeGreaterThanMaxStudents() {
        System.out.println("must have min students less than max students");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", "Java-1", 100, 15, "OO Programming", "15-05-2025"));
    }

    @Test
    public void ensureCourseDescriptionMustNotBeEmpty() {
        System.out.println("must have non-empty course description");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", "Java-1", 15, 100, "", "15-05-2025"));
    }

    @Test
    public void ensureCourseDescriptionMustNotBeNull() {
        System.out.println("must have a course description");

        assertThrows(IllegalArgumentException.class, () -> new Course("Java-1", "Java-1", 15, 100, null, "15-05-2025"));
    }

    @Test
    public void ensureCourseCreatedIsClosed() {
        final String courseCode = "Java-1";
        final String courseTitle = "Java1";
        final int minStudents = 15;
        final int maxStudents = 100;
        final String courseDescription = "OO Programming";
        final Course course = new Course(courseCode, courseTitle, minStudents, maxStudents, courseDescription, "15-05-2025");
        assertTrue(course.isClosed());

    }

    @Test
    public void ensureCourseCreatedWithAnIdentityHasThatIdentity() {
        System.out.println("ensure identity");
        final String courseCode = "Java-1";
        Course course = new Course(courseCode, "JV1", 15, 100, "OOP", "15-05-2025");
        assertEquals(courseCode, course.identity());
    }

    @Test
    public void ensureCourseCreatedWithAnIdentityHasThatIdentity2() {
        System.out.println("ensure identity");
        final String courseCode = "Java-1";
        Course course = new Course(courseCode, "JV1", 15, 100, "OOP", "15-05-2025");
        assertTrue(course.hasIdentity(courseCode));
    }

    @Test
    public void ensureCourseCloseDateUsesCorrectDateFormat() {
        System.out.println("ensure date");
        assertThrows(IllegalArgumentException.class, () -> new Course("Jv1", "Jv1", 15, 100, "OOP", "2025-05-15"));
    }

    @Test
    public void ensureCourseCloseDateIsNotBeforeToday() {
        System.out.println("ensure date");
        assertThrows(IllegalArgumentException.class, () -> new Course("Jv1", "Jv1", 15, 100, "OOP", "15-05-2020"));
    }

//    @Test
//    void ensureCannotOpenCoursePastCloseDate(){
//        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2020");
//       assertThrows(IllegalArgumentException.class, course::openCourse);
//    }

    @Test
    public void openCourseTest() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        course.openCourse();
        assertTrue(course.isOpen());
    }

    @Test
    public void closeCourseTest() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        course.openCourse();
        course.closeCourse();
        assertTrue(course.isClosed());
    }
    @Test
    public void isOpenTest(){
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        course.openCourse();
        assertTrue(course.isOpen());
    }
    @Test
    public void isClosedTest(){
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        assertTrue(course.isClosed());
    }

    @Test
    public void ensureThatCloseCourseCannotBeAddedTeachers() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());

        SystemUser user1 = userBuilder.with("user1", "duMMy1", "dummy", "dummy", "a@b.ror").withRoles(ECourseRoles.TEACHER_USER).build();
        SystemUser user2 = userBuilder.with("user2", "duMMy2", "dummy", "dummy", "user@b.rro").withRoles(ECourseRoles.TEACHER_USER).build();
        SystemUser user3 = userBuilder.with("user3", "duMMy3", "dummy", "dummy", "user1@r.rro").withRoles(ECourseRoles.TEACHER_USER).build();
        Teacher teacher1 = new Teacher(user1,Acronym.valueOf("USER1"),"USER1","USER1",new TPN("123456789"), new Date(), EmailAddress.valueOf("a@b.ror"));
        Teacher teacher2 = new Teacher(user2,Acronym.valueOf("USER2"),"USER2","USER2",new TPN("123456780"), new Date(), EmailAddress.valueOf("user@b.rro"));
        Teacher teacher3 = new Teacher(user3,Acronym.valueOf("USER3"),"USER3","USER3",new TPN("123456769"), new Date(), EmailAddress.valueOf("user1@r.rro"));
        Set<Teacher> teacherSet= new HashSet<>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);
        teacherSet.add(teacher3);
        assertThrows(RuntimeException.class, () -> course.addTeachers(teacherSet));

    }

    @Test
    public void addTeachers() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        SystemUser user1 = userBuilder.with("user1", "duMMy1", "dummy", "dummy", "a@b.ror").withRoles(ECourseRoles.TEACHER_USER).build();
        SystemUser user2 = userBuilder.with("user2", "duMMy2", "dummy", "dummy", "user@b.rro").withRoles(ECourseRoles.TEACHER_USER).build();
        SystemUser user3 = userBuilder.with("user3", "duMMy3", "dummy", "dummy", "user1@r.rro").withRoles(ECourseRoles.TEACHER_USER).build();
        Teacher teacher1 = new Teacher(user1,Acronym.valueOf("USER1"),"USER1","USER1",new TPN("123456789"), new Date(), EmailAddress.valueOf("a@b.ror"));
        Teacher teacher2 = new Teacher(user2,Acronym.valueOf("USER2"),"USER2","USER2",new TPN("123456780"), new Date(), EmailAddress.valueOf("user@b.rro"));
        Teacher teacher3 = new Teacher(user3,Acronym.valueOf("USER3"),"USER3","USER3",new TPN("123456769"), new Date(), EmailAddress.valueOf("user1@r.rro"));
        Set<Teacher> teacherSet= new HashSet<>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);
        teacherSet.add(teacher3);
        course.openCourse();
        course.addTeachers(teacherSet);

    }

}