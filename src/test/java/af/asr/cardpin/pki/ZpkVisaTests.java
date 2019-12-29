package af.asr.cardpin.pki;

import static org.junit.Assert.*;

import af.asr.cardpin.infrastructure.exception.pki.DesKeyException;
import org.junit.BeforeClass;
import org.junit.Test;


public class ZpkVisaTests {

    public String doubleKeyStr = "0170F175468FB5E60213233243526273" ;
    public String doubleKeyCheckValue = "58D4C6";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }


    @Test
    public void testZpkDouble() {
        Zpk a = null ;
        try{
            a = new Zpk(doubleKeyStr) ;
        }
        catch ( DesKeyException e ){
            System.out.println("Exception : " + e.getMessage() ) ;
        }
        if ( a.getKeyAsString().equals (doubleKeyStr) ){
            System.out.printf("testZpkDouble() for Key expected is %s returned is %s \n", doubleKeyStr, a.getKeyAsString());
            assertTrue( true) ;
        }else{
            System.out.printf("testZpkDouble() for Key expected is %s returned is %s \n", doubleKeyStr, a.getKeyAsString());
            assertFalse( true) ;
        }
    }


    @Test
    public void testZpkCheckValueDouble() {
        Zpk a = null ;
        try{
            a = new Zpk(doubleKeyStr) ;
        }
        catch ( DesKeyException e ){
            System.out.println("Exception : " + e.getMessage() ) ;
        }


        try {
            if ( a.getCheckValueAsString().equals( doubleKeyCheckValue)  ){
                System.out.printf("testZpkCheckValueDouble() for Key %s expected is %s returned is %s \n", doubleKeyStr, doubleKeyCheckValue, a.getCheckValueAsString() );
                assertTrue( true) ;
            }else{
                System.out.printf("testZpkCheckValueDouble() for Key %s expected is %s returned is %s \n", doubleKeyStr, doubleKeyCheckValue, a.getCheckValueAsString() );
                assertFalse( true) ;
            }
        }catch ( DesKeyException e  ){
            System.out.println("Exception : " + e.getMessage() ) ;
        }

    }

}