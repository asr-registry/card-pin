package af.asr.cardpin.pki;


import static org.junit.Assert.*;

import af.asr.cardpin.infrastructure.exception.pki.DesKeyException;
import org.junit.Test;


public class DesKeyTest {

    public String simpleKeyStr = "0123456789ABCDEF" ;
    public String doubleKeyStr = "F1FD8AC2EFCE3BC8F1FD8AC2EFCE3BC8" ;
    public String simpleKeyCheckValue = "D5D44F";
    public String doubleKeyCheckValue = "13F5CC";

    @Test
    public void testDesKeyString() {
        DesKey a = null ;
        try{
            a = new DesKey(simpleKeyStr ) ;
        }
        catch ( DesKeyException e ){
            System.out.println("Exception : " + e.getMessage() ) ;
        }
        try {
            if ( a.getCheckValueAsString().equals( simpleKeyCheckValue)  ){
                System.out.printf("testDesKeyString() for Key %s expected is %s returned is %s \n", simpleKeyStr, simpleKeyCheckValue, a.getCheckValueAsString() );
                assertTrue( true) ;
            }else{
                System.out.printf("testDesKeyString() for Key %s expected is %s returned is %s \n", simpleKeyStr, simpleKeyCheckValue, a.getCheckValueAsString() );
                assertFalse( true) ;
            }
        }catch ( DesKeyException e  ){
            System.out.println("Exception : " + e.getMessage() ) ;
        }
    }


}