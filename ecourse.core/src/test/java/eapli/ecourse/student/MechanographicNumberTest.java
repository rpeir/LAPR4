package eapli.ecourse.student;

import eapli.ecourse.student.domain.MechanographicNumber;
import org.junit.Assert;
import org.junit.Test;

public class MechanographicNumberTest {
    @Test
    public void ensureCannotCreateNunmberWithNull(){
        Assert.assertThrows(NullPointerException.class, ()-> MechanographicNumber.valueOf(null));
    }

    @Test
    public void ensureCannotCreateNunmberWithEmptyString(){
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf(""));
    }

    @Test
    public void ensureCannotCreateNunmberWithNotEnoughNumbers(){
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("1"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("12"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("123"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("1234"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("12345"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("123456"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("1234567"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("12345678"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("1234567810"));
    }

    @Test
    public void ensureCannotHaveOtherSymbols() {
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("abcdefgh"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("/!$456789"));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("12345678 "));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("123456789 "));
        Assert.assertThrows(IllegalArgumentException.class, ()-> MechanographicNumber.valueOf("123456789\n"));
    }
}
