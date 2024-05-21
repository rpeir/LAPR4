package eapli.ecourse.student.domain;

import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Student extends ECourseUser {

    @OneToOne(cascade = CascadeType.ALL)
    private MechanographicNumber mechanographicNumber;

    protected Student() {
        // for ORM only
    }
    public Student(SystemUser systemUser, EmailAddress email, String fullName,String shortName, Date birthdate, TPN tpn){
        super(systemUser, email, fullName,shortName, birthdate, tpn);
        this.mechanographicNumber = new MechanographicNumber();
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


    public MechanographicNumber mechanographicNumber() {
        return this.mechanographicNumber;
    }

}
