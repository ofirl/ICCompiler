package IC.Parser;

import java.util.HashMap;
import java.util.Map;

import java_cup.runtime.Symbol;

public class Token extends Symbol {

	private int tag;
	private int line;
	private int column;
	private String tagStr; // used for printing the tag as a String
	private String value;

	public Token(int sym_num, String tagStr, int line, int column, String value) {
		// line+1 will be the left field in the parent class and column+1 will
		// be the right field.
		super(sym_num, line + 1, column + 1, value);
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

	// #############################################
	// ################## static part ##################
	// #############################################

	private static Map<String, String> tagMap = initiailizeMap();

	public static String convertTag(String tag) {
		return tagMap.get(tag);
	}

	private static Map<String, String> initiailizeMap() {
		Map<String, String> myMap = new HashMap<String, String>();
		
		/* keywords */
		myMap.put("CLASS", "class");
		myMap.put("EXTENDS", "extends");
		myMap.put("STATIC", "static");
		myMap.put("VOID", "void");
		myMap.put("INT", "int");
		myMap.put("BOOLEAN", "boolean");
		myMap.put("STRING", "string");
		myMap.put("RETURN", "return");
		myMap.put("IF", "if");
		myMap.put("ELSE", "else");
		myMap.put("WHILE", "while");
		myMap.put("BREAK", "break");
		myMap.put("CONTINUE", "continue");
		myMap.put("THIS", "this");
		myMap.put("NEW", "new");
		myMap.put("LENGTH", "length");
		myMap.put("TRUE", "true");
		myMap.put("FALSE", "false");
		myMap.put("NULL", "null");
	
		/* Strings */
		myMap.put("STR", "STRING");
		
		/* identifiers */
		myMap.put("CLASS_ID", "CLASS_ID");
		myMap.put("ID", "ID");
		
		/* literals */
		myMap.put("NUM", "INTEGER");
		
		/* operators */
		myMap.put("EQ", "=");
		myMap.put("EQCOMP", "==");
		myMap.put("NOTEQCOMP", "!=");
		myMap.put("PLUS", "+");
		myMap.put("MINUS", "-");
		myMap.put("MULTIPLY", "*");
		myMap.put("DIVIDE", "/");
		myMap.put("REMAINDER", "%");
		myMap.put("NEGATION", "!");
		myMap.put("BIG", ">");
		myMap.put("BIGEQ", ">=");
		myMap.put("SMALL", "<");
		myMap.put("SMALLEQ", "<=");
		myMap.put("AND", "&&");
		myMap.put("OR", "||");
		myMap.put("DOT", ".");
		
		/* Punctuation */
		myMap.put("SEMI", ";");
		myMap.put("COMMA", ",");
		
		/* Parenthesis */
		myMap.put("LP", "(");
		myMap.put("RP", ")");
		myMap.put("LB", "[");
		myMap.put("RB", "]");
		myMap.put("LCBR", "{");
		myMap.put("RCBR", "}");
		
		return myMap;
	}
}
