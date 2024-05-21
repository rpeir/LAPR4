package eapli.ecourse.exammanagment.application;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagment.antlr4.exam.ExamLexer;
import eapli.ecourse.exammanagment.antlr4.exam.ExamParser;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.Date;

public class CreateExamController {

    private final AuthorizationService authz;
    private final CourseRepository courses;
    private final ExamRepository exams;

    public CreateExamController(AuthorizationService authz, CourseRepository courses, ExamRepository exams) {
        this.authz = authz;
        this.courses = courses;
        this.exams = exams;
    }

    public CreateExamController() {
        authz = AuthzRegistry.authorizationService();
        courses = PersistenceContext.repositories().courses();
        exams = PersistenceContext.repositories().exams();
    }

    public Exam createExam(String filePath, Course course, Date open, Date close) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);

        ExamParser parser = startGrammar(filePath);
        ParseTree tree = parser.start(); // parse
        return exams.save(parseWithListener(tree, course, open, close));
    }


    private ExamParser startGrammar(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);
        ExamLexer lexer = new ExamLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new ExamParser(tokens);
    }

    private Exam parseWithListener(ParseTree tree, Course course, Date open, Date close){
        ParseTreeWalker walker = new ParseTreeWalker();
        CreateExamListener eListener = new CreateExamListener(course, open, close);
        walker.walk(eListener, tree);
        return eListener.getExam();
    }

    public Iterable<Course> listCourses() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        return new ListCourseService(authz, courses).availableCoursesTeacher(authz.session().get().authenticatedUser().email());
    }
}
