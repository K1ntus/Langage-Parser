package ubordeaux.deptinfo.compilation.project.main;

import java.util.Iterator;
import ubordeaux.deptinfo.compilation.project.type.*;
import fr.groupname.compilator.environment.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Map;
import fr.groupname.compilator.error.*;
import beaver.*;
import fr.groupname.compilator.special.*;
import ubordeaux.deptinfo.compilation.project.node.*;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "Parser.grammar".
 */
public class Parser extends beaver.Parser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pjM0bq5SKIlJDltA9Y8YW1ymaecX0K5HSqG6GFKK5050AHG23iHFqVN701mHr488A88A1" +
		"YH4L1KK0H5D68kEA6E#wAAtxthRpJhzxBpBo51AFdU8xld3ktkggxghfdfhlc0Ku5UYCTfw" +
		"0z1g4ULc1Fx8MzKGVx81Lfs1TriH$sHtrqm34u7WLeXHDn4av6DsGY0mSZ2xl1bgruNbl$G" +
		"HCSX0laQWp3sUY9qz0N$J40O#9usFrFnnx2I5iHyiV6BjM8NSfnps4bpiKoIgln4CSvwkS2" +
		"t1$ZmPjfIeqopKDtj4KRj6US1e5CTwt5E5qm1PtaSzmkMsLZ8CuUIUECh56SXZeRuNmo0d7" +
		"oaiOPNQCuZS9na14dJiUaSSwgGPp66kK#p6US0oCnzJaOcpJE#1h4QQgURqHdnZaa4AT7qZ" +
		"Zt9eoJYKMu6tTXAKvbprM#LSh40MY6vZWCX#D87EMpvM6cpvQ9riZMd4emEE1dQ48$bUWNy" +
		"BCEZw8TSdppY$Wv8w6VJ0nCOXkLs2Ql9RJz3nVxR1TX17qTgfazYJKu9n3dp2Gvt9dGDXVd" +
		"#MonztuH9cCQhiL4JCAbk0oNumgqq3pEbzLH#ooFFQAxFevkGHpT4t5qpyRHlUpHnMRwh#Q" +
		"VfPc22UwEZyMKAemqsoTDZKgLAXsXpzriREARUWccOmwkn5MukjhI55nZVCsWLAvUMqQz7g" +
		"tIiSh7AUSgNuVvSRsUeFQkohtHI$bqmuMgBr8kLXwkNARyN#K7UBQFmyMonPpjxYc$2lUW3" +
		"sx51daM6$0gRi0yt8I5k1aLk12tu3RaumwymBLSWlLcVyZ3Slb4dfEFYO$mC1wKpLYBHpZw" +
		"CJoEZNWAB#9fuXbinajmVw$m$kHoBst3BF8uftRCf0DFgqxepFCvdxChCFVEWisgnM6biYl" +
		"hfzrvFjjwsXUYb7lySRwpFvqxKqFkvXdSSHfnBshCVIVMG$DQY9tEs6q3iLEh5JkLfrOndw" +
		"uZAGrcNPREKoFi9vtxTz33pcUQ7HsRoZtKdsdVMempcjeoeqtbVVN7wLUBSI8ZmJWfWJZPV" +
		"q6Sb3XnGhKM9pAkXBPKJypmSp2crkCSpOewDaxQJiQnpPxQdNLNckdfNILRwwvwMdbvRTdS" +
		"XRmscrbLFQLz0txw9VJJ9n33PbKqYBM5VtuxpYUvxTWajjI4jbJkmrxR6JoBgfwgGrdzb0H" +
		"yjKeIfoYXRGJljjSMU#yZzwW7w#LUh7jxisgEv975bOzd$pjqiPd#g$cdQRAC9eUIPQGKdt" +
		"HuLEgZKjMRwRwfQVn#F8XVUWVp#wwwKiH$DhbPZDU8b8XRSbGyhpiQLrDsp$Rct072Pxjxo" +
		"ZVW3f36gsNGdzyzHLozDCx0maZsjBYA3hzgSxXgEMP$oAQz6Nk7OR6lsxk1MSqiimfXNrdq" +
		"raBuentOCf4NDZuZvGFsAUJ2YQROuXSpk5S0sm0hmzNj3FYxaZYAFjwiqjc$yb8N2Er2xac" +
		"kGxwGN9$zs2NKc5oFt8pSXToIzeRarkI#v4xafUHkv7V9fxFVVkHYSW5vE7a5cNEmkfB7ax" +
		"TvSlgTkidCmvEdrOVj2lA2SDlfppvJgHiRVrxs9FPT7fP3ioXlLlrqjc$Y#5ArqQTTH#Lbb" +
		"9kgl9foIutze#QrcEXH5IEqddtQKNYDV03xxQtwJMntPxkzjbaVsqKKUF#S3fuS5n9ps6#S" +
		"zdkV#4JbLSHRn1V9xfz$pg5rz9yUq7tBomVaxsZZ$Gozf$gFTHrvFvnMp65orHY7Qntwd5o" +
		"cxOi8Yiu0RNlxzYCcUTf32TvVPwIsXz7t4dzEJh6kvsXjNwfy6L5EN4USIqnG$K1YZifZcT" +
		"jsZwyRYRd4#SJb19ybfxx7Ff#8F3FZY0nYbZSVlbzhI4s9JCrhA7MLPCuDSnAjTtN1tpl#j" +
		"bLNkOjoD#NnofSeRrBU7cOxJtbIc4DhbJzL$bBv6#NlbN#EpSb9YPFdUO4#TQetFsVVG7j$" +
		"ZzpG8pVoo0VwnrZBUN7tcscKLsgVGpIlzSew7oT7noWxBRJTn7qFO$Ep8izjEksUPyCkhSx" +
		"yTZn$gzpZKzzbUu97n$VBQU8VOr$bRpk7$OduCmE#T1#oAfACgGoCwUZ9hJosVsYUnpxVCw" +
		"unaU#nLVZ7OGlViDzbgolAaz2VLChZia4Ua$Nog3mYwsIjF2pBv1wvMvRA3DDZZTpCwo9Y8" +
		"R60uAujymY#yN83mPrJhYTc4zpXXRk6y6sNkMPykSnKJxV8TBdLI0#QwqgvLgR9DJ9LfiW3" +
		"xFKGTJFaVcER8IiCtsUkzvhhyaZcib6Uqlpl8kvK#Oxeh9R8xIhTHhmZRslhJVb9VfGVv7l" +
		"vJhwL$yitibs#fdwRV2LV8lgJJuaFLVv0tbVfNUKlY3VaTID$9k#fzYrpNImLyWJvLU9buY" +
		"LvCUhr1NDznbmtoTFm$EHvUONNt#HNRVyilv36uKpMXAMKIda83pDmwno7DRyL5pqzw4RqK" +
		"dJdc9FXddmXWrDPRmwdFeBUz7qQ#umWkry$HPJRidzRjaSQMAor7DPK8LDNyNGXB8oYRHHv" +
		"0Db5CUN1n13k8KDOqGvalu5i3#AuGLgpvZ6skwEpGa4XnnHIVuAYNH9qOFoExD#QNCQnPTI" +
		"DfZ$tNv9EvCv45oAVw4gqfzwB0euhOEmJoISnlp7qDORw4hPBs3#NSYxbNFDD6Gh0JY37Wn" +
		"L5cpWuwm#YQV25");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
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
		
	private TypeEnvironment typeEnvironment = new TypeEnvironment("types");
	private ProcedureEnvironment procedureEnvironment = new ProcedureEnvironment("procedures");
	private StackEnvironment stackEnvironment = new StackEnvironment("local variables stack");
	private String type_declaration_name;

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			new Action() {	// [0] program = type_declaration_part variable_declaration_part procedure_definition_part TOKEN_BEGIN push_stackenv statement_list.l TOKEN_END pop_stackenv
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_l = _symbols[offset + 6];
					final NodeList l = (NodeList) _symbol_l.value;
					 return _symbol_l;
				}
			},
			Action.NONE,  	// [1] type_declaration_part = 
			RETURN2,	// [2] type_declaration_part = TOKEN_TYPE type_declaration_list; returns 'type_declaration_list' although none is marked
			new Action() {	// [3] type_declaration_list = type_declaration_list type_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
				}
			},
			new Action() {	// [4] type_declaration_list = type_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
				}
			},
			new Action() {	// [5] type_declaration = TOKEN_IDENTIFIER.name TOKEN_AFF type.t TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_name = _symbols[offset + 1];
					final String name = (String) _symbol_name.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					
																try{
																	typeEnvironment.putVariable(name, t);
																	} catch (DuplicateTypeDeclaration e) {
																		System.err.println(e);
																	} finally {
																		return new EmptySymbol();
																	}
				}
			},
			Action.RETURN,	// [6] type = simple_type
			Action.RETURN,	// [7] type = named_type
			Action.RETURN,	// [8] type = index_type
			Action.RETURN,	// [9] type = array_type
			Action.RETURN,	// [10] type = pointer_type
			Action.RETURN,	// [11] type = structure_type
			new Action() {	// [12] simple_type = TOKEN_STRING
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeString();
				}
			},
			new Action() {	// [13] simple_type = TOKEN_INTEGER
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeInt();
				}
			},
			new Action() {	// [14] simple_type = TOKEN_BOOLEAN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new TypeBoolean();
				}
			},
			new Action() {	// [15] named_type = TOKEN_IDENTIFIER.r
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_r = _symbols[offset + 1];
					final String r = (String) _symbol_r.value;
					 return new TypeNamed(r);
				}
			},
			Action.RETURN,	// [16] index_type = enumerated_type
			Action.RETURN,	// [17] index_type = subrange_type
			new Action() {	// [18] enumerated_type = init_enumerated_type TOKEN_LPAR identifier_list.id_l TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id_l = _symbols[offset + 3];
					final IdentifierList id_l = (IdentifierList) _symbol_id_l.value;
					 
																			Vector<Type> array_tmp = new Vector<>();
																			int const_id = 0;
																			for(String identifier : id_l) {
																				array_tmp.add(new TypeItemEnum(const_id, identifier));
																				const_id +=1;
																			}
																			return new TypeTuple(array_tmp);
				}
			},
			Action.NONE,  	// [19] init_enumerated_type = 
			new Action() {	// [20] subrange_type = TOKEN_LIT_INTEGER.min TOKEN_DOTDOT TOKEN_LIT_INTEGER.max
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_min = _symbols[offset + 1];
					final Integer min = (Integer) _symbol_min.value;
					final Symbol _symbol_max = _symbols[offset + 3];
					final Integer max = (Integer) _symbol_max.value;
					 return new TypeArrayRange(new TypeInt(min), new TypeInt(max));
				}
			},
			RETURN3,	// [21] subrange_type = TOKEN_IDENTIFIER.id_min TOKEN_DOTDOT TOKEN_IDENTIFIER.id_max; returns 'id_max' although more are marked
			new Action() {	// [22] array_type = TOKEN_ARRAY TOKEN_LBRACKET range_type.range TOKEN_RBRACKET TOKEN_OF type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_range = _symbols[offset + 3];
					final TypeRange range = (TypeRange) _symbol_range.value;
					final Symbol _symbol_t = _symbols[offset + 6];
					final Type t = (Type) _symbol_t.value;
					 return new TypeArray(range, t);
				}
			},
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
			new Action() {	// [27] structure_type = TOKEN_STRUCT TOKEN_LBRACE feature_list_type.list TOKEN_RBRACE
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 3];
					final TypeFeatureList list = (TypeFeatureList) _symbol_list.value;
					 return new TypeStruct(list);
				}
			},
			new Action() {	// [28] feature_list_type = feature_list_type.list feature_type.elem
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final TypeFeatureList list = (TypeFeatureList) _symbol_list.value;
					final Symbol _symbol_elem = _symbols[offset + 2];
					final TypeFeature elem = (TypeFeature) _symbol_elem.value;
					 list.add(elem); return list;
				}
			},
			new Action() {	// [29] feature_list_type = feature_type.elem
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_elem = _symbols[offset + 1];
					final TypeFeature elem = (TypeFeature) _symbol_elem.value;
					 TypeFeatureList list = new TypeFeatureList(elem); return list;
				}
			},
			new Action() {	// [30] feature_type = TOKEN_IDENTIFIER.id TOKEN_COLON type.t TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					 System.out.println("FEATURES"); return new TypeFeature(id, t);
				}
			},
			Action.NONE,  	// [31] variable_declaration_part = 
			RETURN2,	// [32] variable_declaration_part = TOKEN_VAR variable_declaration_list; returns 'variable_declaration_list' although none is marked
			new Action() {	// [33] variable_declaration_list = variable_declaration_list variable_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [34] variable_declaration_list = variable_declaration
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			new Action() {	// [35] variable_declaration = identifier_list.id_list TOKEN_COLON type.t TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id_list = _symbols[offset + 1];
					final IdentifierList id_list = (IdentifierList) _symbol_id_list.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					
																for(String str : id_list){
																	stackEnvironment.add_node_to_latest_portability(str, new NodeLiteral(t, 0));
																}
																
																return _symbol_id_list;
				}
			},
			new Action() {	// [36] identifier_list = identifier_list.list TOKEN_COMMA TOKEN_IDENTIFIER.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final IdentifierList list = (IdentifierList) _symbol_list.value;
					final Symbol _symbol_id = _symbols[offset + 3];
					final String id = (String) _symbol_id.value;
					 
																	list.add(id); return list;
				}
			},
			new Action() {	// [37] identifier_list = TOKEN_IDENTIFIER.name
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_name = _symbols[offset + 1];
					final String name = (String) _symbol_name.value;
					 
																	return new IdentifierList(name);
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
			new Action() {	// [42] procedure_definition = procedure_definition_head.node_fct block.fct_content
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node_fct = _symbols[offset + 1];
					final NodeCallFct node_fct = (NodeCallFct) _symbol_node_fct.value;
					final Symbol _symbol_fct_content = _symbols[offset + 2];
					final NodeList fct_content = (NodeList) _symbol_fct_content.value;
					 
			node_fct.getTypeFunct().setDefined(true); 
			procedureEnvironment.putVariable(node_fct, fct_content); 
			return new EmptySymbol();
				}
			},
			new Action() {	// [43] procedure_definition = procedure_declaration_head.node_fct TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node_fct = _symbols[offset + 1];
					final NodeCallFct node_fct = (NodeCallFct) _symbol_node_fct.value;
					 
			procedureEnvironment.putVariable(node_fct, new NodeList()); 
			return new EmptySymbol();
				}
			},
			Action.RETURN,	// [44] procedure_definition_head = procedure_head
			Action.RETURN,	// [45] procedure_declaration_head = procedure_head
			new Action() {	// [46] procedure_head = TOKEN_PROCEDURE TOKEN_IDENTIFIER.funct_name TOKEN_LPAR argt_part.args TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_funct_name = _symbols[offset + 2];
					final String funct_name = (String) _symbol_funct_name.value;
					final Symbol _symbol_args = _symbols[offset + 4];
					final NodeList args = (NodeList) _symbol_args.value;
									
				TypeFunct type_function = new TypeFunct(funct_name, new TypeTuple(), new TypeVoid());
			
				return new NodeCallFct(funct_name, type_function, new NodeList());
				}
			},
			new Action() {	// [47] procedure_head = TOKEN_FUNCTION TOKEN_IDENTIFIER.funct_name TOKEN_LPAR argt_part.args TOKEN_RPAR TOKEN_COLON type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_funct_name = _symbols[offset + 2];
					final String funct_name = (String) _symbol_funct_name.value;
					final Symbol _symbol_args = _symbols[offset + 4];
					final NodeList args = (NodeList) _symbol_args.value;
					final Symbol _symbol_t = _symbols[offset + 7];
					final Type t = (Type) _symbol_t.value;
					
				TypeTuple params_tuple = new TypeTuple();
				
				for(Node n : args.getList()) {
					NodeId n_id = (NodeId) n;
					params_tuple.add(new TypeFeature(n_id.getName(), n_id.getType()));
				}
				
				TypeFunct type_function = new TypeFunct(funct_name, params_tuple, t);
			
				return new NodeCallFct(funct_name, type_function, new NodeList());
				}
			},
			Action.NONE,  	// [48] argt_part = 
			Action.RETURN,	// [49] argt_part = argt_list
			new Action() {	// [50] argt_list = argt_list.nl TOKEN_COMMA argt.elem
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_nl = _symbols[offset + 1];
					final NodeList nl = (NodeList) _symbol_nl.value;
					final Symbol _symbol_elem = _symbols[offset + 3];
					final NodeId elem = (NodeId) _symbol_elem.value;
					 nl.add(elem); return nl;
				}
			},
			new Action() {	// [51] argt_list = argt.elem
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_elem = _symbols[offset + 1];
					final NodeId elem = (NodeId) _symbol_elem.value;
					 NodeList nl = new NodeList(elem); return nl;
				}
			},
			new Action() {	// [52] argt = TOKEN_IDENTIFIER.id TOKEN_COLON type.t
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_id = _symbols[offset + 1];
					final String id = (String) _symbol_id.value;
					final Symbol _symbol_t = _symbols[offset + 3];
					final Type t = (Type) _symbol_t.value;
					 return new NodeId(id, t);
				}
			},
			new Action() {	// [53] block = variable_declaration_part TOKEN_BEGIN push_stackenv statement_list.list TOKEN_END pop_stackenv
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 4];
					final NodeList list = (NodeList) _symbol_list.value;
					 return _symbol_list;
				}
			},
			new Action() {	// [54] pop_stackenv = 
				public Symbol reduce(Symbol[] _symbols, int offset) {
						
						//System.out.println("[STACK] Poped one more stack layer"); 
						stackEnvironment.getEnvironment().pop(); 
						return new EmptySymbol();
				}
			},
			new Action() {	// [55] push_stackenv = 
				public Symbol reduce(Symbol[] _symbols, int offset) {
						
						//System.out.println("[STACK] Pushed one more stack layer"); 
						stackEnvironment.getEnvironment().push(new HashMap<String, NodeLiteral>(stackEnvironment.getEnvironment().peek())); 
						return new EmptySymbol();
				}
			},
			new Action() {	// [56] statement_list = statement_list.root statement.elt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_root = _symbols[offset + 1];
					final NodeList root = (NodeList) _symbol_root.value;
					final Symbol _symbol_elt = _symbols[offset + 2];
					final Node elt = (Node) _symbol_elt.value;
					 root.add(elt); return root;
				}
			},
			new Action() {	// [57] statement_list = statement.elt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_elt = _symbols[offset + 1];
					final Node elt = (Node) _symbol_elt.value;
					 return new NodeList(elt);
				}
			},
			Action.RETURN,	// [58] statement = simple_statement
			Action.RETURN,	// [59] statement = structured_statement
			new Action() {	// [60] simple_statement = assignment_statement.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol e = _symbols[offset + 1];
					 
								//System.out.println("[STATE] assignment: "+e); 
								return e;
				}
			},
			Action.RETURN,	// [61] simple_statement = procedure_statement
			Action.RETURN,	// [62] simple_statement = new_statement
			Action.RETURN,	// [63] simple_statement = dispose_statement
			Action.RETURN,	// [64] simple_statement = println_statement
			Action.RETURN,	// [65] simple_statement = readln_statement
			Action.RETURN,	// [66] simple_statement = return_statement
			new Action() {	// [67] assignment_statement = variable_access.e1 TOKEN_AFF expression.e2 TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					  
																return new NodeAssign(e1, e2);
				}
			},
			RETURN2,	// [68] procedure_statement = procedure_expression TOKEN_SEMIC; returns 'TOKEN_SEMIC' although none is marked
			new Action() {	// [69] procedure_expression = TOKEN_IDENTIFIER.func_name TOKEN_LPAR expression_part.args TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_func_name = _symbols[offset + 1];
					final String func_name = (String) _symbol_func_name.value;
					final Symbol _symbol_args = _symbols[offset + 3];
					final NodeList args = (NodeList) _symbol_args.value;
					 
																				try{
																					NodeCallFct fct = procedureEnvironment.getNodeFct(func_name);
																					return new NodeCallFct(func_name, fct.getTypeFunct(), args);
																				}catch(NoSuchFieldException e){
																					System.out.println("Procedure Expression: " + e);
																					return new NodeCallFct(func_name, new TypeFunct(func_name, new TypeTuple(), new TypeVoid()), args);
																				}
				}
			},
			Action.NONE,  	// [70] expression_part = 
			Action.RETURN,	// [71] expression_part = expression_list
			new Action() {	// [72] expression_list = expression_list.root TOKEN_COMMA expression.elt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_root = _symbols[offset + 1];
					final NodeList root = (NodeList) _symbol_root.value;
					final Symbol _symbol_elt = _symbols[offset + 3];
					final NodeExp elt = (NodeExp) _symbol_elt.value;
					 root.add(elt); return root;
				}
			},
			new Action() {	// [73] expression_list = expression.expr
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expr = _symbols[offset + 1];
					final NodeExp expr = (NodeExp) _symbol_expr.value;
					 return new NodeList(expr);
				}
			},
			new Action() {	// [74] new_statement = TOKEN_NEW variable_access.node TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 2];
					final NodeExp node = (NodeExp) _symbol_node.value;
					 return new NodeNew(node);
				}
			},
			new Action() {	// [75] dispose_statement = TOKEN_DISPOSE variable_access.node TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 2];
					final NodeExp node = (NodeExp) _symbol_node.value;
					 return new NodeDispose(node);
				}
			},
			new Action() {	// [76] println_statement = TOKEN_PRINTLN expression.args TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_args = _symbols[offset + 2];
					final NodeExp args = (NodeExp) _symbol_args.value;
					 
			TypeTuple params_tuple = null;
	
			if(args instanceof NodeCallFct) {
				NodeCallFct tmp = (NodeCallFct) args;
				params_tuple= new TypeTuple(new TypeFeature(tmp.getName(), tmp.getTypeFunct()));
			} else {
				params_tuple= new TypeTuple(new TypeFeature("print nodelist", args.getType()));
			}

			
			return new NodeCallFct(
					"println",
					new TypeFunct("println", params_tuple, new TypeVoid()),
					new NodeList(args));
				}
			},
			new Action() {	// [77] readln_statement = TOKEN_READLN expression.e TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 
			return new NodeCallFct(
				"readln", 
				new TypeFunct("readln", 
					new TypeTuple(e.getType()), 
					e.getType()),
				new NodeList());
				}
			},
			new Action() {	// [78] return_statement = TOKEN_RETURN expression.node TOKEN_SEMIC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_node = _symbols[offset + 2];
					final NodeExp node = (NodeExp) _symbol_node.value;
					 return new NodeReturn(node);
				}
			},
			Action.RETURN,	// [79] structured_statement = block
			Action.RETURN,	// [80] structured_statement = if_statement
			Action.RETURN,	// [81] structured_statement = while_statement
			Action.RETURN,	// [82] structured_statement = switch_statement
			new Action() {	// [83] if_statement = TOKEN_IF expression.e TOKEN_THEN statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
						return new NodeIf(e, stm);
				}
			},
			new Action() {	// [84] if_statement = TOKEN_IF expression.e TOKEN_THEN statement.stm_then TOKEN_ELSE statement.stm_else
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
			new Action() {	// [85] while_statement = TOKEN_WHILE expression.e1 TOKEN_DO statement.stm
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 2];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_stm = _symbols[offset + 4];
					final Node stm = (Node) _symbol_stm.value;
						return new NodeWhile(e1, stm);
				}
			},
			new Action() {	// [86] switch_statement = TOKEN_SWITCH expression.root TOKEN_BEGIN case_statement_list.case_list TOKEN_END
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_root = _symbols[offset + 2];
					final NodeExp root = (NodeExp) _symbol_root.value;
					final Symbol _symbol_case_list = _symbols[offset + 4];
					final NodeCaseList case_list = (NodeCaseList) _symbol_case_list.value;
					 return new NodeSwitch(root, case_list);
				}
			},
			new Action() {	// [87] case_statement_list = case_statement_list.list case_statement.item
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final NodeCaseList list = (NodeCaseList) _symbol_list.value;
					final Symbol _symbol_item = _symbols[offset + 2];
					final NodeCase item = (NodeCase) _symbol_item.value;
					 list.add(item); return list;
				}
			},
			new Action() {	// [88] case_statement_list = case_statement.item
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_item = _symbols[offset + 1];
					final NodeCase item = (NodeCase) _symbol_item.value;
					 NodeCaseList list = new NodeCaseList(); list.add(item); return list;
				}
			},
			new Action() {	// [89] case_statement = TOKEN_CASE TOKEN_IDENTIFIER.name TOKEN_COLON statement.state
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_name = _symbols[offset + 2];
					final String name = (String) _symbol_name.value;
					final Symbol _symbol_state = _symbols[offset + 4];
					final Node state = (Node) _symbol_state.value;
					 return new NodeCase(name, state);
				}
			},
			new Action() {	// [90] case_statement = TOKEN_DEFAULT TOKEN_COLON statement.state
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_state = _symbols[offset + 3];
					final Node state = (Node) _symbol_state.value;
					 return new NodeCase("default", state);
				}
			},
			new Action() {	// [91] variable_access = TOKEN_IDENTIFIER.name
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_name = _symbols[offset + 1];
					final String name = (String) _symbol_name.value;
						
										try{
											//System.out.println("[VARIABLE]" + name +" found.");
											return stackEnvironment.get_node_reachable(name);  
										} catch (NoSuchFieldException e) {
											System.out.println("Variable [" + name + "]: "+ e);
											return new NodeLiteral(new TypeVoid(), null);
										}
				}
			},
			new Action() {	// [92] variable_access = variable_access.var TOKEN_LBRACKET expression.e TOKEN_RBRACKET
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_var = _symbols[offset + 1];
					final NodeExp var = (NodeExp) _symbol_var.value;
					final Symbol _symbol_e = _symbols[offset + 3];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeArrayAccess(var, e);
				}
			},
			new Action() {	// [93] variable_access = expression.e TOKEN_CIRC
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodePtrAccess(e);
				}
			},
			new Action() {	// [94] expression = expression.e1 TOKEN_PLUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("plus", e1, e2);
				}
			},
			new Action() {	// [95] expression = expression.e1 TOKEN_MINUS expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("minus", e1, e2);
				}
			},
			new Action() {	// [96] expression = expression.e1 TOKEN_TIMES expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("times", e1, e2);
				}
			},
			new Action() {	// [97] expression = expression.e1 TOKEN_DIV expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeOp("divide", e1, e2);
				}
			},
			new Action() {	// [98] expression = TOKEN_MINUS expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeOp("u_minus", e);
				}
			},
			new Action() {	// [99] expression = expression.e1 TOKEN_OR expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("or", e1, e2);
				}
			},
			new Action() {	// [100] expression = expression.e1 TOKEN_AND expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("an", e1, e2);
				}
			},
			new Action() {	// [101] expression = TOKEN_NOT expression.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return new NodeRel("no", e, new NodeLiteral(new TypeBoolean(), false));
				}
			},
			new Action() {	// [102] expression = expression.e1 TOKEN_LT expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("lt", e1, e2);
				}
			},
			new Action() {	// [103] expression = expression.e1 TOKEN_LE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("le", e1, e2);
				}
			},
			new Action() {	// [104] expression = expression.e1 TOKEN_GT expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("gt", e1, e2);
				}
			},
			new Action() {	// [105] expression = expression.e1 TOKEN_GE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("ge", e1, e2);
				}
			},
			new Action() {	// [106] expression = expression.e1 TOKEN_EQ expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("eq", e1, e2);
				}
			},
			new Action() {	// [107] expression = expression.e1 TOKEN_NE expression.e2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e1 = _symbols[offset + 1];
					final NodeExp e1 = (NodeExp) _symbol_e1.value;
					final Symbol _symbol_e2 = _symbols[offset + 3];
					final NodeExp e2 = (NodeExp) _symbol_e2.value;
					 return new NodeRel("ne", e1, e2);
				}
			},
			new Action() {	// [108] expression = TOKEN_LPAR expression.e TOKEN_RPAR
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 2];
					final NodeExp e = (NodeExp) _symbol_e.value;
					 return e;
				}
			},
			Action.RETURN,	// [109] expression = procedure_expression
			Action.RETURN,	// [110] expression = variable_access
			Action.RETURN,	// [111] expression = literal
			new Action() {	// [112] literal = TOKEN_LIT_INTEGER.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final Integer e = (Integer) _symbol_e.value;
					 return new NodeLiteral(new TypeInt(), e);
				}
			},
			new Action() {	// [113] literal = TOKEN_LIT_STRING.e
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_e = _symbols[offset + 1];
					final String e = (String) _symbol_e.value;
					 return new NodeLiteral(new TypeString(), e);
				}
			},
			new Action() {	// [114] literal = TOKEN_TRUE
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeLiteral(new TypeBoolean(), true);
				}
			},
			new Action() {	// [115] literal = TOKEN_FALSE
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new NodeLiteral(new TypeBoolean(), false);
				}
			},
			new Action() {	// [116] literal = TOKEN_NULL
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
