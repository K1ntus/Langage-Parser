package ubordeaux.deptinfo.compilation.project.main;

import beaver.Symbol;
import beaver.Scanner;

%%

%class ScannerExpr
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	System.out.println(yytext()); return new Symbol(Terminals.EOF);
%eofval}
%unicode
%line
%column

%{
private String annotation_buffer = "";
private String annotation_type = "";
%}


Identifier = [:jletter:] [:jletterdigit:]*

Integer = [0-9]+
String = \"[^\"]*\";


Boolean = true|false


LineTerminator = \r|\n|\r\n
LineComment = "//" [^\r\n]* {LineTerminator}?



%state COMMENT, COMMENT_DOC, ANNOTATION
%%

<YYINITIAL> {

	"/**"			{System.out.println("*** Documentation Comment:"); yybegin(COMMENT_DOC);}
	"/*"			{System.out.println("*** Multiple Lines Comment:"); yybegin(COMMENT);}
	{LineComment}	{System.out.println("*** LineComment: " + yytext()); }
	
	"struct"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_STRUCT, yyline, yycolumn); }
	"array"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_ARRAY, yyline, yycolumn); }
	"type"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_TYPE, yyline, yycolumn); }
	"of"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_OF, yyline, yycolumn); }
	"integer"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_INTEGER, yyline, yycolumn); }
	"string"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_STRING, yyline, yycolumn); }
	"boolean"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_BOOLEAN, yyline, yycolumn); }
	
	
	"new"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_NEW, yyline, yycolumn); }
	"end"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_END, yyline, yycolumn); }
	"begin"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_BEGIN, yyline, yycolumn); }
	"dispose"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_DISPOSE, yyline, yycolumn); }
	"function"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_FUNCTION, yyline, yycolumn); }
	"var" 			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_VAR, yyline, yycolumn); }
	
	"if"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_IF, yyline, yycolumn); }
	"then"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_THEN, yyline, yycolumn); }
	"else"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_ELSE, yyline, yycolumn); }
	"do"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_DO, yyline, yycolumn); }
	"while"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_WHILE, yyline, yycolumn); }
	"return"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_RETURN, yyline, yycolumn); }
	"readln"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_READLN, yyline, yycolumn); }
	"println"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_PRINTLN, yyline, yycolumn); }
	
	
	"default"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_DEFAULT, yyline, yycolumn); }
	"switch"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_SWITCH, yyline, yycolumn); }
	"case"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_CASE, yyline, yycolumn); }
	
	
	"+"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_PLUS, yyline, yycolumn); }
	"-" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_MINUS, yyline, yycolumn); }
	"*"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_TIMES, yyline, yycolumn); }
	"/"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_DIV, yyline, yycolumn); }
	
	"("  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_LPAR, yyline, yycolumn); }
	")"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_RPAR, yyline, yycolumn); }
	"["				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_LBRACKET, yyline, yycolumn); }
	"]"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_RBRACKET, yyline, yycolumn); }
	"{"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_LBRACE, yyline, yycolumn); }
	"}"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_RBRACE, yyline, yycolumn); }
	
	"," 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_COMMA, yyline, yycolumn); }
	";" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_SEMIC, yyline, yycolumn); }
	":" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_COLON, yyline, yycolumn); }
	".."			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_DOTDOT, yyline, yycolumn); }
	
	"<"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_LT, yyline, yycolumn); }
	"<="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_LE, yyline, yycolumn); }
	">"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_GT, yyline, yycolumn); }
	">="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_GE, yyline, yycolumn); }
	"!="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_NE, yyline, yycolumn); }
	"=="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_EQ, yyline, yycolumn); }
	"true"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_TRUE, yyline, yycolumn); }
	"false"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_FALSE, yyline, yycolumn); }
	"null"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_NULL, yyline, yycolumn); }
	
	"!"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_NOT, yyline, yycolumn); }
	"||"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_OR, yyline, yycolumn); }
	"&&"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_AND, yyline, yycolumn); }
	
	"=" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_AFF, yyline, yycolumn); }
	
	
	{String}		{ System.out.println("*** String: " + yytext()); return new Symbol(Terminals.TOKEN_LIT_STRING, yyline, yycolumn); }
	{Integer}		{ System.out.println("*** Integer: " + yytext()); return new Symbol(Terminals.TOKEN_LIT_INTEGER, yyline, yycolumn); }
	{Identifier}	{ System.out.println("*** Identifier: " + yytext()); return new Symbol(Terminals.TOKEN_IDENTIFIER, yyline, yycolumn); }
	
	
	"^"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TOKEN_CIRC, yyline, yycolumn); }
	
	[^]|\n	{}	//EOF
}





<COMMENT>{
	"*/" {System.out.println("End of the Multiple Lines Comment !"); yybegin(YYINITIAL);}
	[^]|\n {System.out.print(yytext());}
}

<COMMENT_DOC>{
	"@"	{yybegin(ANNOTATION);}
	
	"*/" {System.out.println("End of the Documentation"); yybegin(YYINITIAL);}
	
	[^]|\n {System.out.print(yytext());}
}

<ANNOTATION>{
	"param"		{annotation_type = "param";}
	"author"	{annotation_type = "author";}
	"return"	{annotation_type = "return";}
	"version"	{annotation_type = "version";}
	
	[^]|"\n"	{System.out.print("-> " + annotation_type + ": " + annotation_buffer); annotation_buffer = ""; yybegin(COMMENT_DOC);}
}
