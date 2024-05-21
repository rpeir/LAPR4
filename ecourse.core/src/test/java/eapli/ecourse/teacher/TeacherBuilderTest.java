package eapli.ecourse.teacher;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.teacher.domain.Acronym;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.domain.TeacherBuilder;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.mock;

public class TeacherBuilderTest {
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

    private static final Acronym acronym1=Acronym.valueOf("acronym1");
    private static final  Acronym acronym2=Acronym.valueOf("acronym2");
    private SystemUser usr1;
    private SystemUser usr2;
    @Before
    public void setUp() {
        usr1= mock(SystemUser.class);
        usr2=mock(SystemUser.class);
    }
    @Test
    public void ensureBuildsValidTeacher(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        teacherBuilder.withSystemUser(usr1);
        Teacher teacher=teacherBuilder.build();
        Assert.assertNotNull(teacher);
        Assert.assertEquals(teacher.user(), usr1);
        Assert.assertEquals(teacher.identity(), email1);
        Assert.assertEquals(teacher.acronym(), acronym1);
    }
    @Test
    public void ensureCannotBuildWithoutSystemUser(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutAcronym(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        teacherBuilder.withSystemUser(usr1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutBirthdate(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        teacherBuilder.withSystemUser(usr1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutEmailAddress(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        teacherBuilder.withSystemUser(usr1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutFullName(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        teacherBuilder.withSystemUser(usr1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutShortName(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withTaxPayerNumber(tpn1);
        teacherBuilder.withSystemUser(usr1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutTaxPayerNumber(){
        TeacherBuilder teacherBuilder=new TeacherBuilder();
        teacherBuilder.withAcronym(acronym1);
        teacherBuilder.withBirthdate(birthdate1);
        teacherBuilder.withEmailAddress(email1);
        teacherBuilder.withFullName(fullName1);
        teacherBuilder.withShortName(shortName1);
        teacherBuilder.withSystemUser(usr1);
        Assert.assertThrows(IllegalArgumentException.class,()->teacherBuilder.build());
    }
}
