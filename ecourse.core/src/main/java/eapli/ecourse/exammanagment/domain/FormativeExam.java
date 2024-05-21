package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.coursemanagement.domain.Course;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

/**
 * A Formative Exam
 */
@Entity
public class FormativeExam extends Exam {

    protected FormativeExam() {
        super();
        // for ORM only
    }

    public FormativeExam(String title, ExamHeader examHeader, Set<Section> sections, Course course) {
        super(title, examHeader, sections, course);
    }

    @Override
    public boolean isAvaliable() {
        return true;
    }
}
