package eapli.ecourse.examExecution.application;

import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.examExecution.domain.ExamExecutionBuilder;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.application.ListExamsService;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.question.domain.*;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TakeExamController {

    private final AuthorizationService authz;
    private final ExamRepository exams;
    private final CourseEnrollmentRepository courseEnrollments;
    private final StudentRepository students;
    private final ExamExecutionBuilder builder = new ExamExecutionBuilder();
    private final ExamExecutionRepository examExecutions;

    public TakeExamController() {
        authz = AuthzRegistry.authorizationService();
        exams = PersistenceContext.repositories().exams();
        courseEnrollments = PersistenceContext.repositories().courseEnrollments();
        students = PersistenceContext.repositories().students();
        examExecutions = PersistenceContext.repositories().examExecutions();
    }

    public List<Exam> availableExams() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        Student student = students.findByEmail(authz.session().get().authenticatedUser().email().toString()).orElseThrow();
        return new ListExamsService(authz, courseEnrollments, exams, examExecutions).availableExams(student);
    }

    public ExamExecution finishExam() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        return examExecutions.save(builder.build());
    }

    public void startExam(Exam exam) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        Student student = students.findByEmail(authz.session().get().authenticatedUser().email().toString()).orElseThrow();
        builder.ofStudent(student);
        builder.ofExam(exam);
    }

    public void answerTrueFalseQuestion(TrueOrFalseQuestion tfQuestion, boolean answer, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(tfQuestion.answer(answer,grade));
    }

    public void answerSingleChoiceQuestion(SingleChoiceQuestion scQuestion, String answer, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(scQuestion.answer(answer,grade));
    }

    public void answerShortAnswerQuestion(ShortAnswerQuestion saQuestion, String answer, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(saQuestion.answer(answer,grade));
    }

    public void answerNumericQuestion(NumericalQuestion nQuestion, int answer, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(nQuestion.answer(answer,grade));
    }

    public void answerMultipleChoiceQuestion(MultipleChoiceQuestion mcQuestion, Set<String> answer, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(mcQuestion.answer(answer,grade));
    }

    public void answerMissingWordQuestion(MissingWordQuestion mQuestion, Map<String, String> answers, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(mQuestion.answer(answers,grade));
    }

    public void answerMatchingQuestion(MatchingQuestion mQuestion, Map<String, Integer> answer, float grade) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT_USER);
        builder.withQuestionAnswer(mQuestion.answer(answer, grade));
    }
}
