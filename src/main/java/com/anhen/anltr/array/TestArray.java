package com.anhen.anltr.array;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @classname: TestArray
 * @description: TestArray
 * @author: wuxiaojian
 * @create: 2020-08-20 09:06
 */
public class TestArray {
    public static void main(String[] args) throws Exception{
        //新建一个CharStream，从标准输入读取数据
        CharStream inputStream = CharStreams.fromStream(System.in);

        //新建一个词法分析器，处理输入的 CharStream
        ArrayInitLexer lexer = new ArrayInitLexer(inputStream);

        //新建一个词法符号的缓冲区，用于存储词法分析器将生成的词法符号
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        //新建一个语法分析器，处理词法符号缓冲区的内容
        ArrayInitParser parser = new ArrayInitParser(tokenStream);

        //针对 init 规则，开始语法分析
        ParseTree tree = parser.init();

        //用 LISP 风格打印生成的树
        System.out.println(tree.toStringTree(parser));
    }
}
