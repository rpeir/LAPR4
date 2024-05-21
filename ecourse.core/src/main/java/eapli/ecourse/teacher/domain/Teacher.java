package eapli.ecourse.teacher.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Teacher extends ECourseUser {

    @Embedded
    private Acronym acronym;

    protected Teacher() {
        // for ORM only
    }
    public Teacher(SystemUser systemUser, Acronym acronym, String fullName, String shortName, TPN taxPayerNumber, Date birthdate, EmailAddress email) {
        super(systemUser,email,fullName,shortName,birthdate,taxPayerNumber);
        if(acronym == null || taxPayerNumber == null|| fullName == null || birthdate == null || email == null){
            throw new IllegalArgumentException();
        }
        this.acronym = acronym;
    }
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }
    public Acronym acronym() {
        return this.acronym;
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }


    public boolean isAvailable() {
        return user().isActive();
    }

    public String toString() {
        return acronym.toString();
    }

}
