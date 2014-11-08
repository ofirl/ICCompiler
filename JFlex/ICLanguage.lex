/* JFlex example: part of Java language lexer specification */
package JFlex;

import java_cup.runtime.*;
import iCCompiler.*;

/**
* This class is a simple example lexer.
*/

%%
%class Lexer
%unicode
%type Token
%cup
%line
%column
%public
	
%{
	StringBuffer string = new StringBuffer();
	private Token symbol(int type, String tag) {
		return new Token(type, tag, yyline, yycolumn);
	}
	private Token symbol(int type, String tag, String value) {
		return new Token(type, tag, yyline, yycolumn, value);
	}
%}
	
	LineTerminator = \r|\n|\r\n
	InputCharacter = [^\r\n]
	WhiteSpace = {LineTerminator} | [ \t\f]
	
	/* comments */
	Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
	TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
	// Comment can be the last line of the file, without line terminator.
	EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
	DocumentationComment = "/**" {CommentContent} "*"+ "/"
	CommentContent = ( [^*] | \*+ [^/*] )*
	Identifier = [:jletter:] [:jletterdigit:]*
	DecIntegerLiteral = 0 | [1-9][0-9]*
	
	/* Parenthesis */
	OpenParenthesis = \(
	CloseParenthesis = \)
	
	/* Punctuation */
	Colon = :
	SemiColon = ;
%state STRING
	
%%
	
	/* keywords */ /** unnecessary for our purposes 
	* <YYINITIAL> "abstract" { return symbol(sym.ABSTRACT); }
	* <YYINITIAL> "boolean" { return symbol(sym.BOOLEAN); }
	* <YYINITIAL> "break" { return symbol(sym.BREAK); } 
	*/
	
	<YYINITIAL> {
		/* identifiers */
		{Identifier} { return symbol(sym.ID, "ID", yytext()); }
		
		/* literals */
		{DecIntegerLiteral} { return symbol(sym.NUM, "INTEGER", yytext()); }
		/* \" { string.setLength(0); yybegin(STRING); } */
		
		/* operators */
		":=" { return symbol(sym.EQ, "=", yytext()); }
		"+" { return symbol(sym.PLUS, "+", yytext()); }
		"-" { return symbol(sym.MINUS, "-", yytext()); }
		"*" { return symbol(sym.MULTIPLY, "*", yytext()); }
		"\\" { return symbol(sym.DIVIDE, "\\", yytext()); }
		
		/* Punctuation */
		{Colon} { return symbol(sym.COLON, ":", yytext()); }
		{SemiColon} { return symbol(sym.SEMI, ";", yytext()); }
		
		/* Parenthesis */
		{OpenParenthesis} { return symbol(sym.OPENPARENTEHSIS, "(", yytext()); }
		{CloseParenthesis} { return symbol(sym.CLOSEPARENTHESIS, ")", yytext()); }
		
		/* comments */
		{Comment} { /* ignore */ }
		
		/* whitespace */
		{WhiteSpace} { /* ignore */ }
	}
	/** unnecessary for out purposes
	*<STRING> {
	*	\" { yybegin(YYINITIAL);
	*		return symbol(sym.STRING_LITERAL,
	*		string.toString()); }
	*	[^\n\r\"\\]+ { string.append( yytext() ); }
	*	\\t { string.append('\t'); }
	*	\\n { string.append('\n'); }
	*	\\r { string.append('\r'); }
	*	\\\" { string.append('\"'); }
	*	\\ { string.append('\\'); }
	*}
	*/
	
	/* error fallback */
	[^] { throw new Error("Illegal character <"+
		yytext()+">"); }