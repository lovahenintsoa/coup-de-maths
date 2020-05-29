package service.exception;
/**
 * 
 * @author Lova
 * Cr�ation de la classe d'exception UserException qui herite Exception
 *
 */
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;
	
	
	public UserException(String message) {
		super(message);	
		// possede automatiquement la propri�t� e.getmessage
	}
	
	public UserException(int code, String message) {
		super(message);	
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
