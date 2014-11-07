package iCCompiler;

import java_cup.runtime.Symbol;

public class Token extends Symbol {

	private int id;
	private int line;
	private int column;
	private String tag;
	private String value;

	public Token(int sym_num, String tag, int line, int column) {
		super(sym_num);
		id = sym_num;
		this.line = line;
		this.column = column;
		this.tag = tag;
	}
	
	public Token(int sym_num, String tag, int line, int column, String value) {
		super(sym_num);
		id = sym_num;
		this.line = line;
		this.column = column;
		this.value = value;
		this.tag = tag;
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
