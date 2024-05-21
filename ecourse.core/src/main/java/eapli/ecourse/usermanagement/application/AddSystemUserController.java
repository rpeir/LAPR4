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
package eapli.ecourse.usermanagement.application;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.domain.StudentBuilder;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.domain.Acronym;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.domain.TeacherBuilder;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Date;
import java.util.Set;

@UseCaseController
public class AddSystemUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    private final RepositoryFactory repoFactory = PersistenceContext.repositories();

    /**
     * Adds a new user to the system.
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param roles
     * @return the newly created user
     */
    public SystemUser addUser(final String username, final String password, final String firstName,
            final String lastName, final String email, final Set<Role> roles) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.MANAGER_USER);

        return userSvc.registerNewUser(username, password, firstName, lastName, email, roles, CurrentTimeCalendars.now());
    }

    /**
     * @return all the roles in the system
     */
    public Role[] getRoleTypes() {
        return ECourseRoles.allRoles();
    }

    /**
     * Creates a new student
     * @param systemUser
     * @param email
     * @param taxPayerNumber
     * @param birthDate
     * @param fullName
     * @param shortName
     * @return the newly created student
     */
    public Student createStudent(SystemUser systemUser, String email, TPN taxPayerNumber, Date birthDate, String fullName, String shortName){
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.withSystemUser(systemUser);
        studentBuilder.withEmailAddress(email);
        studentBuilder.withTaxPayerNumber(taxPayerNumber);
        studentBuilder.withBirthdate(birthDate);
        studentBuilder.withFullName(fullName);
        studentBuilder.withShortName(shortName);
        Student s=studentBuilder.build();
        RepositoryFactory repositoryFactory = PersistenceContext.repositories();
        repositoryFactory.students().save(s);
        return s;
    }
    /**
     * Creates a new teacher
     * @param systemUser
     * @param acronym
     * @param email
     * @param taxPayerNumber
     * @param birthDate
     * @param fullName
     * @param shortName
     * @return the newly created teacher
     *
     */
    public Teacher createTeacher(SystemUser systemUser, Acronym acronym, EmailAddress email, TPN taxPayerNumber, Date birthDate, String fullName, String shortName){
        TeacherBuilder teacherBuilder = new TeacherBuilder();
        teacherBuilder.withSystemUser(systemUser);
        teacherBuilder.withAcronym(acronym);
        teacherBuilder.withEmailAddress(email);
        teacherBuilder.withTaxPayerNumber(taxPayerNumber);
        teacherBuilder.withBirthdate(birthDate);
        teacherBuilder.withFullName(fullName);
        teacherBuilder.withShortName(shortName);
        Teacher t=teacherBuilder.build();
        RepositoryFactory repositoryFactory = PersistenceContext.repositories();
        repositoryFactory.teachers().save(t);
        return t;
    }
    public StudentRepository studentRepository(){
        return repoFactory.students();
    }
    public TeacherRepository teacherRepository(){
        return repoFactory.teachers();
    }
}
