package eapli.ecourse.question.repositories;

import eapli.ecourse.question.domain.Question;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

import java.util.List;

public interface QuestionRepository extends DomainRepository<Long, Question>, LockableDomainRepository<Long, Question> {

    List<Question> findAllMatchingQuestionsByTheme(String theme);

    List<Question> findAllMissingWordQuestionsByTheme(String theme);

    List<Question> findAllMultipleChoiceQuestionsByTheme(String theme);

    List<Question> findAllNumericalQuestionsByTheme(String theme);

    List<Question> findAllShortAnswerQuestionsByTheme(String theme);

    List<Question> findAllSingleChoiceQuestionsByTheme(String theme);

    List<Question> findAllTrueOrFalseQuestionsByTheme(String theme);
}
