package com.moon.demo.anltr.array;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @classname: Translate
 * @description:
 * @author: wuxiaojian
 * @create: 2020-08-20 10:29
 */
public class Translate {
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

        //新建一个通用的 能够触发回调函数的语法分析器遍历树
        ParseTreeWalker walker = new ParseTreeWalker();

        //遍历语法分析过程中生成的语法分析树，触发回调
        walker.walk(new ShortToUnicodeString(), tree);
        System.out.println();
    }
}
