package eapli.ecourse.courseenrollement.application;

import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class RequestEnrollmentCourseController {
    private AuthorizationService authz;
    private CourseEnrollmentRepository courseEnrollmentRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public RequestEnrollmentCourseController(AuthorizationService authz){
        this.authz = authz;
        this.courseEnrollmentRepository = PersistenceContext.repositories().courseEnrollments();
        this.courseRepository = PersistenceContext.repositories().courses();
        this.studentRepository = PersistenceContext.repositories().students();
    }

    //list available courses first
    public Iterable<Course> availableCourses(){
        return courseRepository.availableCoursesStudent();
    }
    // request enrollment in a course
    public void addApplication(@NotNull Course courseToFind) {
        SystemUser user= authz.session().get().authenticatedUser(); //get authenticated user
        Student student = null;
        Optional<Student> eUser=studentRepository.findByEmail(user.email().toString());
        if(eUser.isPresent()){
            student=eUser.get();
        }else{
            System.out.println("User not found");
        }
        // verify if the courseEnrollment already exists
        Optional<CourseEnrollment> courseEnrollment = courseEnrollmentRepository.findByCourse(courseToFind);
        if (courseEnrollment.isPresent() && student != null && courseToFind.isAvailableForEnrollments()) {
            // if it exists, add the application to the courseEnrollment
            courseEnrollment.get().addApplication(student);
            courseEnrollmentRepository.save(courseEnrollment.get());
        } else if (courseEnrollment.isEmpty() && student != null && courseToFind.isAvailableForEnrollments()) {
            // if it doesn't exist, create a new courseEnrollment and add the application to it
            CourseEnrollment newCourseEnrollment = new CourseEnrollment(courseToFind);
            newCourseEnrollment.addApplication(student);
            courseEnrollmentRepository.save(newCourseEnrollment);
        }else {
            System.out.println("Course not available for enrollments");
        }
    }
}
