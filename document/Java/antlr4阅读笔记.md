# 第一部分 ANTLR 和 计算机语言简介

## 第 1 章 初始 ANTLR

语法分析器通过输入的词法符号流来识别特定的语言结构，而词法分析器通过输入的字符流来识别特定的语言结构。

语法分析器规则以小写字母开头，词法分析器规则以大写字母开头。

以 fragment 开头的规则只能被其他的词法分析器规则使用，它们并不是词法符号。

Antlr4支持左递归，类似：

```g4
expr:   expr ('*'|'/') expr   
    |   expr ('+'|'-') expr   
    |   INT                    
    |   ID                    
    |   '(' expr ')'         
    ;
```

监听器是自动遍历的，无法控制遍历的过程，也无法利用方法的返回值来传递数据，访问器模式则相反，但访问器模式必须显式访问它们的子节点，而监听器无须如此



## 第 2 章  纵观全局



![image-20210220154236021](antlr4阅读笔记.assets/image-20210220154236021.png)

![image-20220823153644308](antlr4阅读笔记.assets/image-20220823153644308.png)



Antlr解决歧义问题的方式是：匹配在语法定义中最靠前的那条词法规则。

词法分析器处理字符序列并将生成的词法符号提供给语法分析器，语法分析器随即根据这些信息来检查语法的正确性并建造出一颗语法分析树。这个过程对应的ANTLR类是ChatStream，Lexer，Token，Parser以及ParseTree。

语法分析树监听器和访问器。

### 监听器

一个监听器的方法实际上就是回调函数。

![image-20220823154021313](antlr4阅读笔记.assets/image-20220823154021313.png)

### 访问器

有时候我们希望控制遍历语法分析树的过程，通过显式的方法调用来访问子节点。

![image-20220823154249945](antlr4阅读笔记.assets/image-20220823154249945.png)





## 第 3 章 入门的 ANTLR 项目



## 第 4 章 快速指南

```json
grammar Expr;

/** The start rule; begin parsing here. 语法分析器规则以小写字母开头，词法分析器规则以大写字母开头*/
prog:   stat+ ; 

stat:   expr NEWLINE                
    |   ID '=' expr NEWLINE        
    |   NEWLINE                   
    ;

expr:   expr ('*'|'/') expr   
    |   expr ('+'|'-') expr   
    |   INT                    
    |   ID                    
    |   '(' expr ')'         
    ;

ID  :   [a-zA-Z]+ ;      // match identifiers <label id="code.tour.expr.3"/>
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
```

语法分析器的规则以小写字母开头。

词法分析器的规则以大写字母开头。

监听器的方法会被ANTLR提供的遍历器对象自动调用，而在访问器的方法中，必须显示调用visit方法来访问子节点，没有调用visit方法的后果就是对应的子树将不会被访问到。

可选（？），出现0次或多次（*），至少一次（+）



## 第 5 章 设计语法

语言模式

序列，选择，词法符号依赖，嵌套结构

序列：

```
exprList : expr ( ', ' expr)* ;
```

选择

```
filed ： INT | STRING ；
```

词法符号依赖

```
object
    :   '{' pair (',' pair)* '}'    # AnObject
    |   '{' '}'                     # EmptyObject
    ;
    
pair:   STRING ':' value ;
```

嵌套结构

```
expr : ID '[' expr ']'
	| '(' expr ')'
	| INT
	;
```

![image-20210222153013150](antlr4阅读笔记.assets/image-20210222153013150.png)

![image-20210222153104014](antlr4阅读笔记.assets/image-20210222153104014.png)

ANTLR通过优先级选择位置靠前的备选分支来解决歧义问题，这隐式的允许我们指定运算符优先级。

ANTLR 能够处理左递归，但是无法处理间接左递归。

### 词法结构

ANTLR词法分析器解决歧义问题的方法是优先使用位置靠前的词法规则。这意味着，ID规则必须定义在所有的关键字规则之后。

.*? 非贪婪匹配：获取一些字符，直到发现匹配后续子规则的字符为止

![image-20210222163849028](antlr4阅读笔记.assets/image-20210222163849028.png)

![image-20210222163913467](antlr4阅读笔记.assets/image-20210222163913467.png)

## 第 6 章 探索真实的语法世界

