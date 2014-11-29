package IC.Parser;

public class SyntaxError extends CompilerError {
	private static final long serialVersionUID = 1L; // warning suppression
	
	public SyntaxError(String message, int line, int column) {
		super("syntax error ; " + message, line, column);
	}
}
