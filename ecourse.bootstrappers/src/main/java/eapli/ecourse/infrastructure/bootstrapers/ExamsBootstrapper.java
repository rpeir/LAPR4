package eapli.ecourse.infrastructure.bootstrapers;

import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExamsBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ExamsBootstrapper.class);

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courses();
    private final ExamRepository examRepository = PersistenceContext.repositories().exams();

    @Override
    public boolean execute() {
        return true;
    }

    private void create(String courseCode, String courseTitle, String description, int minStudents, int maxStudents, String closeDate){
    }

}

