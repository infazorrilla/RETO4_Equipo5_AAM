package es.elorrieta.aam.model.bbdd.exception;

/**
 * Exception class for database access-related errors.
 */
public class AccessToDataBaseException extends Exception {

	private static final long serialVersionUID = 163871246453650619L;

	public AccessToDataBaseException(String message) {
		super(message);

	}

	public AccessToDataBaseException(Throwable cause) {
		super(cause);
	}
}
