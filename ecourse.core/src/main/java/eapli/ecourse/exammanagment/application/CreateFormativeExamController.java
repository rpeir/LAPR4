package eapli.ecourse.exammanagment.application;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagment.antlr4.formativeexam.FormativeExamLexer;
import eapli.ecourse.exammanagment.antlr4.formativeexam.FormativeExamParser;
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

public class CreateFormativeExamController {

    private final AuthorizationService authz;
    private final CourseRepository courses;
    private final ExamRepository exams;

    public CreateFormativeExamController(AuthorizationService authz, CourseRepository courses, ExamRepository exams) {
        this.authz = authz;
        this.courses = courses;
        this.exams = exams;
    }

    public CreateFormativeExamController() {
        authz = AuthzRegistry.authorizationService();
        courses = PersistenceContext.repositories().courses();
        exams = PersistenceContext.repositories().exams();
    }

    public Exam createExam(String filePath, Course course) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);

        FormativeExamParser parser = startGrammar(filePath);
        ParseTree tree = parser.start(); // parse
        return exams.save(parseWithListener(tree, course));
    }


    private FormativeExamParser startGrammar(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);
        FormativeExamLexer lexer = new FormativeExamLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new FormativeExamParser(tokens);
    }

    private Exam parseWithListener(ParseTree tree, Course course){
        ParseTreeWalker walker = new ParseTreeWalker();
        CreateFormativeExamListener eListener = new CreateFormativeExamListener(course);
        walker.walk(eListener, tree);
        return eListener.getExam();
    }

    public Iterable<Course> listCourses() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        return new ListCourseService(authz, courses).availableCoursesTeacher(authz.session().get().authenticatedUser().email());
    }

}
