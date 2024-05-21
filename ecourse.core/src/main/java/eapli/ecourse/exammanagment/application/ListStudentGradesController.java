package eapli.ecourse.exammanagment.application;

import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

public class ListStudentGradesController {

    private AuthorizationService authz;
    private ExamRepository exams;
    private CourseEnrollmentRepository courseEnrollments;
    private StudentRepository students;

    private ListExamsService listExamsService;

    public ListStudentGradesController(AuthorizationService authz, ExamRepository exams,
                                       CourseEnrollmentRepository courseEnrollments, StudentRepository students){
        this.authz = authz;
        this.exams = exams;
        this.students = students;
        this.courseEnrollments = courseEnrollments;
        this.listExamsService = new ListExamsService(authz, courseEnrollments, exams);
    }

    public ListStudentGradesController() {
        this.authz = AuthzRegistry.authorizationService();
        this.exams = PersistenceContext.repositories().exams();
        this.students = PersistenceContext.repositories().students();
        this.courseEnrollments = PersistenceContext.repositories().courseEnrollments();
        this.listExamsService = new ListExamsService(authz, courseEnrollments, exams);
    }

    public Iterable<ExamExecution> listStudentGrades() {
        SystemUser user= authz.session().get().authenticatedUser(); //get authenticated user
        Student student = null;
        Optional<Student> eUser=this.students.findByEmail(user.email().toString());
        if(eUser.isPresent()){
            student=eUser.get();
        }else{
            System.out.println("User not found");
        }
        return listExamsService.listStudentGrades(student);
    }

}
