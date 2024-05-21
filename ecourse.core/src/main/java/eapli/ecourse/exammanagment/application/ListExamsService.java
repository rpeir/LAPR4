package eapli.ecourse.exammanagment.application;

import eapli.ecourse.courseenrollement.application.ListCourseEnrollmentsService;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExamsService {

    private final AuthorizationService authz;
    private final CourseEnrollmentRepository courseEnrollments;
    private final ExamRepository exams;
    private final ExamExecutionRepository examExecutions;

    public ListExamsService(AuthorizationService authz, CourseEnrollmentRepository courseEnrollments, ExamRepository exams){
        this.authz = authz;
        this.courseEnrollments = courseEnrollments;
        this.exams = exams;
        this.examExecutions = PersistenceContext.repositories().examExecutions();
    }

    public ListExamsService(AuthorizationService authz, CourseEnrollmentRepository courseEnrollments, ExamRepository exams, ExamExecutionRepository examExecutions){
        this.authz = authz;
        this.courseEnrollments = courseEnrollments;
        this.exams = exams;
        this.examExecutions = examExecutions;
    }

    public ListExamsService() {
        this.authz = AuthzRegistry.authorizationService();
        this.courseEnrollments = PersistenceContext.repositories().courseEnrollments();
        this.exams = PersistenceContext.repositories().exams();
        this.examExecutions = PersistenceContext.repositories().examExecutions();
    }

    public List<Exam> availableExams(Student student) {
        Iterable<Course> studentCourses = new ListCourseEnrollmentsService(authz, courseEnrollments).coursesImEnrolled();

        List<Exam> studentExams = new LinkedList<>();
        List<ExamExecution> studentExamExecutions = (List<ExamExecution>) examExecutions.findByStudent(student);
        for (Course course : studentCourses) {
            for (Exam exam : exams.findByCourse(course)) {
                if (exam.isAvaliable()) {
                    boolean alreadyTookExam = false;
                    for (ExamExecution examExecution : studentExamExecutions) {
                        if (examExecution.exam().equals(exam)) {
                            alreadyTookExam = true;
                            break;
                        }
                    }
                    if (!alreadyTookExam) {
                        studentExams.add(exam);
                    }
                }
            }
        }
        return new ArrayList<>(studentExams);
    }

    public Iterable<ExamExecution> listStudentGrades(Student student){
        return examExecutions.findByStudent(student);
    }

    public Iterable<ExamExecution> findByCourse(Course course) {
        return examExecutions.findByCourse(course);
    }
}
