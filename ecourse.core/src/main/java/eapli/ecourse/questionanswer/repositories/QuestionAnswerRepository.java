package eapli.ecourse.questionanswer.repositories;

import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.framework.domain.repositories.DomainRepository;

public interface QuestionAnswerRepository extends DomainRepository<Long, QuestionAnswer<?, ?>> {

}
