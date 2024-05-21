package eapli.ecourse.student;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.domain.StudentBuilder;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.mock;

public class StudentBuilderTest {
    private static final String MECHANOGRAPHIC_NUMBER = "123456789";
    private static final EmailAddress email1 = EmailAddress.valueOf("student1@emil.org");
    private static final EmailAddress email2 = EmailAddress.valueOf("student2@emil.org");
    private static final String fullName1 = "Student1";
    private static final String fullName2 = "Student2";
    private static final String shortName1 = "S1";
    private static final String shortName2 = "S2";
    private static final Date birthdate1 = new Date("1999/01/01");
    private static final Date birthdate2 = new Date("1999/01/02");
    private static final TPN tpn1=new TPN("123456789");
    private static final TPN tpn2=new TPN("987654321");
    private SystemUser usr1;
    private SystemUser usr2;

    @Before
    public void setUp() {
        usr1= mock(SystemUser.class);
        usr2=mock(SystemUser.class);
    }
    @Test
    public void ensureBuildsValid(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withSystemUser(usr1);
        studentBuilder.withEmailAddress(email1);
        studentBuilder.withFullName(fullName1);
        studentBuilder.withShortName(shortName1);
        studentBuilder.withBirthdate(birthdate1);
        studentBuilder.withTaxPayerNumber(tpn1);
        Student s=studentBuilder.build();
        Assert.assertNotNull(s);
        Assert.assertEquals(s.user(), usr1);
        Assert.assertEquals(s.identity(), email1);

    }
    @Test
    public void ensureCannotBuildWithoutSystemUser(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withEmailAddress(email1);
        studentBuilder.withFullName(fullName1);
        studentBuilder.withShortName(shortName1);
        studentBuilder.withBirthdate(birthdate1);
        studentBuilder.withTaxPayerNumber(tpn1);
        Assert.assertThrows(IllegalArgumentException.class,()->studentBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutEmailAddress(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withSystemUser(usr1);
        studentBuilder.withFullName(fullName1);
        studentBuilder.withShortName(shortName1);
        studentBuilder.withBirthdate(birthdate1);
        studentBuilder.withTaxPayerNumber(tpn1);
        Assert.assertThrows(IllegalArgumentException.class,()->studentBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutFullName(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withSystemUser(usr1);
        studentBuilder.withEmailAddress(email1);
        studentBuilder.withShortName(shortName1);
        studentBuilder.withBirthdate(birthdate1);
        studentBuilder.withTaxPayerNumber(tpn1);
        Assert.assertThrows(IllegalArgumentException.class,()->studentBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutShortName(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withSystemUser(usr1);
        studentBuilder.withEmailAddress(email1);
        studentBuilder.withFullName(fullName1);
        studentBuilder.withBirthdate(birthdate1);
        studentBuilder.withTaxPayerNumber(tpn1);
        Assert.assertThrows(IllegalArgumentException.class,()->studentBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutBirthdate(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withSystemUser(usr1);
        studentBuilder.withEmailAddress(email1);
        studentBuilder.withFullName(fullName1);
        studentBuilder.withShortName(shortName1);
        studentBuilder.withTaxPayerNumber(tpn1);
        Assert.assertThrows(IllegalArgumentException.class,()->studentBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutTaxPayerNumber(){
        StudentBuilder studentBuilder=new StudentBuilder();
        studentBuilder.withSystemUser(usr1);
        studentBuilder.withEmailAddress(email1);
        studentBuilder.withFullName(fullName1);
        studentBuilder.withShortName(shortName1);
        studentBuilder.withBirthdate(birthdate1);
        Assert.assertThrows(IllegalArgumentException.class,()->studentBuilder.build());
    }

}
