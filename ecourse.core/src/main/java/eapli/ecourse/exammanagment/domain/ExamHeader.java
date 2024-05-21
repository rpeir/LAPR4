package eapli.ecourse.exammanagment.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;

import javax.persistence.*;

/**
 * Header of an Exam
 */
@Embeddable
public class ExamHeader implements ValueObject {

    /**
     * Description of the exam header
     */
    @Embedded
    private Description description;

    /**
     * Grade type of the exam
     */
    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    /**
     * Feedback type of the exam
     */
    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType;

    public ExamHeader(String description, GradeType gradeType, FeedbackType feedbackType) {
        setDescription(description);
        this.gradeType = gradeType;
        this.feedbackType = feedbackType;
    }

    protected ExamHeader() {
        // for ORM only
    }

    private void setDescription(String description) {
        this.description = Description.valueOf(description);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ExamHeader)) {
            return false;
        }
        final ExamHeader other = (ExamHeader) obj;
        return description.equals(other.description) &&
                gradeType.equals(other.gradeType) &&
                feedbackType.equals(other.feedbackType);
    }

    @Override
    public String toString() {
        return String.format("%s\n\tGrade Type: %s\n\tFeedback Type: %s",description.toString(), gradeType, feedbackType);
    }

    public GradeType gradeType() {
        return gradeType;
    }

    public FeedbackType feedbackType() {
        return feedbackType;
    }
}
