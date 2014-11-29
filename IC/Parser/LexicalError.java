package IC.Parser;

public class LexicalError extends CompilerError {
	private static final long serialVersionUID = 1L; // warning suppression

	public LexicalError(String message) {
		this(message, 0, 0);
	}

	public LexicalError(String message, int line, int column) {
		super("lexical error ; " + message, line, column);
	}
}
