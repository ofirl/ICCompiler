package IC.Parser;

public abstract class CompilerError extends Exception {
	private static final long serialVersionUID = 1L; // warning suppression

	private String message;
	private int line;
	private int column;
	private boolean printMsg; // signal to Main if error should be printed

	protected CompilerError(String message, int line, int column,
			boolean printMsg) {
		this.message = message;
		this.line = line;
		this.column = column;
		this.printMsg = printMsg;
	}

	public boolean shouldPrintMsg() {
		return printMsg;
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
