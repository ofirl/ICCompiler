import IC.AST.*;
import IC.Parser.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

import java_cup.runtime.Symbol;

public class Main {

	public static void main(String[] args) {
		// List<Token> tokens = new LinkedList<Token>();
		ASTNode libRoot;
		ASTNode rootNode;

		try {
			// tokens = LexFile(args[0]);

			String libFile = "libic.sig";
			if (args.length > 1) {
				libFile = args[1];
				if (libFile.length() < 3
						|| !libFile.substring(0, 2).equals("-L")) {
					System.err
							.println("Error: second argument is of the wrong format.");
					return;
				}
				libFile = libFile.substring(2); // skip the -L part
			}

			libRoot = getLibraryAST(libFile, true);
			rootNode = getLibraryAST(args[0]);
			
			if (libRoot == null)
				return; // it means that we failed to parse the Library file

		} catch (Exception e) {
			if (e instanceof CompilerError) {
				CompilerError ce = (CompilerError) e;
				if (ce.shouldPrintMsg())
					System.err.println(ce.getLine() + ":" + ce.getColumn()
							+ " : " + ce.toString());
			} else {
				throw new RuntimeException("IO Error (brutal exit)"
						+ e.toString());
			}
			return;
		}
	}

	// #############################################
	// ############### Functions From PA2 ###############
	// #############################################

	// Returns null if there was a recoverable error.
	public static ASTNode getLibraryAST(String libFile, boolean printAST)
			throws Exception {
		FileReader libReader = new FileReader(libFile);
		LibParser ps = new LibParser(new Lexer(libReader));
		Symbol libSym = ps.parse();
		
		if (ps.parserFailed())
			return null;
		
		ASTNode libRoot = (ASTNode) libSym.value;
		if (printAST) {
			Visitor libVisitor = new PrettyPrinter(libFile);
			System.out.println(libRoot.accept(libVisitor));
		}
		return libRoot;
	}

	public static ASTNode getLibraryAST(String icFile) throws Exception {
		FileReader txtFile = new FileReader(icFile);
		Parser ps = new Parser(new Lexer(txtFile));
		Symbol mySym = ps.parse();

		if (ps.parserFailed())
			throw new SyntaxError("", 0, 0);

		ASTNode rootNode = (ASTNode) mySym.value;
		Visitor v = new PrettyPrinter(icFile);
		System.out.println("Parsed " + icFile + " successfully!");
		System.out.println(rootNode.accept(v));
		return rootNode;
	}

	// #############################################
	// ############### Functions From PA1 ###############
	// #############################################

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