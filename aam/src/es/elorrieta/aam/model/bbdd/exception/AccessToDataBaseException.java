package es.elorrieta.aam.model.bbdd.exception;

public class AccessToDataBaseException extends Exception {

	private static final long serialVersionUID = 163871246453650619L;

	public AccessToDataBaseException(String message) {
		super(message);

	}

	public AccessToDataBaseException(Throwable cause) {
		super(cause);
	}
}
