package IC.Parser;

public class LexicalError extends Exception {
	private static final long serialVersionUID = 1L; // warning suppression
	
	private String message;
	private int line;
	private int column;

	public LexicalError(String message) {
		this(message, 0, 0);
	}

	public LexicalError(String message, int line, int column) {
		this.message = line + ": " + message;
		this.line = line;
		this.column = column;
	}

	public String getMessage() {
		return message;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
}
