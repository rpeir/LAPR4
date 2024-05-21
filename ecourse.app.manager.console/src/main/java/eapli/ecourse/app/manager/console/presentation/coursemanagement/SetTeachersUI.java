package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.application.SetTeachersController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.HashSet;
import java.util.Set;

public class SetTeachersUI extends AbstractUI {
    private SetTeachersController ctrl = new SetTeachersController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().courses(),PersistenceContext.repositories().teachers());

    /**
     * @return
     */
    @Override
    protected boolean doShow() {
        Course course;
        Iterable<Course> availableCourses = ctrl.availableCourses();
        if (availableCourses.iterator().hasNext()){
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the available courses:",availableCourses,new CoursePrinter());
            selector.show();
            course = selector.selectedElement();
        }else {
            System.out.println("There is no available courses.");
            return false;
        }

        Iterable<Teacher> availableTeachers = ctrl.availableTeachers();
        if (availableTeachers.iterator().hasNext()){
            final SelectWidget<Teacher> selector = new SelectWidget<>("Select one of the available Teachers or option O to exit",availableTeachers, new TeacherPrinter());
            Set<Teacher> teacherSet = new HashSet<>();
            do {
                selector.show();
                Teacher teacher = selector.selectedElement();
                try {
                    teacherSet.add(teacher);
                }catch (NullPointerException ignored){}
            }while (selector.selectedOption() != 0);
            ctrl.addTeachers(course,teacherSet);
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public String headline() {
        return "Set Teachers to a Course";
    }
}
