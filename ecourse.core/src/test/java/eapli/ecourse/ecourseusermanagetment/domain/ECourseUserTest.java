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
package eapli.ecourse.ecourseusermanagetment.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUserBuilder;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import org.junit.jupiter.api.Test;

import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

/**
 * Test for ECourseUser
 */
class ECourseUserTest {

    private final String aEmail = "abc@email.orh";
    private final String anotherEmail = "xyz@email.org";

    public static SystemUser dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", ECourseRoles.MANAGER_USER);
    }

    /*
    @Test
    void ensureECourseUserEqualsPassesForTheSameEmail() throws Exception {

        final ECourseUser eCourseUser = new ECourseUserBuilder().withEmailAddress("DUMMY@b.ro")
                .withSystemUser(getNewDummyUser()).build();

        final ECourseUser anotherECourseUser = new ECourseUserBuilder().withEmailAddress("DUMMY@b.ro")
                .withSystemUser(getNewDummyUser()).build();

        final boolean expected = eCourseUser.equals(anotherECourseUser);

        assertTrue(expected);
    }

    @Test
    void ensureECourseUserEqualsFailsForDifferenteEmail() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.MANAGER_USER);

        final ECourseUser aECourseUser = new ECourseUserBuilder().withEmailAddress(aEmail)
                .withSystemUser(getNewDummyUser()).build();

        final ECourseUser anotherECourseUser = new ECourseUserBuilder()
                .withEmailAddress(anotherEmail).withSystemUser(getNewDummyUser()).build();

        final boolean expected = aECourseUser.equals(anotherECourseUser);

        assertFalse(expected);
    }

    @Test
    void ensureECourseUserEqualsAreTheSameForTheSameInstance() throws Exception {
        final ECourseUser aECourseUser = new ECourseUserBuilder().withEmailAddress("DUMMY@b.ro")
                .withSystemUser(getNewDummyUser()).build();

        assertEquals(aECourseUser, aECourseUser);
    }

    @Test
    void ensureECourseUserEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.MANAGER_USER);

        final ECourseUser aECourseUser = new ECourseUserBuilder().withEmailAddress("DUMMY@b.ro")
                .withSystemUser(getNewDummyUser()).build();

        @SuppressWarnings("unlikely-arg-type")
        final boolean expected = aECourseUser.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    void ensureECourseUserIsTheSameAsItsInstance() throws Exception {
        final ECourseUser aECourseUser = new ECourseUserBuilder().withEmailAddress("DUMMY@b.ro")
                .withSystemUser(getNewDummyUser()).build();

        assertTrue(aECourseUser.sameAs(aECourseUser));
    }

    @Test
    void ensureTwoECourseUserWithDifferentEmailAreNotTheSame() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(ECourseRoles.MANAGER_USER);
        final ECourseUser aECourseUser = new ECourseUserBuilder().withEmailAddress(aEmail)
                .withSystemUser(getNewDummyUser()).build();

        final ECourseUser anotherECourseUser = new ECourseUserBuilder()
                .withEmailAddress(anotherEmail).withSystemUser(getNewDummyUser()).build();

        assertFalse(aECourseUser.sameAs(anotherECourseUser));
    }
     */
}
