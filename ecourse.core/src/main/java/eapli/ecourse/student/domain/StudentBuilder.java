package eapli.ecourse.student.domain;

import eapli.ecourse.ecourseusermanagement.domain.ECourseUserBuilder;

public class StudentBuilder extends ECourseUserBuilder {

    public Student build() {
        return new Student(this.systemUser, this.emailAddress, this.fullName,this.shortName,this.birthdate, this.taxPayerNumber);
    }
}
