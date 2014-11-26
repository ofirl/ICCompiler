/* JFlex example: part of Java language lexer specification */
package IC.Parser;

import java_cup.runtime.*;

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
	private Token symbol(int tag, String tagString, String value) {
		return new Token(tag, tagString, yyline, yycolumn, value);
	}

	private void lexError(String message) throws LexicalError {
		throw new LexicalError(message, yyline+1, yycolumn+1);
	}
	
	public int getLineNumber() {
		return yyline+1;
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
	UnterminatedComment = "/*" [^"*/"]*
	
	AlphaNumeric = [a-zA-Z0-9]
	ClassIdentifier = [A-Z] ({AlphaNumeric} | "_")*
	Identifier = [a-z] ({AlphaNumeric} | "_")*
	NotIdentifier = "_" ({AlphaNumeric} | "_")
	DecIntegerLiteral = 0 | [1-9][0-9]*
	NotInteger = 0 [0-9]+
	
	/* Punctuation */
	SemiColon = ;
	Comma = \,
	
	StringASCIICharacters = [ !#-\[\]-~]
	StringEscapeSequences = "\\\\" | "\\\"" | "\\n" | "\\t"
	String = \" ( {StringASCIICharacters} | {StringEscapeSequences} )* \"
	NotString = \" ([^\"] | {StringEscapeSequences} )*
	
%%
	
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
		
		/* operators */
		"=" { return symbol(sym.EQ, "=", yytext()); }
		"==" { return symbol(sym.EQCOMP, "==", yytext()); }
		"!=" { return symbol(sym.NOTEQCOMP, "!=", yytext()); }
		"+" { return symbol(sym.PLUS, "+", yytext()); }
		"-" { return symbol(sym.MINUS, "-", yytext()); }
		"*" { return symbol(sym.MULTIPLY, "*", yytext()); }
		"/" { return symbol(sym.DIVIDE, "/", yytext()); }
		"%" { return symbol(sym.REMAINDER, "%", yytext()); }
		\! { return symbol(sym.NEGATION, "!", yytext()); }
		">" { return symbol(sym.BIG, ">", yytext()); }
		">=" { return symbol(sym.BIGEQ, ">=", yytext()); }
		"<" { return symbol(sym.SMALL, "<", yytext()); }
		"<=" { return symbol(sym.SMALLEQ, "<=", yytext()); }
		"&&" { return symbol(sym.AND, "&&", yytext()); }
		"||" { return symbol(sym.OR, "||", yytext()); }
		"." { return symbol(sym.DOT, ".", yytext()); }
		
		/* Punctuation */
		{SemiColon} { return symbol(sym.SEMI, ";", yytext()); }
		{Comma} { return symbol(sym.COMMA, ",", yytext()); }
		
		/* Parenthesis */
		\( { return symbol(sym.LP, "(", yytext()); }
		\) { return symbol(sym.RP, ")", yytext()); }
		"[" { return symbol(sym.LB, "[", yytext()); }
		"]" { return symbol(sym.RB, "]", yytext()); }
		"{" { return symbol(sym.LCBR, "{", yytext()); }
		"}" { return symbol(sym.RCBR, "}", yytext()); }
		
		/* comments */
		{Comment} { /* ignore */ }
		
		/* whitespace */
		{WhiteSpace} { /* ignore */ }
	}
	
	/* error fallback */
	{NotIdentifier} { lexError("Lexical error: " + yytext()); }
	{NotString} { lexError("Lexical error: " + yytext()); }
	{UnterminatedComment} { lexError("Lexical error: " + yytext()); }
	{ NotInteger } { lexError("Lexical error: " + yytext()); }
	[^] { lexError("Lexical error: " + yytext()); }  // invalid character
	
	
