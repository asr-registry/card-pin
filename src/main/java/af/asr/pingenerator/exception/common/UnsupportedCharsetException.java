package af.asr.pingenerator.exception.common;

public class UnsupportedCharsetException extends BaseUncheckedException {

	private static final long serialVersionUID = -6711647152648795666L;

	public UnsupportedCharsetException(String errorCode, String errorMessage, Throwable rootCause) {
		super(errorCode, errorMessage, rootCause);
	}

}
