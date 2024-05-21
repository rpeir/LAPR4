package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * A Summative Exam, the default type of exam
 */
@Entity
public class SummativeExam extends Exam {

    /**
     * Open date of the exam
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date openDate;

    /**
     * Close date of the exam
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;

    protected SummativeExam() {
        super();
        // for ORM only
    }

    public SummativeExam(String title, ExamHeader examHeader, Set<Section> sections, Course course, Date openDate, Date closeDate) {
        super(title, examHeader, sections, course);
        setOpenCloseDates(openDate, closeDate);
    }

    private void setOpenCloseDates(Date openDate, Date closeDate) {
        Preconditions.nonNull(openDate, "Open date must not be null");
        Preconditions.nonNull(closeDate, "Close date must not be null");
        Preconditions.ensure(openDate.after(new Date()), "Open date must be after current date");
        Preconditions.ensure(openDate.before(closeDate), "Open date must be before close date");
        this.openDate = openDate;
        this.closeDate = closeDate;
    }

    /**
     * @return the open date of the exam
     */
    public Date openDate() {
        return (Date) this.openDate.clone();
    }

    /**
     * @return the close date of the exam
     */
    public Date closeDate() {
        return (Date) this.closeDate.clone();
    }

    @Override
    public boolean sameAs(Object o) {
        if (this == o) return true;
        if (!(o instanceof SummativeExam)) return false;
        if (!super.sameAs(o)) return false;
        SummativeExam that = (SummativeExam) o;
        return openDate.equals(that.openDate) && closeDate.equals(that.closeDate);
    }

    @Override
    public boolean isAvaliable() {
        Date now = new Date();
        return now.after(openDate) && now.before(closeDate);
    }
}
