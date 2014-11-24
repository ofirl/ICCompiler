import IC.Parser.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Token> tokens = new LinkedList <Token> ();

		try {
			tokens = LexFile(args[0]);
		} catch (LexicalError e) {
			PrintTokenError(e.getLine() + ": " + e.getMessage());
			return;
		} catch (Exception e) {
			throw new RuntimeException("IO Error (brutal exit)" + e.toString());
		}
		
	}

	public static List<Token> LexFile(String file) throws LexicalError,
			Exception {
		List<Token> tokens = new LinkedList <Token> ();
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