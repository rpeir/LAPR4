package eapli.ecourse.question.application;

import eapli.ecourse.exammanagment.antlr4.exam.ExamLexer;
import eapli.ecourse.exammanagment.antlr4.exam.ExamParser;
import eapli.ecourse.question.domain.Question;
import eapli.ecourse.question.repositories.QuestionRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CreateQuestionController {

    private final AuthorizationService authz;
    private final QuestionRepository repo;

    public CreateQuestionController(AuthorizationService authz, QuestionRepository repo) {
        this.authz = authz;
        this.repo = repo;
    }


    public void createQuestions(String filePath){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.TEACHER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        try {
            startGrammar(filePath);
        } catch (IOException e) {
            System.out.println("Invalid File");
        }
    }
    public void startGrammar(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);
        ExamLexer lexer = new ExamLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamParser parser = new ExamParser(tokens);
        ParseTree tree = parser.startPergunta(); // parse
        parseWithListener(tree);
    }

    public void parseWithListener(ParseTree tree) throws IOException {
        ParseTreeWalker walker = new ParseTreeWalker();
        CreateQuestionListener eListener = new CreateQuestionListener();
        walker.walk(eListener, tree);
        Set<Question> questionSet = new HashSet<>();
        questionSet = eListener.getQuestionsSet();
        for (Question q:questionSet) {
            this.repo.save(q);
        }
    }
}
