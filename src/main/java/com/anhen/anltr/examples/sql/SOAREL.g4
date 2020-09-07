// Derived from http://json.org60
grammar SOAREL;

soar:
    expression
    ;

expression
    :   expression op=AND expression                    # andOperation
    |   expression op=OR expression                     # orOperation
    |   expr                                            # exprValue
    ;
	
expr
    :   primary op=(EQ|NE) value            # eqExpr
    |   primary op=(LT|GT|LE|GE) value      # ltExpr
    |   primary op=(IN|NOTIN) array         # inExpr
    |   primary op=LIKE value               # likeExpr
    ;

primary
    :   IDENTIFIER                          # Identifier
    ;

array
    :   '[' value (',' value)* ']'          # ArrayOfValues
    |   '[' ']'                             # EmptyArray
    ;

value
    :   STRING		# String
    |   NUMBER		# Atom
    |   'true'		# Atom
    |   'false'		# Atom
    |   'null'		# Atom
    ;

AND : A N D;
OR : O R;
EQ :   '==' ;
NE :   '!=' ;
LT :   '<' ;
GT :   '>' ;
LE :   '<=' ;
GE :   '>=' ;
DIV :   '/' ;
ADD :   '+' ;
IN :   I N;
NOTIN :  N O T I N;
LIKE :  L I K E;

IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]* | [0-9]+ [a-zA-Z_] [a-zA-Z_0-9]*;
STRING :  '"' (ESC | ~["\\])* '"' ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

NUMBER
    :   '-'? INT '.' INT EXP?   // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP            // 1e10 -3e4
    |   '-'? INT                // -3, 45
    ;
fragment INT :   '0' | '1'..'9' '0'..'9'* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]

WS  :   [ \t\n\r]+ -> skip ;

// for characterd operator
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nM];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];