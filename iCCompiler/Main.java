package iCCompiler;

import java.io.*;
import JFlex.*;

public class Main {
	
	public static void main(String[] args) {
	    Token currToken;
	    try {
	        FileReader txtFile = new FileReader(args[0]);
	        Lexer scanner = new Lexer(txtFile); 
	        //Lexer will be the class name when we compile our lexer
	        System.out.println("token\ttag\tline : column");
	        
	        do {
	            currToken = scanner.next_token();
	            PrintToken("" + currToken.getValue(), currToken.getTag(), currToken.getLine(), currToken.getColumn());
	            
	        } while (currToken.sym != sym.EOF);
	    
	    } catch (Exception e) {
	        throw new RuntimeException("IO Error (brutal exit)" + e.toString());
	    }
	  }

	/* This function was given in the exercise. */
	public static void PrintToken(String token,String tag , int line , int column) {
		System.out. println (token+"\t"+tag+"\t"+line+":"+column);
	}
}
