package eapli.ecourse.boardManagement.updateevent;
import eapli.ecourse.boardUpdate.domain.*;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.service.FindLoggedECourseUser;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.pubsub.EventHandler;


public class BoardUpdateHandler implements EventHandler {
    private FindLoggedECourseUser svc = new FindLoggedECourseUser();
    private UpdateRepository updateRepository = PersistenceContext.repositories().updates();
    @Override
    public void onEvent(DomainEvent domainEvent) {
        ECourseUser owner = svc.findLoggedECourseUser();
        if (owner == null) {
            throw new IllegalStateException("User not found");
        }
        BoardUpdateEvent boardUpdateEvent = (BoardUpdateEvent) domainEvent;
        //create updated based on event
        CellUpdate updateToSave = new CellUpdate(boardUpdateEvent.occurredAt(),boardUpdateEvent.postIt(),
                boardUpdateEvent.content(),CellUpdateType.valueOf(boardUpdateEvent.type()),owner,((BoardUpdateEvent) domainEvent).board(),
                boardUpdateEvent.initPosition(),boardUpdateEvent.endPosition());
        //save update
        updateRepository.save(updateToSave);
    }
}
