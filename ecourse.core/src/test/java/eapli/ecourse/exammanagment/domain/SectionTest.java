package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.question.domain.Question;
import org.junit.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class SectionTest {

    private Set<Question> questions = new HashSet<>();
    private Map<Question, Float> questionWeights = new HashMap<>();
    @Before
    public void setUp() {
        Question q1 = mock(Question.class), q2 = mock(Question.class);
        questions.add(q1);
        questions.add(q2);
        questionWeights.put(q1,11f);
        questionWeights.put(q2,9f);
    }

    @Test
    public void ensureSectionWithValidParametersCanBeCreated() {
        Section section = new Section("Section 1", questions, questionWeights);
        assertNotNull(section);
        assertEquals("Section 1", section.description());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSectionWithNullDescriptionIsNotPossible() {
        Section section = new Section(null, questions, questionWeights);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSectionWithEmptyDescriptionIsNotPossible() {
        Section section = new Section("", questions, questionWeights);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSectionWithNullQuestionsIsNotPossible() {
        Section section = new Section("Section 1", null, questionWeights);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSectionWithEmptyQuestionsIsNotPossible() {
        questions.clear();
        Section section = new Section("Section 1", questions, questionWeights);
    }

    @Test
    public void ensureTwoSectionsAreTheSame() {
        Section section1 = new Section("Section 1", questions, questionWeights);
        Section section2 = new Section("Section 1", questions, questionWeights);
        assertTrue(section1.sameAs(section2));
    }


}