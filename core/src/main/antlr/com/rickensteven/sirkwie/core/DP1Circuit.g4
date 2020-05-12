grammar DP1Circuit;

@header {
package com.rickensteven.sirkwie.core;
}

file                : nodeDefinitions GROUP_SEPARATOR edgeDefinitions ;

nodeDefinitions     : nodeDefinition+ ;
edgeDefinitions     : edgeDefinition+ ;

nodeDefinition      : IDENTIFIER ID_DESC_SEPARATOR NODE_DESCRIPTOR EOL ;
edgeDefinition      : IDENTIFIER ID_DESC_SEPARATOR ( IDENTIFIER | DESC_SEPARATOR IDENTIFIER )+ EOL ;

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
ID_DESC_SEPARATOR   : ':' ;
DESC_SEPARATOR      : ',' ;
EOL                 : ';' .*? (NEWLINE | EOF) ;

COMMENT             : '#' .*? [\r\n]+ -> skip ;

NEWLINE             : '\r\n' | '\r' | '\n' ;
WS                  : [ \t]+ -> skip ;