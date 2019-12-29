package af.asr.cardpin.infrastructure.raw;

/**
 * ASCII data Utilities
 */
public final class Ascii
{
    /**
     * Convert an int to a numeric byte ascii array of bytes.
     * <p>
     * Example:<br>
     * input  :<br>
     * 1234567890<br>
     * output :<br>
     * (byte)0x31,(byte)0x32,(byte)0x33,(byte)0x34,(byte)0x35,<br>
     * (byte)0x36,(byte)0x37,(byte)0x38,(byte)0x39,(byte)0x30 <br>
     *
     *
     * @param 	value input value
     * @return	byte[] ascii coded
     */
    public static byte[] int2byteArray ( int value ){


        String str = String.valueOf( value ) ;
        byte[] bar = new byte[ str.length() ];
        for (int i=0; i<str.length(); i++){
            char z = str.charAt( i );
            byte b = (byte) ( z );
            bar[i] = b ;
        }
        return bar ;
    }
//

    /** Check if a byte is an ASCII numeric Coded.
     * <p>
     * Note : ASCII numeric values are between 0x30 and 0x39
     * @param 	abyte     byte to be checked
     * @return  boolean
     *
     */
    public static boolean isNumeric( byte abyte ) {

        if ( abyte < 0x30 ||  abyte > 0x39 ) return false ;

        return true ;
    }
    /** Check if a byte array is ASCII numeric Coded.
     * <p>
     * Note : ASCII numeric values are between 0x30 and 0x39
     * @param 	abytearr     byte array to be checked
     * @return  boolean
     *
     */
    public static boolean isNumeric ( byte[] abytearr ) {

        for (int i=0;i< abytearr.length;i++){
            if ( ! isNumeric ( abytearr[i] ) ) return false ;
        }
        return true ;
    }
    /** Check if a character is an ASCII numeric Coded.
     * <p>
     * Note : ASCII numeric values are between 0x30 and 0x39
     * @param 	c char digit to be checked
     * @return  boolean
     *
     */
    public static boolean isNumeric ( char c ) {

        byte abyte = (byte) c ;
        return  isNumeric ( abyte ) ;

    }

    /** Check if a byte is an Hexadecimal numeric Coded (from 0 to 9, A to F and a to f ).
     * <p>
     * Note : Hexadecimal numeric values are between<br>
     *  0x30 and 0x39  ( from 0 to 9) <br>
     *  0x41 and 0x46  ( from A to F) <br>
     *  0x61 and 0x66  ( from a to f) <br>
     * @param 	abyte     byte to be checked
     * @return  boolean
     *
     */
    public static boolean isNumericHex( byte abyte ) {

        if ( abyte >= 0x30 && abyte <= 0x39 ) return true ;		// From 0 to 9
        if ( abyte >= 0x41 && abyte <= 0x46 ) return true ;		// from A to F
        if ( abyte >= 0x61 && abyte <= 0x66 ) return true ;		// from a to f

        return false ;
    }

    /** Check if a character is an Hexadecimal numeric Coded (from 0 to 9, A to F and a to f ).
     * <p>
     * Note : Hexadecimal numeric values are between<br>
     *  0x30 and 0x39  ( from 0 to 9) <br>
     *  0x41 and 0x46  ( from A to F) <br>
     *  0x61 and 0x66  ( from a to f) <br>
     * @param 	c char to be checked
     * @return  boolean
     *
     */
    public static boolean isNumericHex( char c ) {

        byte abyte = (byte) c ;
        return  isNumericHex( abyte ) ;

    }
    /** Check if a byte array is an Hexadecimal numeric Coded (from 0 to 9, A to F and a to f ).
     * <p>
     * Note : Hexadecimal numeric values are between<br>
     *  0x30 and 0x39  ( from 0 to 9) <br>
     *  0x41 and 0x46  ( from A to F) <br>
     *  0x61 and 0x66  ( from a to f) <br>
     * @param 	abytearr byte array to be checked
     * @return  boolean
     *
     */
    public static boolean isNumericHex ( byte[] abytearr ) {

        for (int i=0;i< abytearr.length;i++){
            if ( ! isNumericHex( abytearr[i] ) ) return false ;
        }
        return true ;
    }
    /**
     * <p>Checks whether the character is ASCII 7 bit printable.</p>
     *
     * <pre>
     *   isPrintable('a')  = true
     *   isPrintable('A')  = true
     *   isPrintable('3')  = true
     *   isPrintable('-')  = true
     *   isPrintable('\n') = false
     *   isPrintable('&copy;') = false
     * </pre>
     *
     * @param ch  the character to check
     * @return true if between 32 and 126 inclusive
     */
    public static boolean isPrintable(char ch) {
        return ( ch >= 32 && ch < 127 );
    }
    /**
     * Compress an Ascii (hexadecimal) numeric byte array.
     * <p>
     * Example :
     * <pre>
     *  Input  : (byte)0x31,(byte)0x32,(byte)0x33,(byte)0x34,(byte)0x35,(byte)0x36,(byte)0x37,(byte)0x38 ( i.e. 12345678 )
     *  Output : (byte)0x12,(byte)0x34,(byte)0x56,(byte)0x78
     * </pre>
     * @param blkIN input Ascii numeric byte array
     * @return compressed byte array
     * @exception java.lang.IllegalArgumentException if an illegal value arrives
     *
     */
    public static byte[] compressBlock(byte[] blkIN)  throws IllegalArgumentException{

        if ( ! Ascii.isNumericHex ( blkIN ) ) throw new IllegalArgumentException("Ascii.compressBlock - is not an numeric (hex) byte array") ;
        byte[] blkdummy = new byte[ blkIN.length ];
        for (int i=0;i<blkIN.length;i++){
            byte abyte = blkIN [i] ;
            if ( abyte >= 0x30 && abyte <= 0x39 ) {
                blkdummy[i] = (byte) (blkIN [i] - 0x30 ) ; // for '0' to '9'
            }else
            if ( abyte >= 0x41 && abyte <= 0x46 ) {
                blkdummy[i] = (byte) (blkIN [i] - 0x41 + 0x0A) ; // for 'A' to 'F'
            }else
            if ( abyte >= 0x61 && abyte <= 0x66 ) {
                blkdummy[i] = (byte) (blkIN [i] - 0x61 + 0x0A) ; // for 'a' to 'f'
            }
        }
        return Binary.compressBlock( blkdummy );
    }

