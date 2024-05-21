package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.question.domain.Question;
import eapli.ecourse.question.repositories.QuestionRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryQuestionRepository extends InMemoryDomainRepository<Question, Long> implements QuestionRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<Question> findAllMatchingQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }

    @Override
    public List<Question> findAllMissingWordQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }

    @Override
    public List<Question> findAllMultipleChoiceQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }

    @Override
    public List<Question> findAllNumericalQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }

    @Override
    public List<Question> findAllShortAnswerQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }

    @Override
    public List<Question> findAllSingleChoiceQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }

    @Override
    public List<Question> findAllTrueOrFalseQuestionsByTheme(String theme) {
        return (List<Question>) match(q -> q.theme().equals(theme));
    }
}
