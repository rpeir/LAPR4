package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.question.domain.Question;
import eapli.ecourse.question.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;

public class JpaQuestionRepository extends JpaAutoTxRepository<Question, Long, Long> implements QuestionRepository {
    public JpaQuestionRepository(TransactionalContext autoTx) {
        super(autoTx, "questionDescription");
    }

    public JpaQuestionRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "questionDescription");
    }

    @Override
    public List<Question> findAllMatchingQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM MatchingQuestion q WHERE q.theme.questionSubject = :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public List<Question> findAllMissingWordQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM MissingWordQuestion q WHERE q.theme.questionSubject = :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public List<Question> findAllMultipleChoiceQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM MultipleChoiceQuestion q WHERE q.theme.questionSubject = :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public List<Question> findAllNumericalQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM NumericalQuestion q WHERE q.theme.questionSubject = :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public List<Question> findAllShortAnswerQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM ShortAnswerQuestion q WHERE q.theme.questionSubject= :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public List<Question> findAllSingleChoiceQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM SingleChoiceQuestion q WHERE q.theme.questionSubject = :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public List<Question> findAllTrueOrFalseQuestionsByTheme(String theme) {
        Query query = entityManager().createQuery("SELECT q FROM TrueOrFalseQuestion q WHERE q.theme.questionSubject = :theme");
        query.setParameter("theme", theme);
        return query.getResultList();
    }
}
