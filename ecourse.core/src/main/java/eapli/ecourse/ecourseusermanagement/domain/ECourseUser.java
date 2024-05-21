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
package eapli.ecourse.ecourseusermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Date;

/**
 * A eCourse User.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ECourseUser implements AggregateRoot<EmailAddress> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private EmailAddress emailAddress;

    @Embedded
    private TPN taxPayerNumber;
    private String fullName;

    private String shortName;
    private Date birthdate;

    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne(optional = false)
    private SystemUser systemUser;

    public ECourseUser(final SystemUser user, final EmailAddress emailAddress,
                       final String fullName, final String shortName, final Date birthdate,
                       final TPN taxPayerNumber) {
        Preconditions.noneNull(emailAddress, user, fullName, shortName, birthdate, taxPayerNumber);

        this.systemUser = user;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.shortName = shortName;
        this.birthdate = birthdate;
        this.taxPayerNumber = taxPayerNumber;
    }

    protected ECourseUser() {
        // for ORM only
    }

    public SystemUser user() {
        return this.systemUser;
    }

    public String toString() {
        return "ECourseUser{" +
                "systemUser=" + systemUser +
                ", emailAddress=" + emailAddress +
                ", taxPayerNumber=" + taxPayerNumber +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    protected String shortName() {
        return this.shortName;
    }

    protected String email() {
        return this.emailAddress.toString();
    }

    @Override
    public boolean sameAs(Object other) {
        return this.equals(other);
    }

    @Override
    public EmailAddress identity() {
        return this.emailAddress;
    }
}


