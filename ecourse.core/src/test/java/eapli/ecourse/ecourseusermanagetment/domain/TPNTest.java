package eapli.ecourse.ecourseusermanagetment.domain;

import eapli.ecourse.ecourseusermanagement.domain.TPN;
import org.junit.Assert;
import org.junit.Test;

public class TPNTest {
    @Test
    public void ensureCreateValidTPN(){
        TPN tpn=TPN.valueOf("123456788");
        Assert.assertNotNull(tpn);
    }
    @Test
    public void testInvalidTPN(){
        TPN tpn=TPN.valueOf("1");
        Assert.assertFalse(TPN.isValid(tpn.toString()));
    }
    @Test
    public void testValidTPN(){
        TPN tpn=TPN.valueOf("123456789");
        Assert.assertTrue(TPN.isValid(tpn.toString()));

    }
    @Test
    public void testCompareTo(){
        TPN tpn=TPN.valueOf("123456789");
        TPN tpn1=TPN.valueOf("123456788");
        int expected=1;
        Assert.assertEquals(expected,tpn.compareTo(tpn1));

    }
}
