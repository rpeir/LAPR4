package eapli.ecourse.student.domain;

import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a student's mechanographic number.
 */
@Entity
public class MechanographicNumber implements Comparable<MechanographicNumber>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(
            name = "mechanographic_number_seq",
            strategy = "eapli.ecourse.student.domain.MechanographicNumberGenerator",
            parameters = {
                    @Parameter(name = MechanographicNumberGenerator.INCREMENT_PARAM, value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mechanographic_number_seq")
    private String number;

    protected MechanographicNumber(final String mechanographicNumber) {
        Preconditions.ensure(StringPredicates.isNullOrEmpty(mechanographicNumber),  "Mecanographic Number should neither be null nor empty");
        Preconditions.ensure(mechanographicNumber.matches("[0-9]{9}"), "Mecanographic Number should be 9 digits long");
        this.number = mechanographicNumber;
    }

    public MechanographicNumber() {
        // for ORM
    }

    public static MechanographicNumber valueOf(final String mechanographicNumber) {
        return new MechanographicNumber(mechanographicNumber);
    }

    @Override
    public String toString() {
        return this.number;
    }

    @Override
    public int compareTo(final MechanographicNumber arg0) {
        return number.compareTo(arg0.number);
    }

}
