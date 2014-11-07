package iCCompiler;

import java_cup.runtime.Symbol;

public class Token extends Symbol {
	
	public Token(int sym_num) { //not used, just so there wont be errors
		super(sym_num);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return 0;
	}

	public Object getValue() {
		return null;
	}

	public int getLine() {
		return 0;
	}
}
