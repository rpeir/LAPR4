package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.ecourse.questionanswer.repositories.QuestionAnswerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryQuestionAnswerRepository extends InMemoryDomainRepository<QuestionAnswer<?,?>, Long> implements QuestionAnswerRepository {
    static {
        InMemoryInitializer.init();
    }

}
