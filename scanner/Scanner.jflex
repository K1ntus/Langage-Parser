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

//Integer = [0-9]+
//String = \"[^\"]*\";
Integer = "integer"
String = " string"


Boolean = true|false


LineTerminator = \r|\n|\r\n
LineComment = "//" [^\r\n]* {LineTerminator}?



%state COMMENT, COMMENT_DOC, ANNOTATION
%%

<YYINITIAL> {
	{String}		{ System.out.println("*** String: " + yytext()); return new Symbol(Terminals.STR, yyline, yycolumn); }
	{Integer}		{ System.out.println("*** Integer: " + yytext()); return new Symbol(Terminals.INT, yyline, yycolumn); }
	{Boolean}		{ System.out.println("*** Boolean: " + yytext()); return new Symbol(Terminals.BOOL, yyline, yycolumn); }
	{Identifier}	{ System.out.println("*** Identifier: " + yytext()); return new Symbol(Terminals.ID, yyline, yycolumn); }
	"function"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.FUN, yyline, yycolumn); }
	"struct"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.STRUCT, yyline, yycolumn); }
	"array"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.ARRAY, yyline, yycolumn); }
	"var" 			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.VAR, yyline, yycolumn); }
	"type"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TYPE, yyline, yycolumn); }
	
	
	"if"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.IF, yyline, yycolumn); }
	"then"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.THEN, yyline, yycolumn); }
	"else"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.ELSE, yyline, yycolumn); }
	"elseif"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.ELSEIF, yyline, yycolumn); }
	"of"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.OF, yyline, yycolumn); }
	"new"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.NEW, yyline, yycolumn); }
	"default"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.DEFAULT, yyline, yycolumn); }
	"switch"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.SWITCH, yyline, yycolumn); }
	"case"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.CASE, yyline, yycolumn); }
	"do"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.DO, yyline, yycolumn); }
	"while"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.WHILE, yyline, yycolumn); }
	"return"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.RETURN, yyline, yycolumn); }
	"readln"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.READLN, yyline, yycolumn); }
	"println"		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.PRINTLN, yyline, yycolumn); }
	
	"!"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.NOT, yyline, yycolumn); }
	"||"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.OR, yyline, yycolumn); }
	"&&"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.AND, yyline, yycolumn); }
	
	
	"+"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.PLUS, yyline, yycolumn); }
	"-" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.MINUS, yyline, yycolumn); }
	"*"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TIMES, yyline, yycolumn); }
	"/"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.DIV, yyline, yycolumn); }
	"("  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.LPAR, yyline, yycolumn); }
	")"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.RPAR, yyline, yycolumn); }
	"=" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.EQ, yyline, yycolumn); }
	"," 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.COMMA, yyline, yycolumn); }
	";" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.SEMICOLON, yyline, yycolumn); }
	":" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.COLON, yyline, yycolumn); }
	".."			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.DBDOT, yyline, yycolumn); }
	"["				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.LBRACKET, yyline, yycolumn); }
	"]"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.RBRACKET, yyline, yycolumn); }
	"{"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.LCURLBR, yyline, yycolumn); }
	"}"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.RCURLBR, yyline, yycolumn); }
	"^"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.CIRCUMFLEX, yyline, yycolumn); }
	
	
	"/**"			{System.out.println("*** Documentation Comment:"); yybegin(COMMENT_DOC);}
	"/*"			{System.out.println("*** Multiple Lines Comment:"); yybegin(COMMENT);}
	{LineComment}	{System.out.println("*** LineComment: " + yytext()); }
	
	"<"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.LESS, yyline, yycolumn); }
	"<=				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.LESSEQ, yyline, yycolumn); }
	">"				{ System.out.println("*** " + yytext()); return new Symbol(Terminals.GREATER, yyline, yycolumn); }
	">="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.GREATEREQ, yyline, yycolumn); }
	"!="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.DIFF, yyline, yycolumn); }
	"=="			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TESTEQ, yyline, yycolumn); }
	"true"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.TRUE, yyline, yycolumn); }
	"false"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.FALSE, yyline, yycolumn); }
	"null"			{ System.out.println("*** " + yytext()); return new Symbol(Terminals.NULL, yyline, yycolumn); }
	
	
	
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
