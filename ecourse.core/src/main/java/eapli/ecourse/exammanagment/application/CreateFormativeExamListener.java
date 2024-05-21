package eapli.ecourse.exammanagment.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.antlr4.formativeexam.FormativeExamBaseListener;
import eapli.ecourse.exammanagment.antlr4.formativeexam.FormativeExamParser;
import eapli.ecourse.exammanagment.domain.*;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.question.domain.*;
import eapli.ecourse.question.repositories.QuestionRepository;

import java.util.*;

public class CreateFormativeExamListener extends FormativeExamBaseListener {

    private final Iterable<Question> matchingQuestions;
    private final Iterable<Question> missingWordQuestions;
    private final Iterable<Question> multipleChoiceQuestions;
    private final Iterable<Question> numericalQuestions;
    private final Iterable<Question> shortAnswerQuestions;
    private final Iterable<Question> singleChoiceQuestions;
    private final Iterable<Question> trueOrFalseQuestions;
    private final FormativeExamBuilder examBuilder = new FormativeExamBuilder();
    private Set<Question> questions = new HashSet<>();
    private Map<Question, Float> questionWeights = new HashMap<>();

    private List<Question> shuffleList(List<Question> list) {
        Collections.shuffle(list);
        return list;
    }

    public CreateFormativeExamListener(QuestionRepository questions, Course course) {
        String theme = course.identity();
        this.examBuilder.withCourse(course);
        this.matchingQuestions = shuffleList(questions.findAllMatchingQuestionsByTheme(theme));
        this.missingWordQuestions = shuffleList(questions.findAllMissingWordQuestionsByTheme(theme));
        this.multipleChoiceQuestions = shuffleList(questions.findAllMultipleChoiceQuestionsByTheme(theme));
        this.numericalQuestions = shuffleList(questions.findAllNumericalQuestionsByTheme(theme));
        this.shortAnswerQuestions = shuffleList(questions.findAllShortAnswerQuestionsByTheme(theme));
        this.singleChoiceQuestions = shuffleList(questions.findAllSingleChoiceQuestionsByTheme(theme));
        this.trueOrFalseQuestions = shuffleList(questions.findAllTrueOrFalseQuestionsByTheme(theme));
    }

    public CreateFormativeExamListener(Course course) {
        String theme = course.identity();
        this.examBuilder.withCourse(course);
        QuestionRepository questions = PersistenceContext.repositories().questions();
        this.matchingQuestions = shuffleList(questions.findAllMatchingQuestionsByTheme(theme));
        this.missingWordQuestions = shuffleList(questions.findAllMissingWordQuestionsByTheme(theme));
        this.multipleChoiceQuestions = shuffleList(questions.findAllMultipleChoiceQuestionsByTheme(theme));
        this.numericalQuestions = shuffleList(questions.findAllNumericalQuestionsByTheme(theme));
        this.shortAnswerQuestions = shuffleList(questions.findAllShortAnswerQuestionsByTheme(theme));
        this.singleChoiceQuestions = shuffleList(questions.findAllSingleChoiceQuestionsByTheme(theme));
        this.trueOrFalseQuestions = shuffleList(questions.findAllTrueOrFalseQuestionsByTheme(theme));
    }

    @Override
    public void exitMatchingQuestion(FormativeExamParser.MatchingQuestionContext ctx) {
        if (matchingQuestions.iterator().hasNext()) {
            Question question = matchingQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough matching questions to create the exam");
    }

    @Override
    public void exitNumericalQuestion(FormativeExamParser.NumericalQuestionContext ctx) {
        if (numericalQuestions.iterator().hasNext()) {
            Question question = numericalQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough numerical questions to create the exam");
    }

    @Override
    public void exitSingleChoiceQuestion(FormativeExamParser.SingleChoiceQuestionContext ctx) {
        if (singleChoiceQuestions.iterator().hasNext()) {
            Question question = singleChoiceQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough single choice questions to create the exam");
    }

    @Override
    public void exitMultipleChoiceQuestion(FormativeExamParser.MultipleChoiceQuestionContext ctx) {
        if (multipleChoiceQuestions.iterator().hasNext()) {
            Question question = multipleChoiceQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough multiple choice questions to create the exam");
    }

    @Override
    public void exitMissingWordsQuestion(FormativeExamParser.MissingWordsQuestionContext ctx) {
        if (missingWordQuestions.iterator().hasNext()) {
            Question question = missingWordQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough missing word questions to create the exam");
    }

    @Override
    public void exitTrueFalseQuestion(FormativeExamParser.TrueFalseQuestionContext ctx) {
        if (trueOrFalseQuestions.iterator().hasNext()) {
            Question question = trueOrFalseQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough true or false questions to create the exam");
    }

    @Override
    public void exitShortAnsweQuestion(FormativeExamParser.ShortAnsweQuestionContext ctx) {
        if (shortAnswerQuestions.iterator().hasNext()) {
            Question question = shortAnswerQuestions.iterator().next();
            questions.add(question);
            questionWeights.put(question, Float.parseFloat(ctx.cotacao().NUMERO().getText()));
        } else
            throw new IllegalStateException("There is not enough short answer questions to create the exam");
    }


    @Override
    public void exitSeccao(FormativeExamParser.SeccaoContext ctx) {
        StringBuilder result = new StringBuilder();
        int size = ctx.regraMensagem().frase().size();
        for (int i = 0; i < size; i++) {
            result.append(ctx.regraMensagem().frase(i).getText()).append(ctx.regraMensagem().pontucao(i).getText());
        }
        examBuilder.withSection(result.toString(), questions, questionWeights);
        questions = new HashSet<>();
        questionWeights = new HashMap<>();
    }

    @Override
    public void exitRegraTituloExame(FormativeExamParser.RegraTituloExameContext ctx) {
        examBuilder.withTitle(ctx.frase().getText());
    }

    @Override
    public void exitRegraHeaderExame(FormativeExamParser.RegraHeaderExameContext ctx) {
        StringBuilder result = new StringBuilder();
        int size = ctx.regraMensagem().frase().size();
        for (int i = 0; i < size; i++) {
            result.append(ctx.regraMensagem().frase(i).getText()).append(ctx.regraMensagem().pontucao(i).getText());
        }
        String grade = ctx.grade().frase().getText();
        String feedback = ctx.feedback().frase().getText();
        examBuilder.withExamHeader(result.toString(), GradeType.valueOf(grade.toUpperCase()), FeedbackType.valueOf(feedback.toUpperCase()));
    }

    public Exam getExam() {
        return examBuilder.build();
    }


}
