package eapli.ecourse.exammanagment.application;

import eapli.ecourse.courseenrollement.application.ListCourseEnrollmentsService;
import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class ListFutureExamsController {

    private AuthorizationService authz;
    private StudentRepository studentRepository;
    private ExamRepository examRepository;
    private CourseRepository courseRepository;
    private CourseEnrollmentRepository courseEnrollmentRepository;

    private ListCourseEnrollmentsService listCourseEnrollmentsService;

    public ListFutureExamsController(AuthorizationService authz){
        this.authz = authz;
        this.courseEnrollmentRepository = PersistenceContext.repositories().courseEnrollments();
        this.courseRepository = PersistenceContext.repositories().courses();
        this.studentRepository = PersistenceContext.repositories().students();
        this.examRepository = PersistenceContext.repositories().exams();
        this.listCourseEnrollmentsService = new ListCourseEnrollmentsService(authz, this.courseEnrollmentRepository);
    }

    public Iterable<Exam> listFutureExamsByCourse(Course course) {
        return examRepository.findByCourse(course);
    }

    public Iterable<Course> findEnrolledCourses() {
        SystemUser user= authz.session().get().authenticatedUser(); //get authenticated user
        Student student = null;
        Optional<Student> eUser=this.studentRepository.findByEmail(user.email().toString());
        if(eUser.isPresent()){
            student=eUser.get();
        }else{
            System.out.println("User not found");
        }
        return listCourseEnrollmentsService.coursesImEnrolled();
    }
}
