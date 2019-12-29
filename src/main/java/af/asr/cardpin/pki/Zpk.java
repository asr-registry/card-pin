package af.asr.cardpin.pki;

import af.asr.cardpin.infrastructure.exception.pki.DesKeyException;

/**
 * ZPK Zone Pin  Key
 * <p>
 */
public class Zpk extends DesKey {

    private int version ;

    public Zpk (String aKey ) throws DesKeyException {

        super(aKey );
        this.version = 1 ;
    }

    public Zpk (String aKey, int aVersion ) throws DesKeyException  {

        super(aKey );
        this.version = aVersion ;
    }

    public int getVersion () {
        return this.version ;
    }

}