    /**
     * Returns numeric value (as bytes) from an input hex array.
     * <p>
     * Example :
     * <pre>
     *  Input  : (byte)0x61,(byte)0x62,(byte)0x33,(byte)0x34,(byte)0x35,(byte)0x36,(byte)0x41,(byte)0x42 ( i.e. 12345678 )
     *  Output : (byte)0x0A,(byte)0x0B,(byte)0x03,(byte)0x04,(byte)0x05,(byte)0x06,(byte)0x0A,(byte)0x0B
     * </pre>
     * @param  blkIN input Ascii numeric byte array
     * @return numeric value as bytes
     * @exception java.lang.IllegalArgumentException if an illegal value arrives
     *
     */
    public static byte[] getNumericValue(byte[] blkIN)  throws IllegalArgumentException{

        if ( ! Ascii.isNumericHex ( blkIN ) ) throw new IllegalArgumentException("Ascii.getNumericValue - is not an numeric (hex) byte array") ;
        byte[] blkdummy = new byte[ blkIN.length ];
        for (int i=0;i<blkIN.length;i++){
            byte abyte = blkIN [i] ;
            if ( abyte >= 0x30 && abyte <= 0x39 ) {
                blkdummy[i] = (byte) (blkIN [i] - 0x30 ) ; // for '0' to '9'
            }else
            if ( abyte >= 0x41 && abyte <= 0x46 ) {
                blkdummy[i] = (byte) (blkIN [i] - 0x41 + 0x0A) ; // for 'A' to 'F'
            }else
            if ( abyte >= 0x61 && abyte <= 0x66 ) {
                blkdummy[i] = (byte) (blkIN [i] - 0x61 + 0x0A) ; // for 'a' to 'f'
            }
        }
        return blkdummy ;
    }

    /**
     * Convert an input ASCII byte array to int.
     * Example : (byte)0x36,(byte)0x35,(byte)0x35,(byte)0x33 --{@literal >} 6553
     * <p>
     * @param 	abytearr ASCII coded
     * @return 	int result
     */
    public static int toInt ( byte[] abytearr ) throws IllegalArgumentException {

        long value = toLong ( abytearr);
        if ( value < Integer.MIN_VALUE ) throw new IllegalArgumentException("int data underflow");
        if ( value > Integer.MAX_VALUE ) throw new IllegalArgumentException("int data overflow") ;
        int returned = (int) value;
        return returned ;
    }
    /**
     * Convert an input numeric ASCII byte array (up to 8 bytes) to long.
     * <p>
     * @param 	abytearr numeric ASCII coded
     * @return 	long	value
     */
    public static long toLong ( byte[] abytearr ) throws IllegalArgumentException {
        long value = 0L;
        int num = abytearr.length;
        if ( ! isNumeric( abytearr ) ) throw new IllegalArgumentException("only 8 bytes ASCII numeric data allowed !!") ;
        if ( num > 8 ) throw new IllegalArgumentException("only 8 bytes ASCII numeric data allowed !!") ;
        byte[] ab = new byte[num];
        for (int i=0; i<num;i++){
            ab[i] = (byte)( abytearr[i] - 0x30  );
            value = value + (long) (  ab[i] *  Math.pow( 10 , num - i - 1  ) ) ;
        }
        return value ;
    }

    /*
     * Convert an input String to his hexadecimal codification.
     * <p>
     * @param 	s input string
     * @return 	string hexadecimal representation
     */
	/*public static String encodeHex ( String s ) {

		String hexString = Hex.encodeHexString( s.getBytes() );
		return hexString ;

	}*/

    /**
     * Checks if the string contains only ASCII printable characters.
     *
     * <code>null</code> will return <code>false</code>.
     * An empty String ("") will return <code>true</code>.
     *
     * <pre>
     * isPrintable(null)     = false
     * isPrintable("")       = true
     * isPrintable(" ")      = true
     * isPrintable("Ceki")   = true
     * isPrintable("ab2c")   = true
     * isPrintable("!ab-c~") = true
     * isPrintable("\u0020") = true
     * isPrintable("\u0021") = true
     * isPrintable("\u007e") = true
     * isPrintable("\u007f") = false
     * isPrintable("Ceki G\u00fclc\u00fc") = false
     * </pre>
     *
     * @param str the string to check, may be null
     * @return <code>true</code> if every character is in the range
     *  32 thru 126
     * @since 2.1
     */
    public static boolean isPrintable( String str ) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (isPrintable(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

}