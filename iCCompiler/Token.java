package iCCompiler;

import java_cup.runtime.Symbol;

public class Token extends Symbol {

	private int id;
	private int line;
	private int column;
	private String tag;
	private String value;

	public Token(int sym_num) { // not used, just so there wont be errors
		super(sym_num);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String getTag() {
		return tag;
	}

	public String getValue() {
		return value;
	}
}
