package eapli.ecourse.exammanagment.domain;

import java.util.Date;

public class SummativeExamBuilder extends ExamBuilder {

    private Date openDate;
    private Date closeDate;

    public ExamBuilder withOpenDate(Date openDate) {
        this.openDate = openDate;
        return this;
    }

    public ExamBuilder withCloseDate(Date closeDate) {
        this.closeDate = closeDate;
        return this;
    }

    @Override
    public Exam build() {
        return new SummativeExam(this.title, this.examHeader, this.sections,
                this.course, this.openDate, this.closeDate);
    }
}
