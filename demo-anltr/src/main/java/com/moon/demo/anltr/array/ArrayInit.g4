/** 语法文件通常以grammer关键字开头
 *  这是一个名为 ArrayInit 的语法，它必须和文件名 ArrayInit.g4相匹配
 */
grammar ArrayInit;

/** 一条名为 init 的规则， 它匹配一对花括号中的逗号分隔的value*/
//必须匹配至少一个 value
init : '{' value (', ' value)* '}' ;

//一个 value 可以是嵌套的花括号结构，也可以是一个简单的整数，即 INT 词法符号
value : init
        | INT
        ;

// 语法分析器必须以小写字母开头，词法分析器的规则必须用大写字母开头
// 定义词法符号 INT，它由一个或多个数字组成
INT : [0-9]+ ;
// 定义词法规则 "空白符号"丢弃之
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines