package eapli.ecourse.teacher;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.teacher.domain.Acronym;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.mock;

public class TeacherTest {
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

    private static final  Acronym acronym1=Acronym.valueOf("acronym1");
    private static final  Acronym acronym2=Acronym.valueOf("acronym2");
    private SystemUser usr1;
    private SystemUser usr2;

    @Before
    public void setUp() {
        usr1= mock(SystemUser.class);
        usr2=mock(SystemUser.class);
    }
    @Test
    public void ensureTeacherIsCreatedWithValidData(){
        Teacher teacher1 = new Teacher(usr1,acronym1,fullName1, shortName1,tpn1,birthdate1,email1);
        Teacher teacher2 = new Teacher(usr2,acronym2,fullName2, shortName2,tpn2, birthdate2, email2);
        Assert.assertNotNull(teacher1);
        Assert.assertNotNull(teacher2);
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidEmail() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(usr1,acronym1,fullName1, shortName1,tpn1,birthdate1,null));
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidFullName() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(usr1,acronym1,null, shortName1,tpn1,birthdate1,email1));
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidShortName() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(usr1,acronym1,fullName1, null,tpn1,birthdate1,email1));
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidAcronym() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(usr1,null,fullName1, shortName1,tpn1,birthdate1,email1));
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidBirthdate() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(usr1,acronym1,fullName1, shortName1,tpn1,null,email1));
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidTpn() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(usr1,acronym1,fullName1, shortName1,null,birthdate1,email1));
    }
    @Test
    public void ensureTeacherIsNotCreatedWithInvalidSystemUser() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Teacher(null,acronym1,fullName1, shortName1,tpn1,birthdate1,email1));
    }
    @Test
    public void ensureTeacherEquals(){
        Teacher teacher1 = new Teacher(usr1,acronym1,fullName1, shortName1,tpn1,birthdate1,email1);
        Teacher teacher2 = new Teacher(usr2,acronym2,fullName2, shortName2,tpn2,birthdate2,email2);
        Teacher teacher3 = new Teacher(usr1,acronym1,fullName1, shortName1,tpn1,birthdate1,email1);
        Assert.assertFalse(teacher1.equals(teacher2));
        Assert.assertTrue(teacher1.equals(teacher3));
    }
    @Test
    public void sameTeacher(){
        Teacher teacher1 = new Teacher(usr1,acronym1,fullName1, shortName1,tpn1,birthdate1,email1);
        Teacher teacher2 = new Teacher(usr2,acronym2,fullName2, shortName2,tpn2,birthdate2,email2);
        Assert.assertTrue(teacher1.sameAs(teacher1));
        Assert.assertFalse(teacher1.sameAs(teacher2));
    }
}
