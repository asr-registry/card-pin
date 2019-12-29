package af.asr.cardpin.infrastructure.raw;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;


public class Big {

    protected static BigInteger BigIntegerZERO = BigInteger.ZERO;
    protected static BigInteger BigIntegerONE = BigInteger.ONE;
    protected static BigInteger BigIntegerTWO = BigInteger.valueOf(2);
    protected static BigInteger BigIntegerTHREE=BigInteger.valueOf(3);
    protected static BigInteger FactorialBreakpoint = BigInteger.valueOf(96);
    protected static BigDecimal BigDecimalZERO = BigDecimal.ZERO;
    protected static BigDecimal BigDecimalONE = BigDecimal.ONE;
    protected static BigDecimal BigDecimalTWO = new BigDecimal(2);
    protected static BigDecimal BigDecimalFOUR = new BigDecimal(4);

    public static BigInteger sqrt(BigInteger number)
    {
        return sqrt(number, BigIntegerONE);
    }

    public static BigDecimal sqrt(BigDecimal number, RoundingMode rounding)
    {
        return sqrt(number, BigDecimalONE, rounding);
    }

    protected static BigInteger sqrt(BigInteger number, BigInteger guess)
    {
        // ((n/g) + g)/2: until same result twice in a row
//	    BigInteger result = number.divide(guess).add(guess).divide(BigIntegerTWO);
//	    if(result.compareTo(guess) == 0)
//	      return result;
        //
//	    return sqrt(number, result);

        // redoing this to avoid StackOverFlow
        BigInteger result = BigIntegerZERO;
        BigInteger flipA = result;
        BigInteger flipB = result;
        boolean first = true;
        while( result.compareTo(guess) != 0 )
        {
            if(!first)
                guess = result;
            else
                first=false;

            result = number.divide(guess).add(guess).divide(BigIntegerTWO);
            // handle flip flops
            if(result.equals(flipB))
                return flipA;

            flipB = flipA;
            flipA = result;
        }
        return result;

    }
    public static BigDecimal sqrt(BigDecimal number, BigDecimal guess, RoundingMode rounding)
    {
        BigDecimal result = BigDecimalZERO;
        BigDecimal flipA = result;
        BigDecimal flipB = result;
        boolean first = true;
        while( result.compareTo(guess) != 0 )
        {
            if(!first)
                guess = result;
            else
                first=false;

            result = number.divide(guess, rounding).add(guess).divide(BigDecimalTWO, rounding);
            // handle flip flops
            if(result.equals(flipB))
                return flipA;

            flipB = flipA;
            flipA = result;
        }
        return result;
    }

}