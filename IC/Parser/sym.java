package IC.Parser;

public class sym {
	// general
	public static final int EOF = 0;
	public static final int ID = 1;
	public static final int NUM = 2;
	public static final int CLASS_ID = 3;
	public static final int STR = 4; // an actual string like "Nice"

	// operators
	public static final int PLUS = 10;
	public static final int MINUS = 11;
	public static final int MULTIPLY = 12;
	public static final int DIVIDE = 13;
	public static final int NEGATION = 14;
	public static final int REMAINDER = 15;
	public static final int BIG = 16;
	public static final int BIGEQ = 17;
	public static final int SMALL = 18;
	public static final int SMALLEQ = 19;
	public static final int EQ = 20;
	public static final int EQCOMP = 21;
	public static final int AND = 22;
	public static final int OR = 23;
	public static final int DOT = 24;
	public static final int NOTEQCOMP = 25;

	// punctuation
	public static final int OPENROUNDPARENTEHSIS = 30;
	public static final int CLOSEROUNDPARENTHESIS = 31;
	public static final int OPENSQUAREPARENTEHSIS = 32;
	public static final int CLOSESQUAREPARENTHESIS = 33;
	public static final int SEMI = 34;
	public static final int COMMA = 35;
	public static final int OPENCURLYPARENTEHSIS = 36;
	public static final int CLOSECURLYPARENTHESIS = 37;

	// saved keywords : class extends static void int boolean string
	// return if else while break continue this
	// new length true false null
	public static final int CLASS = 50;
	public static final int EXTENDS = 51;
	public static final int STATIC = 52;
	public static final int VOID = 53;
	public static final int INT = 54;
	public static final int BOOLEAN = 55;
	public static final int STRING = 56; // the keyword string
	public static final int RETURN = 57;
	public static final int IF = 58;
	public static final int ELSE = 59;
	public static final int WHILE = 60;
	public static final int BREAK = 61;
	public static final int CONTINUE = 62;
	public static final int THIS = 63;
	public static final int NEW = 64;
	public static final int LENGTH = 65;
	public static final int TRUE = 66;
	public static final int FALSE = 67;
	public static final int NULL = 68;
}
