package eapli.ecourse.app.student.console.presentation.examExecution;

import eapli.ecourse.app.student.console.presentation.StudentBaseUI;
import eapli.ecourse.examExecution.application.TakeExamController;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.exammanagment.domain.*;
import eapli.ecourse.question.domain.*;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TakeExamService extends StudentBaseUI implements Runnable {

    private final Exam exam;

    private final TakeExamController theController;

    public TakeExamService(Exam exam, TakeExamController theController) {
        this.exam = exam;
        this.theController = theController;
    }

    public TakeExamService(Exam exam) {
        this(exam, new TakeExamController());
    }

    @Override
    protected boolean doShow() {
        try {
            theController.startExam(exam);
            printHeader(exam);
            int j = 1;
            for (Section section : exam.sections()) {
                printSectionHeader(j++, section);
                int i = 1;
                for (Question question : section.questions()) {
                    System.out.println(i++ + ")");
                    takeQuestion(question, section.grade(question));
                    drawFormSeparator();
                }
            }
            System.out.println("Exam Finished");
            drawFormSeparator();
            ExamExecution takenExam = theController.finishExam();
            if (!exam.header().gradeType().equals(GradeType.NONE)) {
                System.out.printf("Exam Grade: %.2f\n", takenExam.grade());
            }
            if (!exam.header().feedbackType().equals(FeedbackType.NONE)) {
                System.out.println("\nExam Feedback:\n");
                System.out.println(takenExam.feedback());
            }
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred while taking the exam");
            e.printStackTrace();
            return false;
        }
    }

    private void printHeader(Exam exam) {
        drawFormTitle(String.format("%s Exam [ %s ]", exam.course(), exam.title()));
        if (exam instanceof SummativeExam) {
            SummativeExam sExam = (SummativeExam) exam;
            System.out.printf("\tDuration: %s -> %s", sExam.openDate(), sExam.closeDate());
        } else {
            System.out.println("\tFomative Exam");
        }
        System.out.println("\n\t"+exam.header());
        System.out.println();
        drawFormBorder();
    }


    private void takeQuestion(Question question, float grade) {
        switch (question.getClass().getSimpleName()) {
            case "MatchingQuestion":
                takeMatchingQuestion(question,grade);
                break;
            case "MissingWordQuestion":
                takeMissingWordQuestion(question,grade);
                break;
            case "MultipleChoiceQuestion":
                takeMultipleChoiceQuestion(question,grade);
                break;
            case "NumericalQuestion":
                takeNumericQuestion(question,grade);
                break;
            case "ShortAnswerQuestion":
                takeShortAnswerQuestion(question,grade);
                break;
            case "SingleChoiceQuestion":
                takeSingleChoiceQuestion(question,grade);
                break;
            case "TrueOrFalseQuestion":
                takeTrueOrFalseQuestion(question,grade);
                break;
            default:
                System.out.printf("Question type %s not supported\n", question.getClass().getSimpleName());
                break;
        }
    }

    private void takeTrueOrFalseQuestion(Question question, float grade) {
        if (!(question instanceof TrueOrFalseQuestion)) {
            System.out.println("Question is not a True or False Question");
            return;
        }
        TrueOrFalseQuestion tfQuestion = (TrueOrFalseQuestion) question;
        System.out.printf("True or False: %s\n", tfQuestion.questionDescription());
        boolean boolAnswer = false, validAnswer = false;
        do {
            String answer = Console.readNonEmptyLine("Answer: ", "Answer can't be empty");
            switch (answer.toLowerCase()) {
                case "true":
                    boolAnswer = true;
                    validAnswer = true;
                    break;
                case "false":
                    validAnswer = true;
                    break;
                default:
                    System.out.println("Invalid answer! Please answer with true or false");
                    break;
            }
        } while(!validAnswer);
        theController.answerTrueFalseQuestion(tfQuestion,boolAnswer,grade);
    }

    private void takeSingleChoiceQuestion(Question question, float grade) {
        if (!(question instanceof SingleChoiceQuestion)) {
            System.out.println("Question is not a Single Choice Question");
            return;
        }
        SingleChoiceQuestion scQuestion = (SingleChoiceQuestion) question;
        System.out.printf("Single Choice: %s\nOptions:\n", scQuestion.questionDescription());
        for (var entry : scQuestion.options().entrySet())
            System.out.printf("\t%s - %s\n", entry.getKey(), entry.getValue());
        do {
            String answer = Console.readNonEmptyLine("Answer: ", "Answer can't be empty");
            answer = answer.trim();
            if (scQuestion.options().containsKey(answer)) {
                theController.answerSingleChoiceQuestion(scQuestion,answer,grade);
                return;
            } else {
                System.out.println("Invalid answer! Please answer with one of the options");
            }
        } while(true);
    }

    private void takeShortAnswerQuestion(Question question, float grade) {
        if (!(question instanceof ShortAnswerQuestion)) {
            System.out.println("Question is not a Short Answer Question");
            return;
        }
        ShortAnswerQuestion saQuestion = (ShortAnswerQuestion) question;
        System.out.printf("Short Answer: %s\n", saQuestion.questionDescription());
        String answer = Console.readNonEmptyLine("Answer: ", "Answer can't be empty");
        theController.answerShortAnswerQuestion(saQuestion,answer,grade);
    }

    private void takeNumericQuestion(Question question, float grade) {
        if (!(question instanceof NumericalQuestion)) {
            System.out.println("Question is not a Numeric Question");
            return;
        }
        NumericalQuestion nQuestion = (NumericalQuestion) question;
        System.out.printf("Numeric: %s\n", nQuestion.questionDescription());
        int answer = Console.readInteger("Answer: ");
        theController.answerNumericQuestion(nQuestion,answer,grade);
    }

    private void takeMultipleChoiceQuestion(Question question, float grade) {
        if (!(question instanceof MultipleChoiceQuestion)) {
            System.out.println("Question is not a Multiple Choice Question");
            return;
        }
        MultipleChoiceQuestion mcQuestion = (MultipleChoiceQuestion) question;

        boolean isValid = false;
        do {
            System.out.printf("Multiple Choice: %s\nOptions:\n", mcQuestion.questionDescription());
            for (var entry : mcQuestion.options().entrySet())
                System.out.printf("\t%s - %s\n", entry.getKey(), entry.getValue());
            String answerRaw = Console.readNonEmptyLine("Answer (type the letter of the options, separated by \",\"): ", "Answer can't be empty");
            String[] answers = answerRaw.split(",");
            boolean validAnswer = true;
            for (String s : answers) {
                s = s.trim().toLowerCase();
                if (!mcQuestion.options().containsKey(s)) {
                    System.out.printf("Invalid option %s\n", s);
                    validAnswer = false;
                    break;
                }
            }
            if (!validAnswer) continue;
            Set<String> answer = Set.of(answers);
            try {
                theController.answerMultipleChoiceQuestion(mcQuestion,answer,grade);
                isValid = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
    }

    private void takeMissingWordQuestion(Question question, float grade) {
        if (!(question instanceof MissingWordQuestion)) {
            System.out.println("Question is not a Missing Word Question");
            return;
        }
        MissingWordQuestion mQuestion = (MissingWordQuestion) question;

        boolean isValid = false;
        do {
            printMissingWordQuestionHeader(mQuestion);

            Map<String, String> answers = new HashMap<>();
            for (var entry : mQuestion.options().entrySet()) {
                SelectWidget<String> sw;
                do {
                    sw = new SelectWidget<>("\nSelect an option for " + entry.getKey(), entry.getValue());
                    sw.show();
                } while (sw.selectedOption() == 0);
                answers.put(entry.getKey(), sw.selectedElement());
            }
            try {
                theController.answerMissingWordQuestion(mQuestion,answers,grade);
                isValid = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
    }

    private void printMissingWordQuestionHeader(MissingWordQuestion mQuestion) {
        System.out.println("Missing Word: "+mQuestion.questionDescription()+"\n");
        System.out.println(mQuestion.missingPhrase());
        System.out.println("\nOptions:");
        for (var entry : mQuestion.options().entrySet()) {
            printMissingWordOptions(entry);
        }
    }

    private void printMissingWordOptions(Map.Entry<String, ArrayList<String>> entry) {
        System.out.print("\t" + entry.getKey() + " - ");
        for (int i = 0; i < entry.getValue().size(); i++) {
            System.out.print(entry.getValue().get(i));
            if (i < entry.getValue().size() - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    private void takeMatchingQuestion(Question question, float grade) {
        if (!(question instanceof MatchingQuestion)) {
            System.out.println("Question is not a Matching Question");
            return;
        }
        MatchingQuestion mQuestion = (MatchingQuestion) question;
        boolean isValid = false;
        do {
            printMatchingQuestionHeader(mQuestion);

            int answered = 0;
            Map<String, Integer> answer = new HashMap<>();
            while (answered < Integer.min(mQuestion.groupA().size(), mQuestion.groupB().size())) { // while not all questions are answered
                String a;
                int b;
                do { // ask for valid key
                    a = Console.readNonEmptyLine("Enter a key from Group A: ", "Answer can't be empty");
                } while (!mQuestion.groupA().containsKey(a));
                do { // ask for valid value
                    b = Console.readInteger("Enter a key from Group B: ");
                } while (!mQuestion.groupB().containsKey(b));

                if (!answer.containsKey(a)) answered++;
                answer.put(a, b);
                System.out.printf("Answer recorded %s - %d\n",a, b);
            }
            try {
                theController.answerMatchingQuestion(mQuestion,answer,grade);
                isValid = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
    }

    private void printMatchingQuestionHeader(MatchingQuestion mQuestion) {
        System.out.println("Matching Question: "+mQuestion.questionDescription());
        System.out.println("Group A:");
        for (var entry : mQuestion.groupA().entrySet())
            System.out.printf("\t%s - %s\n", entry.getKey(), entry.getValue());
        System.out.println("Group B:");
        for (var entry : mQuestion.groupB().entrySet())
            System.out.printf("\t%d - %s\n", entry.getKey(), entry.getValue());
    }

    private void printSectionHeader(int i, Section section) {
        drawFormTitle(String.format("Section %d [ %s ]", i, section.description()));
    }

    @Override
    public void run() {
        doShow();
    }
}
