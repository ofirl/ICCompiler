package iCCompiler;

public class LexicalError extends Exception {
	private static final long serialVersionUID = 1L; //warning suppression
	
	public LexicalError(String message) {
		System.out.println(message);
	}
}
