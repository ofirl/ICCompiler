package IC.Parser;

import java_cup.runtime.Symbol;

public class Token extends Symbol {

	private int tag;
	private int line;
	private int column;
	private String tagStr; // used for printing the tag as a String
	private String value;

	public Token(int sym_num, String tagStr, int line, int column) {
		super(sym_num);
		tag = sym_num;
		this.line = line + 1;
		this.column = column + 1;
		this.tagStr = tagStr;
	}
	
	public Token(int sym_num, String tagStr, int line, int column, String value) {
		super(sym_num);
		tag = sym_num;
		this.line = line + 1;
		this.column = column + 1;
		this.value = value;
		this.tagStr = tagStr;
	}

	public int getTag() {
		return tag;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String getTagString() {
		return tagStr;
	}

	public String getValue() {
		return value;
	}
}
