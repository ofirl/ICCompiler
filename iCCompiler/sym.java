package iCCompiler;

public class sym {
	//general
	public static final int EOF = 0;
	public static final int ID = 1;
	public static final int NUM = 2;
	
	// operators
	public static final int PLUS = 3;
	public static final int MINUS = 4;
	public static final int MULTIPLY = 5;
	public static final int DIVIDE = 6;
	public static final int NEGATION = 7;
	public static final int REMINDER = 8;
	public static final int BIG = 9;
	public static final int BIGEQ = 10;
	public static final int SMALL = 11;
	public static final int SMALLEQ = 12;
	public static final int EQ = 13;
	public static final int EQCOMP = 14;
	public static final int AND = 15;
	public static final int OR = 16;
	
	// punctuation
	public static final int OPENROUNDPARENTEHSIS = 17;
	public static final int CLOSEROUNDPARENTHESIS = 18;
	public static final int OPENSQUAREPARENTEHSIS = 19;
	public static final int CLOSESQUAREPARENTHESIS = 20;
	public static final int COLON = 21;
	public static final int SEMI = 22;
	public static final int COMMA = 42;
	
	//saved keywords : class extends static void int boolean string
	//return if else while break continue this
	//new length true false null
	public static final int CLASSID = 23;
	public static final int EXTENDS = 24;
	public static final int STATIC = 25;
	public static final int VOID = 26;
	public static final int INT = 27;
	public static final int BOOLEAN = 28;
	public static final int STRING = 29;
	public static final int RETURN = 30;
	public static final int IF = 31;
	public static final int ELSE = 32;
	public static final int WHILE = 33;
	public static final int BREAK = 34;
	public static final int CONTINUE = 35;
	public static final int THIS = 36;
	public static final int NEW = 37;
	public static final int LENGTH = 38;
	public static final int TRUE = 39;
	public static final int FALSE = 40;
	public static final int NULL = 41;
}
