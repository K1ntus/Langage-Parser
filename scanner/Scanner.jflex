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
	{String}		{ System.out.println("*** String: " + yytext()); }
	{Integer}		{ System.out.println("*** Integer: " + yytext()); }
	{Boolean}		{ System.out.println("*** Boolean: " + yytext()); }
	"void"			{ System.out.println("*** Void: " + yytext()); }
	"pointer"		{ System.out.println("*** Pointer: " + yytext()); }
	"feature"		{ System.out.println("*** Feature: " + yytext()); }
	"struct"		{ System.out.println("*** Struct: " + yytext()); }
	"array"		{ System.out.println("*** Struct: " + yytext()); }
	"enum"		{ System.out.println("*** Struct: " + yytext()); }
	
	
	"+"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.PLUS, yyline, yycolumn); }
	"-" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.MINUS, yyline, yycolumn); }
	"*"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.TIMES, yyline, yycolumn); }
	"/"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.DIV, yyline, yycolumn); }
	"("  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.LPAR, yyline, yycolumn); }
	")"  	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.RPAR, yyline, yycolumn); }
	"=" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.EQ, yyline, yycolumn); }
	{UFunction}		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.UFCT, yyline, yycolumn, yytext()); }
	{BFunction}		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.BFCT, yyline, yycolumn, yytext()); }
	"," 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.COMMA, yyline, yycolumn); }
	";" 	        { System.out.println("*** " + yytext()); return new Symbol(Terminals.SEMI, yyline, yycolumn); }
	{Integer}		{ System.out.println("*** " + yytext()); return new Symbol(Terminals.INTEGER, yyline, yycolumn, new Integer(yytext())); }
	{Identifier}	{ System.out.println("*** " + yytext()); return new Symbol(Terminals.ID, yyline, yycolumn, yytext()); }
	
	"/**"			{System.out.println("*** Documentation Comment:"); yybegin(COMMENT_DOC);}
	"/*"			{System.out.println("*** Multiple Lines Comment:"); yybegin(COMMENT);}
	{LineComment}	{System.out.println("*** LineComment: " + yytext()); }
	
	
	
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
