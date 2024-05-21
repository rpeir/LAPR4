package eapli.ecourse.student;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.student.domain.Student;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentTest {

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
    public void ensureStudentIsCreatedWithValidData() {
       Student student1 = new Student(usr1,email1, fullName1, shortName1, birthdate1, tpn1);
       Student student2 = new Student(usr2, email2, fullName2, shortName2, birthdate2, tpn2);
        Assert.assertNotNull(student1);
        Assert.assertNotNull(student2);

    }
    @Test
    public void ensureStudentIsNotCreatedWithInvalidEmail() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Student(usr1, null, fullName1, shortName1, birthdate1, tpn1));
    }

    @Test
    public void ensureStudentIsNotCreatedWithInvalidFullName() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Student(usr1, email1, null, shortName1, birthdate1, tpn1));
    }
    @Test
    public void ensureStudentIsNotCreatedWithInvalidShortName() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Student(usr1, email1, fullName1, null, birthdate1, tpn1));
    }
    @Test
    public void ensureStudentIsNotCreatedWithInvalidBirthdate() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Student(usr1, email1, fullName1, shortName1, null, tpn1));
    }
    @Test
    public void ensureStudentIsNotCreatedWithInvalidTPN() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Student(usr1, email1, fullName1, shortName1, birthdate1, null));
    }
    @Test
    public void ensureStudentIsNotCreatedWithInvalidSystemUser() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Student(null, email1, fullName1, shortName1, birthdate1, tpn1));
    }
    @Test
    public void ensureStudentEquals(){
        Student student1 = new Student(usr1,email1, fullName1, shortName1, birthdate1, tpn1);
        Student student2 = new Student(usr2, email2, fullName2, shortName2, birthdate2, tpn2);
        Assert.assertTrue(student1.equals(student1));
        Assert.assertFalse(student1.equals(student2));
    }
    @Test
    public void sameStudent(){
        Student student1 = new Student(usr1,email1, fullName1, shortName1, birthdate1, tpn1);
        Student student2 = new Student(usr2, email2, fullName2, shortName2, birthdate2, tpn2);
        Assert.assertTrue(student1.sameAs(student1));
        Assert.assertFalse(student1.sameAs(student2));
    }



}
