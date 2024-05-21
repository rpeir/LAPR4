package eapli.ecourse.ecourseusermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class TPN  implements ValueObject, Comparable<TPN> {
    private static final long serialVersionUID = 1L;

    private final String taxnumber;

    public TPN(final String taxnumber) {
        Preconditions.noneNull(taxnumber);
        this.taxnumber = taxnumber;
    }

    protected TPN() {
        // for ORM
        taxnumber = null;
    }
    //add restriction for TPN: Needs to contain 9 digits
    public static boolean isValid(final String taxnumber) {
        return taxnumber != null && taxnumber.matches("[0-9]{9}");
    }

    public static TPN valueOf(final String taxnumber) {
        return new TPN(taxnumber);
    }

    @Override
    public String toString() {
        return taxnumber;
    }

    @Override
    public int compareTo(final TPN o) {
        return taxnumber.compareTo(o.taxnumber);
    }
}

