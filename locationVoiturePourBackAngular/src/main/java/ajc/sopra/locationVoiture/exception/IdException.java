package ajc.sopra.locationVoiture.exception;

public class IdException extends RuntimeException{
	public IdException() {
		super("id inconnu");
	}
}
