package iCCompiler;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import JFlex.*;

public class Main {

	public static void main(String[] args) {
		Collection<Token> tokens = null;
		
		try {
			tokens = LexFile(args[0]);
		} catch (LexicalError e) {
			PrintTokenError(e.getMessage(), e.getLine(), e.getColumn());
		} catch (Exception e) {
			throw new RuntimeException("IO Error (brutal exit)" + e.toString());
		}
	}

	public static Collection<Token> LexFile(String file) throws LexicalError,
			Exception {
		Collection<Token> tokens = new ArrayList<>();
		Token currToken;
		FileReader txtFile = new FileReader(file);
		Lexer scanner = new Lexer(txtFile);

		PrintHeader();
		do {
			currToken = scanner.next_token();
			tokens.add(currToken);
			if (currToken.sym != sym.EOF) // print token details only if it's
											// not EOF
				PrintToken(currToken.getValue(), currToken.getTag(),
						currToken.getLine(), currToken.getColumn());
		} while (currToken.sym != sym.EOF);

		return tokens;
	}

	public static void PrintHeader() {
		System.out.println("token\ttag\tline :column");
	}

	public static void PrintToken(String token, String tag, int line, int column) {
		System.out.println(token + "\t" + tag + "\t" + line + ":" + column);
	}

	public static void PrintTokenError(String token, int line, int column) {
		System.err.println("Error!\t" + token + "\t" + "\t" + line + ":"
				+ column);
	}
}