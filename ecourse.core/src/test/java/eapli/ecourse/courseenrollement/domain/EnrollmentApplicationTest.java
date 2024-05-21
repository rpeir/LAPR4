package eapli.ecourse.courseenrollement.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.student.domain.Student;
import org.junit.*;

import static org.mockito.Mockito.mock;

public class EnrollmentApplicationTest {

    private CourseEnrollment courseEnrollment1;
    private Student student1;
    @Before
    public void setUp() {
        Course course = new Course("Java-1", "JV1", 15, 100, "OOP", "15-05-2025");
        course.changeEnrollmentState("open enrollments");
        courseEnrollment1 = new CourseEnrollment(course);
        student1 = mock(Student.class);
    }
    @Test
    public void ensureEnrollmentApplicationIsNotCreatedWithNullStudent() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new EnrollmentApplication(null, courseEnrollment1));
    }
    @Test
    public void ensureEnrollmentApplicationIsNotCreatedWithNullCourseEnrollment() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new EnrollmentApplication(student1, (CourseEnrollment) null));
    }
    @Test
    public void ensureEnrollmentApplicationIsCreatedWithValidData() {
        EnrollmentApplication enrollmentApplication1 = new EnrollmentApplication(student1, courseEnrollment1);
        Assert.assertNotNull(enrollmentApplication1);
    }
    @Test
    public void ensureEnrollmentApplicationIsCreatedWithPendingStatus() {
        EnrollmentApplication enrollmentApplication1 = new EnrollmentApplication(student1, courseEnrollment1);
        Assert.assertTrue(enrollmentApplication1.isPending());
    }

}
