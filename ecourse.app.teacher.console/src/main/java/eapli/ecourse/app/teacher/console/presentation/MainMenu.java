/*
 * Copyright (c) 2013-2022 the original author or authors.
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
package eapli.ecourse.app.teacher.console.presentation;

import eapli.ecourse.app.common.console.presentation.authz.UserMenu;
import eapli.ecourse.app.teacher.console.presentation.classmanagement.ClassScheduleAction;
import eapli.ecourse.app.teacher.console.presentation.coursemanagement.ListAvailableCoursesAction;
import eapli.ecourse.app.teacher.console.presentation.exammanagement.CreateExamAction;
import eapli.ecourse.app.teacher.console.presentation.exammanagement.CreateFormativeExamAction;
import eapli.ecourse.app.teacher.console.presentation.exammanagement.ListCourseExamsAction;
import eapli.ecourse.app.teacher.console.presentation.exammanagement.ListCourseGradesAction;
import eapli.ecourse.app.teacher.console.presentation.questionmanagement.CreateQuestionAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

class MainMenu extends ECourseTeacherUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int SETTINGS_OPTION = 2;
    private static final int COURSE_OPTION = 3;
    private static final int EXAMS_OPTION = 4;
    private static final int CLASSES_OPTION = 5;


    // COURSES MENU
    private static final int LIST_AVAILABLE_COURSES_OPTION = 1;

    private static final int LIST_COURSE_EXAMS_OPTION = 2;
    private static final int LIST_GRADES_OPTION = 3;

    // EXAMS MENU
    private static final int CREATE_EXAM_OPTION = 1;
    private static final int CREATE_QUESTIONS_OPTION = 2;
    private static final int CREATE_FORMATIVE_EXAM_OPTION = 3;

    // CLASSES MENU
    private static final int SCHEDULE_CLASS_OPTION = 1;

    // BOARDS MENU
    private static final int CREATE_BOARD_OPTION = 1;


    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer =
                new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }
    /**
     * Builds the main menu.
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
        mainMenu.addSubMenu(EXAMS_OPTION, examsMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu classesMenu = buildClassesMenu();
        mainMenu.addSubMenu(CLASSES_OPTION,classesMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Exiting..."));

        return mainMenu;
    }
    private Menu buildExamsMenu() {
        final Menu menu = new Menu("Exams >");

        menu.addItem(CREATE_EXAM_OPTION, "Create Exam", new CreateExamAction());
        menu.addItem(CREATE_QUESTIONS_OPTION,"Create Questions", new CreateQuestionAction());
        menu.addItem(CREATE_FORMATIVE_EXAM_OPTION, "Create Formative Exam", new CreateFormativeExamAction());

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return menu;
    }

    private Menu buildCoursesMenu() {
        final Menu menu = new Menu("Courses >");

        menu.addItem(LIST_AVAILABLE_COURSES_OPTION,"List available Courses", new ListAvailableCoursesAction());
        menu.addItem(LIST_COURSE_EXAMS_OPTION, "List course exams", new ListCourseExamsAction());
        menu.addItem(LIST_GRADES_OPTION, "List grades", new ListCourseGradesAction());

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return menu;
    }

    private Menu buildClassesMenu() {
        final Menu menu = new Menu("Classes >");

        menu.addItem(SCHEDULE_CLASS_OPTION, "Schedule Class", new ClassScheduleAction());

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);
        return menu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);

        return menu;
    }
}
