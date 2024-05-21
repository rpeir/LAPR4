/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecourse.app.student.console.presentation;

import eapli.ecourse.app.common.console.presentation.authz.UserMenu;
import eapli.ecourse.app.student.console.presentation.courseenrollment.RequestEnrollmentCourseAction;
import eapli.ecourse.app.student.console.presentation.coursemanagement.ListAvailableCoursesAction;
import eapli.ecourse.app.student.console.presentation.coursemanagement.ListStudentGradesAction;
import eapli.ecourse.app.student.console.presentation.examExecution.TakeExamAction;
import eapli.ecourse.app.student.console.presentation.exammanagement.ListFutureExamsAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

class MainMenu extends StudentBaseUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int SETTINGS_OPTION = 2;
    private static final int COURSE_OPTION = 3;
    private static final int EXAM_OPTION = 4;

    // COURSES MENU
    private static final int LIST_AVAILABLE_COURSES_OPTION = 1;
    private static final int LIST_ENROLLED_COURSES_OPTION = 2;
    private static final int ENROLL_IN_COURSE_OPTION = 3;
    private static final int LIST_FUTURE_EXAMS_OPTION = 4;

    // EXAMS MENU

    private static final int TAKE_EXAM_OPTION = 1;
    private static final int LIST_STUDENT_GRADES_OPTION = 2;

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * Builds the main menu and renders it.
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final var renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }
    /**
     * Builds the main menu.
     *
     * @return the main menu
     */
    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new UserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu settingsMenu = buildAdminSettingsMenu();
        mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        
        final Menu coursesMenu = buildCoursesMenu();
        mainMenu.addSubMenu(COURSE_OPTION,coursesMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu examsMenu = buildExamsMenu();
        mainMenu.addSubMenu(EXAM_OPTION,examsMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Exiting..."));

        return mainMenu;
    }

    private Menu buildExamsMenu() {
        final Menu menu = new Menu("Exams >");
        menu.addItem(TAKE_EXAM_OPTION, "Take Exam", new TakeExamAction());
        menu.addItem(LIST_STUDENT_GRADES_OPTION, "List Grades", new ListStudentGradesAction());
        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return menu;
    }

    private Menu buildCoursesMenu() {
        final Menu menu = new Menu("Courses >");
        menu.addItem(LIST_AVAILABLE_COURSES_OPTION,"List available Courses", new ListAvailableCoursesAction());
        menu.addItem(ENROLL_IN_COURSE_OPTION, "Request Enrollment in a Course", new RequestEnrollmentCourseAction());
        menu.addItem(LIST_FUTURE_EXAMS_OPTION, "List Future Exams", new ListFutureExamsAction());
        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return menu;
    }

    /**
     * Builds the settings menu.
     *
     * @return the settings menu
     */

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);

        return menu;
    }
}
