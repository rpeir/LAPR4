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
package eapli.ecourse.usermanagement.domain;

import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.strings.util.StringPredicates;

/**
 * Enforces that passwords must be at least 8 characters long and have at least
 * one digit and one capital letter.
 */
public class ECoursePasswordPolicy implements PasswordPolicy {

    @Override
    public boolean isSatisfiedBy(final String rawPassword) {
        // sanity check
        if (StringPredicates.isNullOrEmpty(rawPassword)) {
            return false;
        }

        // at least 8 characters long
        if (rawPassword.length() < 8) {
            return false;
        }

        // at least one digit
        if (!StringPredicates.containsDigit(rawPassword)) {
            return false;
        }

        // at least one capital letter
        return StringPredicates.containsCapital(rawPassword);
    }

    /**
     * Check how strong a password is. just for demo purposes.
     * <p>
     * look into
     * https://documentation.cpanel.net/display/CKB/How+to+Determine+Password+Strength
     * for example rules of password strength
     *
     * @param rawPassword
     *            the string to check
     *
     * @return how strong a password is
     */
    public PasswordStrength strength(final String rawPassword) {
        PasswordStrength passwordStrength;
        if (rawPassword.length() >= 8
                && StringPredicates.containsAny(rawPassword, "$#!%&?")) {
            passwordStrength = PasswordStrength.EXCELENT;
        } else if (rawPassword.length() >= 8) {
            passwordStrength = PasswordStrength.GOOD;
        } else {
            passwordStrength = PasswordStrength.WEAK;
        }
        return passwordStrength;
    }

    public enum PasswordStrength {
        WEAK, GOOD, EXCELENT,
    }
}
