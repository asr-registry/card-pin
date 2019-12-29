package af.asr.cardpin.infrastructure.util;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;

@NoArgsConstructor
public class Hash {

    private static final String SHA_INSTANCE_SHA1 = "SHA-1" ;

    public static byte[] getDigestSHA1 ( String clearText ) throws Exception {

        byte[] digestText = computeDigestSHA ( clearText.getBytes("UTF8") , SHA_INSTANCE_SHA1 ) ;
        return digestText ;

    }

    public static byte[] getDigestSHA1 ( byte[] clearText ) throws Exception {

        byte[] digestText = computeDigestSHA ( clearText, SHA_INSTANCE_SHA1 ) ;
        return digestText ;

    }

    public static byte[] get8BytesDigestSHA1 ( String clearText ) throws Exception {

        byte[] digestText = computeDigestSHA ( clearText.getBytes("UTF8") , SHA_INSTANCE_SHA1 ) ;
        byte[] blkOUT = new byte[8];
        for (int i=0; i < 8; i++){
            blkOUT[i] = digestText[i];
        }
        return blkOUT ;

    }

    /* ---------------------------------------------------------------------------------------------------- */


    private static byte[] computeDigestSHA (byte[] clearText, String SHA_INSTANCE ) throws Exception {

        //MessageDigest   hash = MessageDigest.getInstance("SHA-1", "BC");

        MessageDigest   hash = MessageDigest.getInstance( SHA_INSTANCE );
        hash.update( clearText );
        byte[] digestText = hash.digest() ;
        return digestText;
    }

}