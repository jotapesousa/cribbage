package swtest101.cribbage.exception;

public class NullArgumentException extends InputParseException {

	private static final long serialVersionUID = 419138294774349516L;

	public NullArgumentException(String errorMsg) {
		super(errorMsg);
	}
}