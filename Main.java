import IC.AST.*;
import IC.Parser.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

import java_cup.runtime.Symbol;

public class Main {

	public static void main(String[] args) {
//		List<Token> tokens = new LinkedList<Token>();
		
		try {

			String libFile = "libic.sig";
			if (args.length > 1) {
				libFile = args[1];
				if (libFile.length() < 3 || !libFile.substring(0, 2).equals("-L")) {
					System.err.println("Error: second argument is of the wrong format.");
				}
				libFile = libFile.substring(2); // skip the -L part of the string
			}
			
			FileReader libReader = new FileReader(libFile);
		    libParser libps = new libParser(new Lexer(libReader));
			Symbol libSym = libps.parse();
			ASTNode libRoot = (ASTNode) libSym.value;
			//Visitor libVisitor = new PrettyPrinter(libFile);
			//System.out.println(libRoot.accept(libVisitor));
			
			FileReader txtFile = new FileReader(args[0]);
		    parser ps = new parser(new Lexer(txtFile));
			Symbol mySym = ps.parse();
			ASTNode rootNode = (ASTNode) mySym.value;
			Visitor v = new PrettyPrinter(args[0]);
			System.out.println("Parsed " + args[0] + " successfully!");
			System.out.println(rootNode.accept(v));

//		    tokens = LexFile(args[0]);
		} catch (Exception e) {
			if (e instanceof LexicalError) {
				PrintTokenError(e.getMessage());
				return;
			}
			throw new RuntimeException("IO Error (brutal exit)" + e.toString());
		}
	}

	public static List<Token> LexFile(String file) throws LexicalError,
			Exception {
		List<Token> tokens = new LinkedList<Token>();
		Token currToken;
		FileReader txtFile = new FileReader(file);
		Lexer scanner = new Lexer(txtFile);

		PrintHeader();
		do {
			currToken = scanner.next_token();
			tokens.add(currToken);
			// print the details of the token only if it's not EOF
			if (currToken.sym != sym.EOF)
				PrintToken(currToken.getValue(), currToken.getTagString(),
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

	public static void PrintTokenError(String errMsg) {
		System.err.println("Error!\t" + errMsg);
	}
}