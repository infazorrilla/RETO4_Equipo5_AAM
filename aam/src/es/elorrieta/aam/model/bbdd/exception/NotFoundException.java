package es.elorrieta.aam.model.bbdd.exception;

public class NotFoundException extends Exception{


	private static final long serialVersionUID = 733564574448432175L;

	public NotFoundException(String message) {
		super(message);

	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}
	
}
