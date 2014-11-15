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
%scanerror LexicalError

%eofval{
  	return symbol(sym.EOF, "EOF", "EOF");
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
	UnclosedComment = "/*" [^"*/"]*
	
	AlphaNumeric = [a-zA-Z0-9]
	ClassIdentifier = [A-Z] ({AlphaNumeric} | "_")*
	Identifier = [a-z] ({AlphaNumeric} | "_")*
	DecIntegerLiteral = 0 | [1-9][0-9]*
	
	/* Punctuation */
	Colon = :
	SemiColon = ;
	Comma = \,
	
	StringASCIICharacters = [ !#-\[\]-~]
	StringEscapeSequences = "\\\\" | "\\\"" | "\\n" | "\\t"
	String = \" ( {StringASCIICharacters} | {StringEscapeSequences} )* \"
	
//  %state STRING
	
%%
	
	/* keywords */ /**
	*<YYINITIAL> "abstract" { return symbol(sym.ABSTRACT); }
	*<YYINITIAL> "boolean" { return symbol(sym.BOOLEAN); }
	*<YYINITIAL> "break" { return symbol(sym.BREAK); } 
	*/
	
	<YYINITIAL> {
		/* keywords */
		"class" { return symbol(sym.CLASS, "class", yytext()); }
		"extends" { return symbol(sym.EXTENDS, "extends", yytext()); }
		"static" { return symbol(sym.STATIC, "static", yytext()); }
		"void" { return symbol(sym.VOID, "void", yytext()); }
		"int" { return symbol(sym.INT, "int", yytext()); }
		"boolean" { return symbol(sym.BOOLEAN, "boolean", yytext()); }
		"string" { return symbol(sym.STRING, "string", yytext()); }
		"return" { return symbol(sym.RETURN, "return", yytext()); }
		"if" { return symbol(sym.IF, "if", yytext()); }
		"else" { return symbol(sym.ELSE, "else", yytext()); }
		"while" { return symbol(sym.WHILE, "while", yytext()); }
		"break" { return symbol(sym.BREAK, "break", yytext()); }
		"continue" { return symbol(sym.CONTINUE, "continue", yytext()); }
		"this" { return symbol(sym.THIS, "this", yytext()); }
		"new" { return symbol(sym.NEW, "new", yytext()); }
		"length" { return symbol(sym.LENGTH, "length", yytext()); }
		"true" { return symbol(sym.TRUE, "true", yytext()); }
		"false" { return symbol(sym.FALSE, "false", yytext()); }
		"null" { return symbol(sym.NULL, "null", yytext()); }
	
		/* Strings */
		{String} { return symbol(sym.STR, "STRING", yytext()); }
		
		/* identifiers */
		{ClassIdentifier} { return symbol(sym.CLASS_ID, "CLASS_ID", yytext()); }
		{Identifier} { return symbol(sym.ID, "ID", yytext()); }
		
		/* literals */
		{DecIntegerLiteral} { return symbol(sym.NUM, "INTEGER", yytext()); }
//		\" { string.setLength(0); yybegin(STRING); }
		
		/* operators */
		"=" { return symbol(sym.EQ, "=", yytext()); }
		"==" { return symbol(sym.EQCOMP, "==", yytext()); }
		"!=" { return symbol(sym.NOTEQCOMP, "!=", yytext()); }
		"+" { return symbol(sym.PLUS, "+", yytext()); }
		"-" { return symbol(sym.MINUS, "-", yytext()); }
		"*" { return symbol(sym.MULTIPLY, "*", yytext()); }
		"/" { return symbol(sym.DIVIDE, "/", yytext()); }
		"%" { return symbol(sym.REMINDER, "%", yytext()); }
		\! { return symbol(sym.NEGATION, "!", yytext()); }
		">" { return symbol(sym.BIG, ">", yytext()); }
		">=" { return symbol(sym.BIGEQ, ">=", yytext()); }
		"<" { return symbol(sym.SMALL, "<", yytext()); }
		"<=" { return symbol(sym.SMALLEQ, "<=", yytext()); }
		"&&" { return symbol(sym.AND, "&&", yytext()); }
		"||" { return symbol(sym.OR, "||", yytext()); }
		"." { return symbol(sym.DOT, ".", yytext()); }
		
		/* Punctuation */
		{Colon} { return symbol(sym.COLON, ":", yytext()); }
		{SemiColon} { return symbol(sym.SEMI, ";", yytext()); }
		{Comma} { return symbol(sym.COMMA, ",", yytext()); }
		
		/* Parenthesis */
		\( { return symbol(sym.OPENROUNDPARENTEHSIS, "(", yytext()); }
		\) { return symbol(sym.CLOSEROUNDPARENTHESIS, ")", yytext()); }
		"[" { return symbol(sym.OPENSQUAREPARENTEHSIS, "[", yytext()); }
		"]" { return symbol(sym.CLOSESQUAREPARENTHESIS, "]", yytext()); }
		"{" { return symbol(sym.OPENCURLYPARENTEHSIS, "{", yytext()); }
		"}" { return symbol(sym.CLOSECURLYPARENTHESIS, "}", yytext()); }
		
		/* comments */
		{Comment} { /* ignore */ }
		
		/* whitespace */
		{WhiteSpace} { /* ignore */ }
	}
	
//	<STRING> {
//		\" { yybegin(YYINITIAL);
//			return symbol(sym.STRING, "STRING", 
//			string.toString()); }
//		[^\n\r\"\\]+ { string.append( yytext() ); }
//		\\t { string.append('\t'); }
//		\\n { string.append('\n'); }
//		\\r { string.append('\r'); }
//		\\\" { string.append('\"'); }
//		\\ { string.append('\\'); }
//	}
	
	/* error fallback */
	{ UnclosedComment } { throw new LexicalError("Unclosed Comment"); }
	
	[^] { throw new LexicalError("Illegal character <"+
		yytext()+">"); }
