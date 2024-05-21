package eapli.ecourse.ecourseusermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;

import javax.persistence.Id;
import java.util.Date;

public class ECourseManager implements AggregateRoot<EmailAddress> {
    @Id
    private EmailAddress email;
    private TPN taxPayerNumber;
    private String shortName;
    private String fullName;
    private Date birthdate;

    public ECourseManager(EmailAddress email, TPN taxPayerNumber, String shortName, String fullName, Date birthdate) {
        if (email == null || taxPayerNumber == null || shortName == null || fullName == null || birthdate == null) {
            throw new IllegalArgumentException();
        }
        this.email = email;
        this.taxPayerNumber = taxPayerNumber;
        this.shortName = shortName;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }
    protected ECourseManager() {
        // for ORM only
    }

    public EmailAddress emailAddress() {
        return identity();
    }
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public EmailAddress identity() {
        return this.email;
    }
}
