package eapli.ecourse.classmanagment.domain;

import eapli.ecourse.student.domain.Student;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.time.domain.DateTimeInterval;
import org.junit.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class ClassTest {

    private static final String VALID_CLASS_TITLE = "Class Title";

    private static final String VALID_CLASS_TITLE_2 = "Class Title 2";
    private static Course course;
    private static DateTimeInterval timePeriod;
    private static Teacher teacher;
    private static List<Student> enrolledStudents;

    private void defaultEnrolledStudents() {
        enrolledStudents = new ArrayList<>();
        Student st1 = Mockito.mock(Student.class), st2 = Mockito.mock(Student.class);
        enrolledStudents.add(st1);
        enrolledStudents.add(st2);
    }

    private void defaultCourse() {
        course = new Course("COURSE-1", "Course 1", 1,10, "Course 1 Description", "30-07-2023");
    }

    private void defaultTimestamp() {
        Calendar.Builder builderStart = new Calendar.Builder();
        builderStart.setDate(2023, 4, 1);
        builderStart.setTimeOfDay(10,0,0);
        Calendar beginDate = builderStart.build();
        Calendar.Builder builderEnd = new Calendar.Builder();
        builderEnd.setDate(2023, 4, 1);
        builderEnd.setTimeOfDay(12,0,0);
        Calendar endDate = builderEnd.build();
        timePeriod = new DateTimeInterval(beginDate, endDate);
    }

    private void defaultTeacher() {
        // TODO: implement for new constructor for Teacher
        teacher = Mockito.mock(Teacher.class);
    }

    @Before
    public void setUp() {
        defaultCourse();
        defaultTimestamp();
        defaultTeacher();
        defaultEnrolledStudents();
    }

    @Test
    public void ensureClassIsCreatedWithValidData() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClassTitleIsNotEmpty() {
        Class class1 = new Class("", course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClassTitleIsNotNull() {
        Class class1 = new Class(null, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseIsNotNull() {
        Class class1 = new Class(VALID_CLASS_TITLE, null, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTimePeriodIsNotNull() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, null, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTimePeriodIsBeforeCourseCloseDate() {
        Calendar.Builder builderStart = new Calendar.Builder();
        builderStart.setDate(2023, 8, 1);
        builderStart.setTimeOfDay(10,0,0);
        Calendar beginDate = builderStart.build();
        Calendar.Builder builderEnd = new Calendar.Builder();
        builderEnd.setDate(2023, 8, 1);
        builderEnd.setTimeOfDay(12,0,0);
        Calendar endDate = builderEnd.build();
        DateTimeInterval timePeriod = new DateTimeInterval(beginDate, endDate);
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEnrolledStudentsAreNotNull() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, null, teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEnrolledStudentsAreNotEmpty() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, new ArrayList<>(), teacher, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTeacherIsNotNull() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, null, ClassType.RECURRING_CLASS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClassTypeIsNotNull() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, null);
    }

    @Test
    public void ensureClassesAreEqual() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
        Course course1 = new Course("COURSE-2", "Course 2", 1,10, "Course 2 Description", "30-07-2023");
        Class class2 = new Class(VALID_CLASS_TITLE, course1, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
        assertEquals(class1, class2);
        assertTrue(class1.equals(class2));
    }

    @Test
    public void ensureClassesAreTheSame() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
        Class class2 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
        assertEquals(class1, class2);
        assertTrue(class1.sameAs(class2));
    }


    @Test
    public void ensureClassesAreNotEqualNull() {
        Class class1 = new Class(VALID_CLASS_TITLE, course, timePeriod, enrolledStudents, teacher, ClassType.RECURRING_CLASS);
        assertNotEquals(class1, null);
    }


}