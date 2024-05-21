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
package eapli.ecourse.app.manager.console.presentation;

import eapli.ecourse.app.common.console.presentation.authz.UserMenu;
import eapli.ecourse.app.manager.console.presentation.authz.ActivateSystemUserUI;
import eapli.ecourse.app.manager.console.presentation.authz.DeactivateSystemUserUI;
import eapli.ecourse.app.manager.console.courseenrollment.ApproveRejectApplicationAction;
import eapli.ecourse.app.manager.console.presentation.authz.AddSystemUserUI;
import eapli.ecourse.app.manager.console.presentation.authz.ListSystemUserUI;
import eapli.ecourse.app.manager.console.presentation.coursemanagement.*;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * Manager Main Menu
 */
class MainMenu extends ECourseManagerBaseUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 3;
    private static final int COURSE_OPTION = 4;

    // USERS
    private static final int RETURN_OPTION = 0;
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;

    private static final int ENABLE_USER_OPTION = 4;
    private static final int DISABLE_USER_OPTION = 3;

    // COURSES
    private static final int CREATE_COURSE_OPTION = 1;
    private static final int OPEN_COURSE_OPTION = 2;
    private static final int CLOSE_COURSE_OPTION = 3;
    private static final int ADD_TEACHERS_OPTION = 4;
    private static final int LIST_AVAILABLE_COURSES = 5;
    private static final int CHANGE_ENROLLMENT = 6;
    private static final int APPROVE_REJECT_APPLICATIONS = 7;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
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
        final var renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new UserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu usersMenu = buildUsersMenu();
        mainMenu.addSubMenu(USERS_OPTION, usersMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu settingsMenu = buildAdminSettingsMenu();
        mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        final Menu coursesMenu = buildCoursesMenu();
        mainMenu.addSubMenu(COURSE_OPTION,coursesMenu);

        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        /*
        if(authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER)){
            final Menu coursesMenu = buildCoursesMenu();
            mainMenu.addSubMenu(COURSE_OPTION,coursesMenu);

            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        */
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Exiting..."));

        return mainMenu;
    }

    private Menu buildCoursesMenu() {
        final Menu menu = new Menu("Courses >");
        menu.addItem(CREATE_COURSE_OPTION, "Create a new Course", new RegisterCourseAction());
        menu.addItem(OPEN_COURSE_OPTION,"Open Courses.", new OpenCourseAction());
        menu.addItem(CLOSE_COURSE_OPTION,"Close Course.",new CloseCourseAction());
        menu.addItem(ADD_TEACHERS_OPTION,"Set Teachers to a Course", new SetTeachersAction());
        menu.addItem(LIST_AVAILABLE_COURSES,"List available Courses", new ListAvailableCourseAction());
        menu.addItem(CHANGE_ENROLLMENT,"Change Enrollment State", new SetEnrollmentStateAction());
        menu.addItem(APPROVE_REJECT_APPLICATIONS,"Approve/Reject Applications", new ApproveRejectApplicationAction());
        return menu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add System User", new AddSystemUserUI()::show);

        menu.addItem(LIST_USERS_OPTION, "List Users", new ListSystemUserUI()::show);

        menu.addItem(DISABLE_USER_OPTION, "Disable User", new DeactivateSystemUserUI()::show);

        menu.addItem(ENABLE_USER_OPTION, "Enable User", new ActivateSystemUserUI()::show);

        menu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);




        return menu;
    }
}
