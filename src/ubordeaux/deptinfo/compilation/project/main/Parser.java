package ubordeaux.deptinfo.compilation.project.main;

import java.util.List;
import java.util.Iterator;
import ubordeaux.deptinfo.compilation.project.type.*;
import fr.groupname.compilator.environment.*;
import beaver.*;
import java.util.ArrayList;
import ubordeaux.deptinfo.compilation.project.node.*;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "parser.grammar".
 */
public class Parser extends beaver.Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjLtbyLSKL$kvz5nUi#WAeII3YWX1GgWMBROnXbPq0aH18MK9Gi0bG5MdSS5UqB0B11Tm" +
		"G14L4HK5Kt8WB2Av0Mx5OeIrLQMjhwxuTlpVllBovzos#v2Vz#OV9xvjpvfmpvpipzxwPkO" +
		"2t22Ku78FG5MFH30$YG3J5GVW93iOXE1HXPA4vMk0mT4Ddd88##3dweX$wOm3oS17sGowEn" +
		"N6o2nT6DRH4QnoD6cp1U4p6O9o1uHY9KVXraWpxDvhx0Sp0EDoEfN39lHeFat4#pi4QF8eQ" +
		"cPK1ToLcOG6knZMubXdEnK2SYW9MCXKhcIkKaC6kz806hLAsPkv5dXw1LMhoFVAqYlA8o2u" +
		"o#Nbgql9CQ13FaJgVNCFYvybDotDsWtYEKfv2ydGFy5IavPdK89vZbASdUSuBy9oVbkUt3U" +
		"0fH34sypqz0jF84tbFby1JjXeyb9PdLKgUFBI9FGsJoQu#3pbeX$Ou7Xrn8dxcymqbk#tBm" +
		"o$Hrle5#FCKfiop42C2USRY4HGXtrTLBC#lKkR9mvWqlfjJ#sH7IjzlS9tFDnrdCLS7$PKy" +
		"WUUmpXTVJQyTVtgWYkKfcMwIDts#nAUVQ3b1LuXLoFgCHlne#U5OBiFlC1ENu59SZYjm9Qx" +
		"YUNIzEOz#gizrDi#ZQDGyNzGD9keaZPhBg4wgrvz7EgxM6dSZHouq8#DHiVot#lBVOg9Erf" +
		"oB6DKbHVuDrhZRE799Ylml#VBVOQ9#eJcVOTHfAVA$RethhR#wrwoe4WmnuqempCWopLEkS" +
		"hJACrLMgPoYSWNkmRs#VUyYrbTdwgl3VTY6Lr6A9$0aBiQBR1VZJioHLt41NcRThz1x5#x6" +
		"CdaFQ#LT#RjivJwt6FVZAJo6nx6UCK$ZMJoF5x2HTM$2Llw$XZS0#PoxPG6hAEJSYrX9Dvv" +
		"FFT0JlRXdzEPx4djB7BYyINWyvVVZNITochkig4ptyZ3tGtjNp#OxbiiTfPKvOrlp$3iwIO" +
		"RZ6yrTGLkPiOqdzoYkRpRvgtcFggGsEIFkOxZERRZIRPaXNib9tFEoMKymG#DNAJQoYZoJ0" +
		"giKtWSyODPmW2Tx7$0qDIn#dgRxW2UVFA7$mxhbC6j5WCVvtdZoUS#9lASdy7GDc$VKuMuG" +
		"PSlc7QbnFFRJY6IogtV9s4plLeVphcRxiiXk#rpEtlu5#FFafypZ13XSKs$xG5NVNKzwtyb" +
		"fVE6KlZ3lBxOlYsUU$RGxydopuxlGQyTt232LfsIQ6AWYyUadMc9rHAh8oMZ4ZvOVZcKWls" +
		"UA#OqpX5yV9VpI6SOOnyJ4TwscIQFQ#w8wCIgcny#Zn76Tw$F7evBdB$VbRvTX$goCyvVwy" +
		"ZiPve$$wk9HCLjZPPJ5tlTAMSzmKzzmtaT6yEipYzzYOxaAaRO3sISGP$FRoJ5UXpk4noUI" +
		"HKJQVCQq8o8haMDojLCznsWET#yi4RR0zilPYCX750C0Tp3b0yIvH3FYlOY$CG2ScMmwK#w" +
		"CszpLR0wZt43x6ihDb3iejm5UAULEzidhxg5iGVa1utCfFwLS1Kw2Vxif3wIVUKACTVfHjg" +
		"ISJjc6UKPGTcI$5MKNohrMJVcqTMK#kqxEsRsNibfhh6HCNyhpay$BlOgnIwDwQ2ZrzzK#Z" +
		"$royezMttZQ3b5z4lKsga#Ztacv#xDPHWnHtwNqTQEoG$q7gtq6xSNiTzV#NFP7iVycEsNM" +
		"N6OJhCEPfltrn1THtOjmiJvtVERFq2qYrrA$BSJvUsTHpY5c4KlKlbRbdGIVfvjdZTb8R2K" +
		"#r5hu8BrHgbyIZ$FuBBoBhNuPCP8ertu5vxCYKEFygCHR6dEEogd4TGJNpiiZpbFx66AcwX" +
		"DPqnwBZtFok8RUXSG519#Rvrh#McA1wbK4tq7lMkrFZiNnz$GLnI3MEbBx6oDhd#cwfmB$Q" +
		"WBzbIhVYKgdkSe#AfUhtA9IrzyjKdbbL8QcgBn2vGoLgrMkKxaxiQRGkqdgx1#8#Jop#NcX" +
		"G7z$Ip$8qW#rzEO1xYR47FKTeROwbP#elMLKEXsqtpeY#Po#eArjObtE68qBCsQJDQ$YJEQ" +
		"LmRp3LivnAgV7RMu1#xFzOqBpBBskyTpEV7yVJTI#D$KOBolGFyMgPLMI#1QMVuDj9uwrV6" +
		"ydZiLsFfblP1Vg$#GbsIWloWlol3mdTR91dfLdv65PBG$9Wr9h8fwMkzak9POGTn6BYJk8s" +
		"ubRYKN4Gk8MucRY9e8xbzncnjye2pJJCfaloutsf6aVbtaoLswGEJ9R7cFKKxJLoZhZgvL7" +
		"ZLnhsZMcVKHhtgoIfwkiKlt##XcjbFjKuqaaxyYVjRTJFfDFvHFvM3wI$yb$vKFvZ$oRzht" +
		"oWVpBMf7tYJsg$qt#gjfkq$wJ#9EyPVH$o5$KzxPfxv4LiedoZyJlYUsohJxd6wPznRHRv6" +
		"LOV$Aw$87jrsQVY$Jvkv4lgKp5PDukUV8HBcyehjvIF7DF6Pm2GomC98Og1l70BrQKCEy4s" +
		"c8uWxc7CUz4oedcnkZngms4oxjH10vlJvwvwPMQhrGG3hzHNSBXLwnhC9hwEAAI#qObxyKy" +
		"7GY7DwqG4Rs95J5F6MFBsE#gw9O6FHZVa$6dKl848HnKCKyLPI$AqudUH1#YBz6TTXlzEAu" +
		"VvzkVSW3hgcQkQjehsAzWV07r0ke5vaim582RGay6fnw5IJ3bMtKOogG=");

	static final Action RETURN6 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 6];
		}
	};

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	static final Action RETURN5 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 5];
		}
	};

	static final Action RETURN7 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 7];
		}
	};
 
	static class Events extends beaver.Parser.Events {
		public void syntaxError(Symbol token) {
			System.err.format("*** Erreur de syntaxe en ligne %d, colonne %d. Token inattendu: %s\n",
				Symbol.getLine(token.getStart()),
				Symbol.getColumn(token.getStart()),
				Terminals.NAMES[token.getId()]);
		}
	}
	
	public void semanticError(String msg, Symbol token) {
			System.err.format("*** " + msg + " ligne %d, colonne %d\n",
				Symbol.getLine(token.getStart()),
				Symbol.getColumn(token.getStart()));
		}
		
	private Environment typeEnvironment = new Environment("types");
	private Environment procedureEnvironment = new Environment("procedures");
	private StackEnvironment stackEnvironment = new StackEnvironment("local variables stack");
	private String type_declaration_name;

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			RETURN6,	// [0] program = type_declaration_part variable_declaration_part procedure_definition_part TOKEN_BEGIN statement_list TOKEN_END; returns 'TOKEN_END' although none is marked
			Action.NONE,  	// [1] type_declaration_part = 
			RETURN2,	// [2] type_declaration_part = TOKEN_TYPE type_declaration_list; returns 'type_declaration_list' although none is marked
			new Action() {	// [3] type_declaration_list = type_declaration_list type_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [4] type_declaration_list = type_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN4,	// [5] type_declaration = type_declaration_head TOKEN_AFF type TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			Action.RETURN,	// [6] type_declaration_head = TOKEN_IDENTIFIER
			Action.RETURN,	// [7] type = simple_type
			Action.RETURN,	// [8] type = named_type
			Action.RETURN,	// [9] type = index_type
			Action.RETURN,	// [10] type = array_type
			Action.RETURN,	// [11] type = pointer_type
			Action.RETURN,	// [12] type = structure_type.t
			new Action() {	// [13] simple_type = TOKEN_STRING
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeString();
				}
			},
			new Action() {	// [14] simple_type = TOKEN_INTEGER
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeInt();
				}
			},
			new Action() {	// [15] simple_type = TOKEN_BOOLEAN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeBoolean();
				}
			},
			new Action() {	// [16] named_type = TOKEN_IDENTIFIER.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_r = _symbols[offset + 1];
					final String r = (String) _symbol_r.value;
					 return new TypeNamed(r);
				}
			},
			Action.RETURN,	// [17] index_type = enumerated_type.enum
			Action.RETURN,	// [18] index_type = subrange_type.subr
			RETURN2,	// [19] enumerated_type = TOKEN_LPAR identifier_list.list TOKEN_RPAR
			new Action() {	// [20] subrange_type = TOKEN_LIT_INTEGER.t1 TOKEN_DOTDOT TOKEN_LIT_INTEGER.t2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_t1 = _symbols[offset + 1];
					final Integer t1 = (Integer) _symbol_t1.value;
					final Symbol _symbol_t2 = _symbols[offset + 3];
					final Integer t2 = (Integer) _symbol_t2.value;
					 return new TypeEnumRange(new TypeItemEnum(t1, t1.toString()), new TypeItemEnum(t2, t2.toString()));
				}
			},
			RETURN3,	// [21] subrange_type = TOKEN_IDENTIFIER.t1 TOKEN_DOTDOT TOKEN_IDENTIFIER.t2; returns 't2' although more are marked
			RETURN6,	// [22] array_type = TOKEN_ARRAY TOKEN_LBRACKET range_type.range TOKEN_RBRACKET TOKEN_OF type.t; returns 't' although more are marked
			Action.RETURN,	// [23] range_type = enumerated_type
			Action.RETURN,	// [24] range_type = subrange_type
			Action.RETURN,	// [25] range_type = named_type
			new Action() {	// [26] pointer_type = TOKEN_CIRC type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_t = _symbols[offset + 2];
					final Type t = (Type) _symbol_t.value;
					 return new TypePointer(t);
				}
			},
			RETURN4,	// [27] structure_type = TOKEN_STRUCT TOKEN_LBRACE feature_list_type TOKEN_RBRACE; returns 'TOKEN_RBRACE' although none is marked
			new Action() {	// [28] feature_list_type = feature_list_type feature_type
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [29] feature_list_type = feature_type
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN4,	// [30] feature_type = TOKEN_IDENTIFIER TOKEN_COLON type TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			Action.NONE,  	// [31] variable_declaration_part = 
			RETURN2,	// [32] variable_declaration_part = TOKEN_VAR variable_declaration_list; returns 'variable_declaration_list' although none is marked
			new Action() {	// [33] variable_declaration_list = variable_declaration_list.list variable_declaration.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					final Symbol var = _symbols[offset + 2];
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [34] variable_declaration_list = variable_declaration.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol var = _symbols[offset + 1];
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN3,	// [35] variable_declaration = identifier_list.list TOKEN_COLON type.t TOKEN_SEMIC; returns 't' although more are marked
			new Action() {	// [36] identifier_list = identifier_list.list TOKEN_COMMA TOKEN_IDENTIFIER.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final IdentifierList list = (IdentifierList) _symbol_list.value;
					final Symbol _symbol_id = _symbols[offset + 3];
					final String id = (String) _symbol_id.value;
					 list.add(id); return list;
				}
			},
			new Action() {	// [37] identifier_list = TOKEN_IDENTIFIER.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					 IdentifierList list = new IdentifierList(); list.add(id); return list;
				}
			},
			Action.NONE,  	// [38] procedure_definition_part = 
			Action.RETURN,	// [39] procedure_definition_part = procedure_definition_list
			new Action() {	// [40] procedure_definition_list = procedure_definition_list procedure_definition
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [41] procedure_definition_list = procedure_definition
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN2,	// [42] procedure_definition = procedure_definition_head block; returns 'block' although none is marked
			RETURN2,	// [43] procedure_definition = procedure_declaration_head TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			Action.RETURN,	// [44] procedure_definition_head = procedure_head
			Action.RETURN,	// [45] procedure_declaration_head = procedure_head
			RETURN5,	// [46] procedure_head = TOKEN_PROCEDURE TOKEN_IDENTIFIER TOKEN_LPAR argt_part TOKEN_RPAR; returns 'TOKEN_RPAR' although none is marked
			RETURN7,	// [47] procedure_head = TOKEN_FUNCTION TOKEN_IDENTIFIER TOKEN_LPAR argt_part TOKEN_RPAR TOKEN_COLON type; returns 'type' although none is marked
			Action.NONE,  	// [48] argt_part = 
			Action.RETURN,	// [49] argt_part = argt_list.a
			new Action() {	// [50] argt_list = argt_list TOKEN_COMMA argt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [51] argt_list = argt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN3,	// [52] argt = TOKEN_IDENTIFIER TOKEN_COLON type; returns 'type' although none is marked
			RETURN4,	// [53] block = variable_declaration_part TOKEN_BEGIN statement_list TOKEN_END; returns 'TOKEN_END' although none is marked
			new Action() {	// [54] statement_list = statement_list statement
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			new Action() {	// [55] statement_list = statement
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [56] statement = simple_statement
			Action.RETURN,	// [57] statement = structured_statement
			Action.RETURN,	// [58] simple_statement = assignment_statement
			Action.RETURN,	// [59] simple_statement = procedure_statement
			Action.RETURN,	// [60] simple_statement = new_statement
			Action.RETURN,	// [61] simple_statement = dispose_statement
			Action.RETURN,	// [62] simple_statement = println_statement
			Action.RETURN,	// [63] simple_statement = readln_statement
			Action.RETURN,	// [64] simple_statement = return_statement
			new Action() {	// [65] assignment_statement = variable_access.e1 TOKEN_AFF expression.e2 TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					  return new NodeAssign(e1, e2);
				}
			},
			RETURN2,	// [66] procedure_statement = procedure_expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			new Action() {	// [67] procedure_expression = TOKEN_IDENTIFIER.func_name TOKEN_LPAR expression_part.args TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_func_name = _symbols[offset + 1];
					final String func_name = (String) _symbol_func_name.value;
					final Symbol _symbol_args = _symbols[offset + 3];
					final NodeList args = (NodeList) _symbol_args.value;
					 return new NodeCallFct(func_name, new TypeFunct(null, null, null), args);
				}
			},
			Action.NONE,  	// [68] expression_part = 
			Action.RETURN,	// [69] expression_part = expression_list
			new Action() {	// [70] expression_list = expression_list.list TOKEN_COMMA expression.expr
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeList list = (NodeList) _symbol_list.value;
					final Symbol _symbol_expr = _symbols[offset + 3];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					 list.add(expr); return list;
				}
			},
			new Action() {	// [71] expression_list = expression.expr
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expr = _symbols[offset + 1];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					 NodeList list = new NodeList(); list.add(expr); return list;
				}
			},
			new Action() {	// [72] new_statement = TOKEN_NEW variable_access.node TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 2];
					final NodeExp node = (NodeExp) _symbol_node.value;
					 return new NodeNew(node);
				}
			},
			new Action() {	// [73] dispose_statement = TOKEN_DISPOSE variable_access.node TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 2];
					final NodeExp node = (NodeExp) _symbol_node.value;
					 return new NodeDispose(node);
				}
			},
			RETURN3,	// [74] println_statement = TOKEN_PRINTLN expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			RETURN3,	// [75] readln_statement = TOKEN_READLN expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			new Action() {	// [76] return_statement = TOKEN_RETURN expression.node TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 2];
					final NodeExp node = (NodeExp) _symbol_node.value;
					 return new NodeReturn(node);
				}
			},
			Action.RETURN,	// [77] structured_statement = block
			Action.RETURN,	// [78] structured_statement = if_statement
			Action.RETURN,	// [79] structured_statement = while_statement
			Action.RETURN,	// [80] structured_statement = switch_statement
			new Action() {	// [81] if_statement = TOKEN_IF expression.e TOKEN_THEN statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
						return new NodeIf(e, stm);
				}
			},
			new Action() {	// [82] if_statement = TOKEN_IF expression.e TOKEN_THEN statement.stm_then TOKEN_ELSE statement.stm_else
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					final Symbol _symbol_stm_then = _symbols[offset + 4];
					final Node stm_then = (Node) _symbol_stm_then.value;
					final Symbol _symbol_stm_else = _symbols[offset + 6];
					final Node stm_else = (Node) _symbol_stm_else.value;
						return new NodeIf(e, stm_then, stm_else);
				}
			},
			new Action() {	// [83] while_statement = TOKEN_WHILE expression.e1 TOKEN_DO statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 2];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
						return new NodeWhile(e1, stm);
				}
			},
			new Action() {	// [84] switch_statement = TOKEN_SWITCH expression.root TOKEN_BEGIN case_statement_list.case_list TOKEN_END
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_root = _symbols[offset + 2];
					final NodeExp root = (NodeExp) _symbol_root.value;
					final Symbol _symbol_case_list = _symbols[offset + 4];
					final NodeCaseList case_list = (NodeCaseList) _symbol_case_list.value;
					 return new NodeSwitch(root, new NodeList(case_list));
				}
			},
			new Action() {	// [85] case_statement_list = case_statement_list.list case_statement.item
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeCaseList list = (NodeCaseList) _symbol_list.value;
					final Symbol _symbol_item = _symbols[offset + 2];
					final NodeCase item = (NodeCase) _symbol_item.value;
					 list.add(item); return list;
				}
			},
			new Action() {	// [86] case_statement_list = case_statement.item
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_item = _symbols[offset + 1];
					final NodeCase item = (NodeCase) _symbol_item.value;
					 NodeCaseList list = new NodeCaseList(); list.add(item); return list;
				}
			},
			new Action() {	// [87] case_statement = TOKEN_CASE TOKEN_IDENTIFIER.name TOKEN_COLON statement.state
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_name = _symbols[offset + 2];
					final String name = (String) _symbol_name.value;
					final Symbol _symbol_state = _symbols[offset + 4];
					final Node state = (Node) _symbol_state.value;
					 return new NodeCase(name, state);
				}
			},
			new Action() {	// [88] case_statement = TOKEN_DEFAULT TOKEN_COLON statement.state
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_state = _symbols[offset + 3];
					final Node state = (Node) _symbol_state.value;
					 return new NodeCase("default", state);
				}
			},
			Action.RETURN,	// [89] variable_access = TOKEN_IDENTIFIER.name
			RETURN3,	// [90] variable_access = variable_access.var TOKEN_LBRACKET expression.e TOKEN_RBRACKET; returns 'e' although more are marked
			Action.RETURN,	// [91] variable_access = expression.e TOKEN_CIRC
			new Action() {	// [92] expression = expression.e1 TOKEN_PLUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("plus", e1, e2);
				}
			},
			new Action() {	// [93] expression = expression.e1 TOKEN_MINUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("minus", e1, e2);
				}
			},
			new Action() {	// [94] expression = expression.e1 TOKEN_TIMES expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("times", e1, e2);
				}
			},
			new Action() {	// [95] expression = expression.e1 TOKEN_DIV expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("divide", e1, e2);
				}
			},
			new Action() {	// [96] expression = TOKEN_MINUS expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeOp("u_minus", e);
				}
			},
			new Action() {	// [97] expression = expression.e1 TOKEN_OR expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("or", e1, e2);
				}
			},
			new Action() {	// [98] expression = expression.e1 TOKEN_AND expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("an", e1, e2);
				}
			},
			RETURN2,	// [99] expression = TOKEN_NOT expression; returns 'expression' although none is marked
			new Action() {	// [100] expression = expression.e1 TOKEN_LT expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("lt", e1, e2);
				}
			},
			new Action() {	// [101] expression = expression.e1 TOKEN_LE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("le", e1, e2);
				}
			},
			new Action() {	// [102] expression = expression.e1 TOKEN_GT expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("gt", e1, e2);
				}
			},
			new Action() {	// [103] expression = expression.e1 TOKEN_GE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("ge", e1, e2);
				}
			},
			new Action() {	// [104] expression = expression.e1 TOKEN_EQ expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("eq", e1, e2);
				}
			},
			new Action() {	// [105] expression = expression.e1 TOKEN_NE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("ne", e1, e2);
				}
			},
			RETURN3,	// [106] expression = TOKEN_LPAR expression TOKEN_RPAR; returns 'TOKEN_RPAR' although none is marked
			Action.RETURN,	// [107] expression = procedure_expression
			Action.RETURN,	// [108] expression = variable_access
			Action.RETURN,	// [109] expression = literal
			new Action() {	// [110] literal = TOKEN_LIT_INTEGER.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final Integer e = (Integer) _symbol_e.value;
					 return new NodeLiteral(new TypeInt(e), e);
				}
			},
			new Action() {	// [111] literal = TOKEN_LIT_STRING.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final String e = (String) _symbol_e.value;
					 return new NodeLiteral(new TypeString(), e);
				}
			},
			new Action() {	// [112] literal = TOKEN_TRUE
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeLiteral(new TypeBoolean(), true);
				}
			},
			new Action() {	// [113] literal = TOKEN_FALSE
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeLiteral(new TypeBoolean(), false);
				}
			},
			new Action() {	// [114] literal = TOKEN_NULL
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeLiteral(new TypeVoid(), null);
				}
			}
		};

 
	report = new Events();
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
