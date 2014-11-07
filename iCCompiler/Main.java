package iCCompiler;

import java.io.*;
import java_cup.runtime.Symbol;

public class Main {
	
	public static void main(String[] args) {
	    Symbol currToken;
	    try {
	        FileReader txtFile = new FileReader(args[0]);
	        Lexer scanner = new Lexer(txtFile); 
	        //Lexer will be the class name when we compile our lexer
	        do {
	            currToken = scanner.next_token();
	            //TODO : create a token from the symbol.
	            
	        } while (currToken.sym != sym.EOF);
	    
	    } catch (Exception e) {
	        throw new RuntimeException("IO Error (brutal exit)" + e.toString());
	    }
	  }

	/* This function was given in the exercise. */
	public static void PrintToken(String token,String tag , int line , int column) {
		System.out. println (token+"/t"+tag+"/t"+line+":"+column);	
	}
}
