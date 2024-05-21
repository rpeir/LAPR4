package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.question.domain.Question;
import eapli.framework.domain.model.DomainFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class ExamBuilder implements DomainFactory<Exam> {

    protected String title;
    protected ExamHeader examHeader;
    protected Set<Section> sections = new HashSet<>();
    protected Course course;

    public ExamBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ExamBuilder withExamHeader(String examHeader, GradeType gradeType, FeedbackType feedbackType) {
        this.examHeader = new ExamHeader(examHeader, gradeType, feedbackType);
        return this;
    }

    public ExamBuilder withSection(String description, Set<Question> questions, Map<Question, Float> questionWeights) {
        Section section = new Section(description, questions, questionWeights);
        this.sections.add(section);
        return this;
    }

    public ExamBuilder withCourse(Course course) {
        this.course = course;
        return this;
    }

}
