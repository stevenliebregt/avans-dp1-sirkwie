grammar DP1Circuit;

@header {
package com.rickensteven.sirkwie;
}

file                : nodeDefinitions GROUP_SEPARATOR edgeDefinitions ;

nodeDefinitions     : nodeDefinition+ ;
edgeDefinitions     : edgeDefinition+ ;

nodeDefinition      : IDENTIFIER SEPARATOR NODE_DESCRIPTOR EOL ;
edgeDefinition      : IDENTIFIER SEPARATOR ( IDENTIFIER | ',' IDENTIFIER )+ EOL ;

NODE_DESCRIPTOR     : 'INPUT_HIGH'
                    | 'INPUT_LOW'
                    | 'PROBE'
                    | 'AND'
                    | 'NAND'
                    | 'OR'
                    | 'NOR'
                    | 'XOR'
                    | 'NOT'
                    ;

IDENTIFIER          : [a-zA-Z]+[a-zA-Z0-9]* ;

GROUP_SEPARATOR     : NEWLINE+ ;
SEPARATOR           : ':' ;
EOL                 : ';' .*? (NEWLINE | EOF) ;

NEWLINE             : '\r\n' | '\r' | '\n' ;
WS                  : [ \t]+ -> skip ;