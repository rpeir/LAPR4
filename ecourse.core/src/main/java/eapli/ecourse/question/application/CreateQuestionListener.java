// Generated from C:/Users/Delcio Monjane/Documents/ISEP/2o Ano/sem4/sem4pi-22-23-44/ecourse.app.teacher.console/src/main/java/eapli/ecourse/app/teacher/console/presentation/exammanagement\Exam.g4 by ANTLR 4.12.0
package eapli.ecourse.question.application;

import eapli.ecourse.exammanagment.antlr4.exam.ExamBaseListener;
import eapli.ecourse.exammanagment.antlr4.exam.ExamListener;
import eapli.ecourse.exammanagment.antlr4.exam.ExamParser;
import eapli.ecourse.question.domain.*;

import java.util.*;

/**
 * This class provides an empty implementation of {@link ExamListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class CreateQuestionListener extends ExamBaseListener {
    private String questionType;
    private String questionDescription;
    private String options;
    private String acceptanceError;
    private String groupA;
    private String groupB;
    private String questionTheme;
    private String solution;

    private Set<Question> questionsSet = new HashSet<>();

    public Set<Question> getQuestionsSet() {
        return questionsSet;
    }

    private Map<String, Integer> shortAnswerSolution = new HashMap<>();

    private Map<String, String> multiChoiceOptions = new HashMap<>();

    Map<String, ArrayList<String>> missingOptionsMap = new HashMap<>();
    Map<String, String> missingSolutions = new HashMap<>();

    private String missingPhrase;

    public MatchingQuestion createMatchingQuestion() {
        String[] grouAarray = groupA.split(",");
        Map<String, String> groupAMap = new HashMap<>();
        for (String s : grouAarray) {
            String[] subString = s.split("-");
            groupAMap.put(subString[0], subString[1]);
        }

        String[] grouBarray = groupB.split(",");
        Map<Integer, String> groupBMap = new HashMap<>();
        for (String s : grouBarray) {
            String[] subString = s.split("-");
            groupBMap.put(Integer.valueOf(subString[0]), subString[1]);
        }

        String[] solutionArray = solution.split(",");
        Map<String, Integer> solutionMap = new HashMap<>();
        for (String s : solutionArray) {
            String[] subString = s.split("-");
            solutionMap.put(subString[0], Integer.valueOf(subString[1]));
        }

        return new MatchingQuestion(questionTheme, questionDescription, groupAMap, groupBMap, solutionMap);
    }

    public MultipleChoiceQuestion createMultipleChoiceQuestion() {
        String[] solutionArray = solution.split(",");
        Set<String> solutionSet = new HashSet<>(Arrays.asList(solutionArray));
        return new MultipleChoiceQuestion(questionTheme, questionDescription, solutionSet, multiChoiceOptions);
    }

    public SingleChoiceQuestion createSingleChoiceQuestion() {
        return new SingleChoiceQuestion(questionTheme, questionDescription, multiChoiceOptions, solution);
    }

    public TrueOrFalseQuestion createTrueOrFalseQuestion() {
        return new TrueOrFalseQuestion(questionTheme, questionDescription, solution);
    }

    public NumericalQuestion createNumericalQuestion() {
        int var1 = Integer.parseInt(solution);
        int var2 = Integer.parseInt(acceptanceError);
        return new NumericalQuestion(questionTheme, questionDescription, var1, var2);
    }

    public ShortAnswerQuestion createShortAnswerQuestion() {
        return new ShortAnswerQuestion(questionTheme, questionDescription, shortAnswerSolution);
    }

    public MissingWordQuestion createMissingWordsQuestion() {
        return new MissingWordQuestion(questionTheme, questionDescription, missingOptionsMap, missingSolutions, missingPhrase);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStartPergunta(ExamParser.StartPerguntaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStartPergunta(ExamParser.StartPerguntaContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPergunta(ExamParser.PerguntaContext ctx) {
        questionTheme = String.valueOf(ctx.theme.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPergunta(ExamParser.PerguntaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterRegraPergunta(ExamParser.RegraPerguntaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitRegraPergunta(ExamParser.RegraPerguntaContext ctx) {
        questionDescription = String.valueOf(ctx.description.getText()) + String.valueOf(ctx.ponto.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMatchingQuestion(ExamParser.MatchingQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMatchingQuestion(ExamParser.MatchingQuestionContext ctx) {
        questionType = String.valueOf(ctx.tipo.getText());
        groupA = String.valueOf(ctx.groupA.getText());
        groupB = String.valueOf(ctx.groupB.getText());
        solution = String.valueOf(ctx.mSolution.getText());
        questionsSet.add(createMatchingQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNumericalQuestion(ExamParser.NumericalQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNumericalQuestion(ExamParser.NumericalQuestionContext ctx) {
        this.questionType = String.valueOf(ctx.tipo.getText());
        this.acceptanceError = String.valueOf(ctx.acpError.getText());
        this.solution = String.valueOf(ctx.nSolution.getText());
        questionsSet.add(createNumericalQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSingleChoiceQuestion(ExamParser.SingleChoiceQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSingleChoiceQuestion(ExamParser.SingleChoiceQuestionContext ctx) {
        this.questionType = String.valueOf(ctx.tipo.getText());
        this.solution = String.valueOf(ctx.scSolution.getText());
        questionsSet.add(createSingleChoiceQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx) {
        this.questionType = String.valueOf(ctx.tipo.getText());
        this.solution = String.valueOf(ctx.mcSolution.getText());
        questionsSet.add(createMultipleChoiceQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx) {
        questionType = String.valueOf(ctx.tipo.getText());
        String stringOptions = String.valueOf(ctx.opMissing.getText());
        String[] arrayOptions = stringOptions.split(System.lineSeparator());
        for (String s: arrayOptions) {
            String[] subS = s.split(" ");
            String[] arrayOfWords = subS[1].split(",");
            ArrayList<String> stringSet = new ArrayList<>(Arrays.asList(arrayOfWords));
            this.missingOptionsMap.put(subS[0],stringSet);
        }
        String stringSolutions = String.valueOf(ctx.missSolution.getText());
        String[] arraySolutions = stringSolutions.split(System.lineSeparator());
        for (String s: arraySolutions) {
            String[] subS = s.split(" ");
            this.missingSolutions.put(subS[0],subS[1]);
        }
        StringBuilder missingPhraseBuilder = new StringBuilder();
        for (int i = 0; i < ctx.fraseMissing().size(); i++) {
            missingPhraseBuilder.append(ctx.fraseMissing().get(i).getText());
        }
        missingPhrase = missingPhraseBuilder.toString();
        questionsSet.add(createMissingWordsQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx) {
        this.questionType = String.valueOf(ctx.tipo.getText());
        this.solution = String.valueOf(ctx.tfSolution.getText());
        questionsSet.add(createTrueOrFalseQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterShortAnsweQuestion(ExamParser.ShortAnsweQuestionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitShortAnsweQuestion(ExamParser.ShortAnsweQuestionContext ctx) {
        this.questionType = String.valueOf(ctx.tipo.getText());
        String sol = String.valueOf(ctx.shortSolution.getText());
        sol = sol.trim();
        String[] strings = sol.split(System.lineSeparator());
        for (String s : strings) {
            String[] subS = s.split("-");
            this.shortAnswerSolution.put(subS[1],Integer.valueOf(subS[0]));
        }
        questionsSet.add(createShortAnswerQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitOpcao(ExamParser.OpcaoContext ctx) {
        String opcaoID = String.valueOf(ctx.opcaoID.getText());
        String opcaoDescription = String.valueOf(ctx.opcaoDescription.getText());
        multiChoiceOptions.put(opcaoID, opcaoDescription);
    }

}