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

%eofval{
  	return new Token(sym.EOF, "EOF", 0 , 0, "EOF");
%eofval}
	
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
	ClassIdentifier = [:uppercase:] [:jletterdigit:]*
	Identifier =  [:jletter:] ([:jletterdigit:] | "_")*
	DecIntegerLiteral = 0 | [1-9][0-9]*
	
	/* Punctuation */
	Colon = :
	SemiColon = ;
	Comma = \,
%state STRING
	
%%
	
	/* keywords */ /**
	*<YYINITIAL> "abstract" { return symbol(sym.ABSTRACT); }
	*<YYINITIAL> "boolean" { return symbol(sym.BOOLEAN); }
	*<YYINITIAL> "break" { return symbol(sym.BREAK); } 
	*/
	
	<YYINITIAL> {
		/* keywords */
		"extends" { return symbol(sym.EXTENDS, "EXTENDS", yytext()); }
		"static" { return symbol(sym.STATIC, "STATIC", yytext()); }
		"void" { return symbol(sym.VOID, "VOID", yytext()); }
		"int" { return symbol(sym.INT, "INT", yytext()); }
		"boolean" { return symbol(sym.BOOLEAN, "BOOLEAN", yytext()); }
		"return" { return symbol(sym.RETURN, "RETURN", yytext()); }
		"if" { return symbol(sym.IF, "IF", yytext()); }
		"else" { return symbol(sym.ELSE, "ELSE", yytext()); }
		"while" { return symbol(sym.WHILE, "WHILE", yytext()); }
		"break" { return symbol(sym.BREAK, "BREAK", yytext()); }
		"continue" { return symbol(sym.CONTINUE, "CONTINUE", yytext()); }
		"this" { return symbol(sym.THIS, "THIS", yytext()); }
		"new" { return symbol(sym.NEW, "NEW", yytext()); }
		"length" { return symbol(sym.LENGTH, "LENGTH", yytext()); }
		"true" { return symbol(sym.TRUE, "TRUE", yytext()); }
		"false" { return symbol(sym.FALSE, "FALSE", yytext()); }
		"null" { return symbol(sym.NULL, "NULL", yytext()); }
	
		/* identifiers */
		{ClassIdentifier} { return symbol(sym.CLASSID, "CLASSID", yytext()); }
		{Identifier} { return symbol(sym.ID, "ID", yytext()); }
		
		/* literals */
		{DecIntegerLiteral} { return symbol(sym.NUM, "INTEGER", yytext()); }
		\" { string.setLength(0); yybegin(STRING); }
		
		/* operators */
		"=" { return symbol(sym.EQ, "=", yytext()); }
		"==" { return symbol(sym.EQCOMP, "==", yytext()); }
		"+" { return symbol(sym.PLUS, "+", yytext()); }
		"-" { return symbol(sym.MINUS, "-", yytext()); }
		"*" { return symbol(sym.MULTIPLY, "*", yytext()); }
		"\\" { return symbol(sym.DIVIDE, "\\", yytext()); }
		"%" { return symbol(sym.REMINDER, "%", yytext()); }
		\! { return symbol(sym.NEGATION, "!", yytext()); }
		">" { return symbol(sym.BIG, ">", yytext()); }
		">=" { return symbol(sym.BIGEQ, ">=", yytext()); }
		"<" { return symbol(sym.SMALL, "<", yytext()); }
		"<=" { return symbol(sym.SMALLEQ, "<=", yytext()); }
		"&&" { return symbol(sym.AND, "&&", yytext()); }
		"||" { return symbol(sym.OR, "||", yytext()); }
		
		/* Punctuation */
		{Colon} { return symbol(sym.COLON, ":", yytext()); }
		{SemiColon} { return symbol(sym.SEMI, ";", yytext()); }
		{Comma} { return symbol(sym.COMMA, ",", yytext()); }
		
		/* Parenthesis */
		\( { return symbol(sym.OPENROUNDPARENTEHSIS, "(", yytext()); }
		\) { return symbol(sym.CLOSEROUNDPARENTHESIS, ")", yytext()); }
		"[" { return symbol(sym.OPENSQUAREPARENTEHSIS, "[", yytext()); }
		"]" { return symbol(sym.CLOSESQUAREPARENTHESIS, "]", yytext()); }
		
		/* comments */
		{Comment} { /* ignore */ }
		
		/* whitespace */
		{WhiteSpace} { /* ignore */ }
	}
	
	<STRING> {
		\" { yybegin(YYINITIAL);
			return symbol(sym.STRING, "STRING", 
			string.toString()); }
		[^\n\r\"\\]+ { string.append( yytext() ); }
		\\t { string.append('\t'); }
		\\n { string.append('\n'); }
		\\r { string.append('\r'); }
		\\\" { string.append('\"'); }
		\\ { string.append('\\'); }
	}
	
	/* error fallback */
	[^] { throw new Error("Illegal character <"+
		yytext()+">"); }
