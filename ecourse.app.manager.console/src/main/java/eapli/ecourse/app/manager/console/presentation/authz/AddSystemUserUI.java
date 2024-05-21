/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecourse.app.manager.console.presentation.authz;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.teacher.domain.Acronym;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.application.AddSystemUserController;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UI for adding a system user to the application.
 */
@SuppressWarnings("java:S106")
public class AddSystemUserUI extends AbstractUI {

    private final AddSystemUserController theController = new AddSystemUserController();
    /**
     * Requests the user input and triggers the addition of a new system user to the application.
     */
    @Override
    protected boolean doShow() {
        final SystemUser user;
        final String email = Console.readLine("E-Mail");
        final String password = Console.readLine("Password");
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");

        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        try {
            user=this.theController.addUser(email, password, firstName, lastName, email, roleTypes);
            System.out.println("User created: "+user.identity());
            System.out.println("\nIntroduce the following data:\n");
            final String fullName = Console.readLine("Full Name");
            final String shortName = Console.readLine("Short Name");
            final Date birthDate = Console.readDate("Birthdate","dd-MM-yyyy");
            final TPN tpn = TPN.valueOf(Console.readLine("TPN"));
                if(roleTypes.contains(ECourseRoles.STUDENT_USER)){
                    Student s=this.theController.createStudent(user, email,tpn,birthDate,fullName,shortName);
                    System.out.println("Student created: "+s);

                }
                if(roleTypes.contains(ECourseRoles.TEACHER_USER)){
                    final Acronym acronym = Acronym.valueOf(Console.readLine("Acronym"));
                    Teacher t=this.theController.createTeacher(user,acronym, EmailAddress.valueOf(email),tpn,birthDate,fullName,shortName);
                    System.out.println("Teacher created: "+t);
                }
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("Error while creating new user: "+e.getMessage());
        }
        return false;
    }
    /**
     * Shows the roles
     * @param roleTypes the role types
     *
     */
    private boolean showRoles(final Set<Role> roleTypes) {
        final Menu rolesMenu = buildRolesMenu(roleTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(rolesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }
    /**
     *  Builds the roles menu.
     * @param roleTypes the role types
     *
     */
    private Menu buildRolesMenu(final Set<Role> roleTypes) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
        for (final Role roleType : theController.getRoleTypes()) {
            rolesMenu.addItem(
                    MenuItem.of(counter++, roleType.toString(), () -> roleTypes.add(roleType)));
        }
        return rolesMenu;
    }
    /**
     * Returns the headline of the UI.
     */
    @Override
    public String headline() {
        return "Add System User";
    }
}
