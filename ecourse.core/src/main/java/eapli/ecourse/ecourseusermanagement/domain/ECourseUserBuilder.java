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
package eapli.ecourse.ecourseusermanagement.domain;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Date;

/**
 * A factory for User entities.
 */
public class ECourseUserBuilder /*implements DomainFactory<ECourseUser>*/ {

    protected SystemUser systemUser;
    protected String fullName;
    protected String shortName;
    protected Date birthdate;
    protected TPN taxPayerNumber;
    protected EmailAddress emailAddress;


    public ECourseUserBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public ECourseUserBuilder withEmailAddress(
            final EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ECourseUserBuilder withEmailAddress(final String emailAddress) {
        this.emailAddress = EmailAddress.valueOf(emailAddress);
        return this;
    }
    public ECourseUserBuilder withFullName(final String fullName) {
        this.fullName = fullName;
        return this;
    }
    public ECourseUserBuilder withBirthdate(final Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }
    public ECourseUserBuilder withTaxPayerNumber(final TPN taxPayerNumber) {
        if(taxPayerNumber.isValid(String.valueOf(taxPayerNumber))){
            this.taxPayerNumber = taxPayerNumber;
            return this;
        }
        else{
            throw new IllegalArgumentException("Invalid TPN");
        }
    }
    public ECourseUserBuilder withShortName(final String shortName) {
        this.shortName = shortName;
        return this;
    }

    public ECourseUser build() {
        return new ECourseUser(systemUser, emailAddress, fullName, shortName, birthdate, taxPayerNumber);
    }
}

