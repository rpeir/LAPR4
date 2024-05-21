package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.ecourse.questionanswer.repositories.QuestionAnswerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaQuestionAnswerRepository extends JpaAutoTxRepository<QuestionAnswer<?,?>, Long, Long> implements QuestionAnswerRepository {

    public JpaQuestionAnswerRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaQuestionAnswerRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "id");
    }
}

