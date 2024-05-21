package eapli.ecourse.courseenrollement.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import org.junit.*;

public class CourseEnrollmentTest {
    @Test
    public void ensureCourseEnrollmentIsCreatedWithValidData() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        course.changeEnrollmentState("open enrollments");
        CourseEnrollment courseEnrollment1 = new CourseEnrollment(course);
        Assert.assertNotNull(courseEnrollment1);
    }
    @Test
    public void ensureCourseEnrollmentIsNotCreatedIfCourseIsNotEnrollState() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        course.closeCourse();
        Assert.assertThrows(IllegalArgumentException.class, () -> new CourseEnrollment(course));
    }
    @Test
    public void ensureCourseEnrollmentIsNotCreatedIfCourseIsNull() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new CourseEnrollment(null));
    }
}