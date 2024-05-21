package eapli.ecourse.question.domain;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class QuestionTheme {
    private  String questionSubject;

    public QuestionTheme() {
        //ORM
    }

    @Override
    public String toString() {
        return  questionSubject ;
    }

    public QuestionTheme(String questionSubject) {
        this.questionSubject = questionSubject;
    }

    public String questionSubject() {
        return questionSubject;
    }
}
