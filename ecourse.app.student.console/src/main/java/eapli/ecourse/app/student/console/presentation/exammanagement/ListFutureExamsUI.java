package eapli.ecourse.app.student.console.presentation.exammanagement;

import eapli.ecourse.app.student.console.presentation.coursemanagement.CoursePrinter;
import eapli.ecourse.courseenrollement.application.RequestEnrollmentCourseController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.application.ListFutureExamsController;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;

public class ListFutureExamsUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ListFutureExamsUI.class);
    private ListFutureExamsController ctrl = new ListFutureExamsController(AuthzRegistry.authorizationService());
    /**
     * @return
     */
    @Override
    protected boolean doShow() {
        // find the student
        // find student courses
        final Iterable<Course> studentEnrolledCourses = ctrl.findEnrolledCourses();

        // list future exams by course
        if (!studentEnrolledCourses.iterator().hasNext()) {
            System.out.println("There are no available Courses.");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the courses:",studentEnrolledCourses,new CoursePrinter());
            selector.show();
            Course course = selector.selectedElement();
            // list future exams by course
            ListWidget<Exam> futureExams = new ListWidget<>("Future Exams:",ctrl.listFutureExamsByCourse(course),new ExamPrinter());
            futureExams.show();
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public String headline() {
        return "List Future Exams";
    }
}
