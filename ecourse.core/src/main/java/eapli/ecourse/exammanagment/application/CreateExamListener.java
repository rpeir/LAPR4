package eapli.ecourse.exammanagment.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.antlr4.exam.ExamBaseListener;
import eapli.ecourse.exammanagment.antlr4.exam.ExamParser;
import eapli.ecourse.exammanagment.domain.*;
import eapli.ecourse.question.domain.*;

import java.util.*;

public class CreateExamListener extends ExamBaseListener {

    // Exam
    private SummativeExamBuilder summativeExamBuilder;

    // Section
    private final String questionTheme;
    private Set<Question> questions = new HashSet<>();
    private Map<Question, Float> questionWeights = new HashMap<>();
    //Question
    private String questionDescription;
    private String acceptanceError;
    private String groupA;
    private String groupB;
    private String solution;
    private Map<String, Integer> shortAnswerSolution = new HashMap<>();

    private Map<String, String> multiChoiceOptions = new HashMap<>();

    Map<String, ArrayList<String>> missingOptionsMap = new HashMap<>();
    Map<String, String> missingSolutions = new HashMap<>();

    private String missingPhrase;

    public CreateExamListener(final Course course, final Date openDate,final Date closeDate) {
        this.questionTheme = course.identity();
        summativeExamBuilder = new SummativeExamBuilder();
        summativeExamBuilder.withCourse(course);
        summativeExamBuilder.withOpenDate(openDate);
        summativeExamBuilder.withCloseDate(closeDate);
    }

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

    @Override
    public void exitRegraPergunta(ExamParser.RegraPerguntaContext ctx) {
        questionDescription = String.valueOf(ctx.description.getText()) + String.valueOf(ctx.ponto.getText());
    }

    @Override
    public void exitMatchingQuestion(ExamParser.MatchingQuestionContext ctx) {
        groupA = String.valueOf(ctx.groupA.getText());
        groupB = String.valueOf(ctx.groupB.getText());
        solution = String.valueOf(ctx.mSolution.getText());
        Question question = createMatchingQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitNumericalQuestion(ExamParser.NumericalQuestionContext ctx) {
        this.acceptanceError = String.valueOf(ctx.acpError.getText());
        this.solution = String.valueOf(ctx.nSolution.getText());
        Question question = createNumericalQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitSingleChoiceQuestion(ExamParser.SingleChoiceQuestionContext ctx) {
        this.solution = String.valueOf(ctx.scSolution.getText());
        Question question = createSingleChoiceQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx) {
        this.solution = String.valueOf(ctx.mcSolution.getText());
        Question question = createMultipleChoiceQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx) {
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
        Question question = createMissingWordsQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx) {
        this.solution = String.valueOf(ctx.tfSolution.getText());
        Question question = createTrueOrFalseQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitShortAnsweQuestion(ExamParser.ShortAnsweQuestionContext ctx) {
        String sol = String.valueOf(ctx.shortSolution.getText());
        sol = sol.trim();
        String[] strings = sol.split(System.lineSeparator());
        for (String s : strings) {
            String[] subS = s.split("-");
            this.shortAnswerSolution.put(subS[1],Integer.valueOf(subS[0]));
        }
        Question question = createShortAnswerQuestion();
        questions.add(question);
        questionWeights.put(question, Float.valueOf(ctx.cotacao().NUMERO().getText()));
    }

    @Override
    public void exitOpcao(ExamParser.OpcaoContext ctx) {
        String opcaoID = String.valueOf(ctx.opcaoID.getText());
        String opcaoDescription = String.valueOf(ctx.opcaoDescription.getText());
        multiChoiceOptions.put(opcaoID, opcaoDescription);
    }

    @Override
    public void exitSeccao(ExamParser.SeccaoContext ctx) {
        StringBuilder result = new StringBuilder();
        int size = ctx.regraMensagem().frase().size();
        for (int i = 0; i < size; i++) {
            result.append(ctx.regraMensagem().frase(i).getText()).append(ctx.regraMensagem().pontucao(i).getText());
        }
        summativeExamBuilder.withSection(result.toString(), questions, questionWeights);
        questions = new HashSet<>();
        questionWeights = new HashMap<>();
    }

    @Override
    public void exitRegraTituloExame(ExamParser.RegraTituloExameContext ctx) {
        summativeExamBuilder.withTitle(ctx.frase().getText());
    }

    @Override
    public void exitRegraHeaderExame(ExamParser.RegraHeaderExameContext ctx) {
        StringBuilder result = new StringBuilder();
        int size = ctx.regraMensagem().frase().size();
        for (int i = 0; i < size; i++) {
            result.append(ctx.regraMensagem().frase(i).getText()).append(ctx.regraMensagem().pontucao(i).getText());
        }
        String grade = ctx.grade().frase().getText();
        String feedback = ctx.feedback().frase().getText();
        summativeExamBuilder.withExamHeader(result.toString(), GradeType.valueOf(grade.toUpperCase()), FeedbackType.valueOf(feedback.toUpperCase()));
    }

    public Exam getExam() {
        return summativeExamBuilder.build();
    }
}
