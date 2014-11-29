package IC.Parser;

public abstract class CompilerError extends Exception {
	private static final long serialVersionUID = 1L; // warning suppression
	
	private String message;
	private int line;
	private int column;
	
	protected CompilerError(String message, int line, int column) {
		this.message = message;
		this.line = line;
		this.column = column;
	}
	
	public String toString() {
		return message;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
}
