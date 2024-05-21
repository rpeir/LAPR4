package eapli.ecourse.infrastructure.bootstrapers;

import eapli.ecourse.coursemanagement.application.RegisterCourseController;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class CourseBootsrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(CourseBootsrapper.class);

    @Override
    public boolean execute() {
        create("dummy1","dummy1","dummy1 course",10,100,"10-05-2030");
        create("dummy2","dummy2","dummy2 course",10,100,"10-05-2030");
        create("dummy3","dummy3","dummy3 course",10,100,"10-05-2030");
    return true;
    }

    private void create(String courseCode, String courseTitle, String description, int minStudents, int maxStudents, String closeDate){
        RegisterCourseController ctrl = new RegisterCourseController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().courses());
        try {
            ctrl.registerCourse(courseCode,courseTitle,description,minStudents, maxStudents,closeDate);
            LOGGER.debug("»»» {}", courseCode);
        }catch (IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)",courseCode);
            LOGGER.trace("Assuming existing record",ex);
        }
    }

}
