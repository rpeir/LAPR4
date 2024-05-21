package eapli.ecourse.teacher;

import eapli.ecourse.teacher.domain.Acronym;
import org.junit.Assert;
import org.junit.Test;

public class AcronymTest {
    @Test
    public void ensureCreateValidAcronym(){
        Acronym acronym=Acronym.valueOf("AAAA");
        Acronym acronym1=Acronym.valueOf("BBBB");
        Assert.assertNotNull(acronym);
        Assert.assertNotNull(acronym1);
    }
    @Test
    public void testCompareTo(){
        Acronym acronym=Acronym.valueOf("AAAA");
        Acronym acronym1=Acronym.valueOf("BBBB");
        int expected=-1;
        Assert.assertEquals(expected,acronym.compareTo(acronym1));

    }
    @Test
    public void testValidateInvalidAcronym(){
        Acronym acronym=Acronym.valueOf("AAAAA");
        Assert.assertFalse(acronym.validateAcronym("AAAAA"));
    }
    @Test
    public void testValidateValidAcronym(){
        Acronym acronym1=Acronym.valueOf("BBB");
        Acronym acronym2=Acronym.valueOf("CC");
        Assert.assertTrue(acronym1.validateAcronym("BBB"));
        Assert.assertFalse(acronym2.validateAcronym("CC"));

    }

}
