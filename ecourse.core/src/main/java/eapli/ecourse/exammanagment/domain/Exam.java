package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * An Exam
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"examTitle", "course_courseid"})
})
public abstract class Exam implements AggregateRoot<Long> {

    /**
     * Unique identifier for the exam
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exam_id")
    private Long id;

    /**
     * Title of the exam
     */
    private String examTitle;


    /**
     * Course of the exam
     */
    @ManyToOne
    private Course course;
    /**
     * Header of the exam
     */
    @Embedded
    private ExamHeader examHeader;

    /**
     * Sections of the exam
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "exam_id")
    private Set<Section> sections;

    protected Exam() {
        // for ORM only
    }

    protected Exam(String title, ExamHeader examHeader, Set<Section> sections, Course course) {
        setTitle(title);
        setExamHeader(examHeader);
        setSections(sections);
        setCourse(course);
    }

    private void setCourse(Course course) {
        Preconditions.nonNull(course, "Course should not be null");
        this.course = course;
    }

    private void setExamHeader(ExamHeader examHeader) {
        Preconditions.nonNull(examHeader, "Exam header should not be null");
        this.examHeader = examHeader;
    }

    private void setSections(Set<Section> sections) {
        Preconditions.nonNull(sections, "Sections should not be null");
        Preconditions.nonEmpty(sections, "An exam should have at least one section");
        this.sections = sections;
    }

    private void setTitle(String title) {
        Preconditions.nonNull(title, "Exam title should not be null");
        Preconditions.ensure(!title.isEmpty(), "Exam title should not be empty");
        this.examTitle = title;
    }


    @Override
    public boolean sameAs(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(examTitle, exam.examTitle)
                && examHeader.equals(exam.examHeader)
                && sections.containsAll(exam.sections);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public String title() {
        return this.examTitle;
    }
    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return examTitle;
    }

    public Course course() {
        return course;
    }

    public abstract boolean isAvaliable();

    public ExamHeader header() {
        return examHeader;
    }

    public Iterable<Section> sections() {
        return new HashSet<>(sections);
    }
}
