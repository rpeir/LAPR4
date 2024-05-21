package eapli.ecourse.teacher.domain;

import eapli.ecourse.ecourseusermanagement.domain.ECourseUserBuilder;

public class TeacherBuilder extends ECourseUserBuilder {
    private Acronym acronym;

    public TeacherBuilder withAcronym(Acronym acronym) {
        this.acronym = acronym;
        return this;
    }
    public Teacher build() {
        return new Teacher(this.systemUser, this.acronym,this.fullName,this.shortName,this.taxPayerNumber,this.birthdate, this.emailAddress);
    }
}
