package iCCompiler;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import JFlex.*;

public class Main {
	
	public static void main(String[] args) {
	    
		Collection<Token> tokens = LexFile(args[0]);
		
		for (Token currToken : tokens){
			PrintToken(currToken.getValue(), currToken.getTag(), currToken.getLine(), currToken.getColumn());
		}
	  }

	public static Collection<Token> LexFile(String file)
	{
		Collection<Token> tokens = new ArrayList<>();
		
		Token currToken;
	    try {
	        FileReader txtFile = new FileReader(file);
	        Lexer scanner = new Lexer(txtFile); 
	        System.out.println("token\ttag\tline : column");
	        
	        do {
	            currToken = scanner.next_token();
	            tokens.add(currToken);	            
	        } while (currToken.sym != sym.EOF);
	    
	    } catch (Exception e) {
	        throw new RuntimeException("IO Error (brutal exit)" + e.toString());
	    }
		
		return tokens;
	}
	
	/* This function was given in the exercise. */
	public static void PrintToken(String token,String tag , int line , int column) {
		System.out. println (token+"\t"+tag+"\t"+line+":"+column);
	}
}
