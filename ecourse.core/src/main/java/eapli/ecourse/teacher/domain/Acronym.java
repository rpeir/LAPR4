package eapli.ecourse.teacher.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class Acronym implements ValueObject, Comparable<Acronym> {
    private static final long serialVersionUID = 1L;

    private final String acronym;

    private Acronym(final String acronym) {
        Preconditions.nonEmpty(acronym, "Acronym should neither be null nor empty");
        this.acronym = acronym;
    }
    protected Acronym() {
        // for ORM
        acronym = null;
    }
    public static Acronym valueOf(final String acronym) {
        return new Acronym(acronym);
    }

    @Override
    public String toString() {
        return acronym;
    }


    @Override
    public int compareTo(Acronym o) {
        return acronym.compareTo(o.acronym);
    }
    public boolean validateAcronym(String acronym){
        if(acronym.length() == 3){
            return true;
        }
        return false;
    }
}
