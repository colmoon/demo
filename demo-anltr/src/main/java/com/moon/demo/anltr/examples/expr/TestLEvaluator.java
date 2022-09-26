package com.moon.demo.anltr.examples.expr; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public class TestLEvaluator {
    /** Sample "calculator" */
    public static class Evaluator extends LExprBaseListener {
        Stack<Integer> stack = new Stack<Integer>();

        @Override
        public void exitMult(LExprParser.MultContext ctx) {
            int right = stack.pop();
            int left = stack.pop();
            stack.push( left * right );
        }

        @Override
        public void exitAdd(LExprParser.AddContext ctx) {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left + right);
        }

        @Override
        public void exitInt(LExprParser.IntContext ctx) {
            stack.push( Integer.valueOf(ctx.INT().getText()) );
        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = Files.newInputStream(Paths.get(inputFile));
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        LExprLexer lexer = new LExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LExprParser parser = new LExprParser(tokens);
        parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
        ParseTree tree = parser.s(); // parse
        // show tree in text form
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        Evaluator eval = new Evaluator();
        walker.walk(eval, tree);
        System.out.println("stack result = "+eval.stack.pop());
    }
}
