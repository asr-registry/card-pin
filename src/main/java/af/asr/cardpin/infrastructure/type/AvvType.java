package af.asr.cardpin.infrastructure.type;

/**
 * TODO not yet implemented.
 */
public class AvvType {

    public enum FormatVersionNumber {

        AUTHENTICATED(0), ATTEMP(1) ;

        public int getValue(){
            return 0 ;
        }

        @SuppressWarnings("unused")
        private int value;

        private FormatVersionNumber (int value) {
            this.value = value;
        }
    }

    public enum MacAlgorithmType {
        HMAC,  CVC2 ;
    }

}