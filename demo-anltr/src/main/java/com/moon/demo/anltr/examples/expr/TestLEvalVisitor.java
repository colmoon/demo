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

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestLEvalVisitor {
    // a4 -visitor Expr.g4
    /** Visitor "calculator" */
    public static class EvalVisitor extends LExprBaseVisitor<Integer> {
        @Override
        public Integer visitMult(LExprParser.MultContext ctx) {
            return visit(ctx.e(0)) * visit(ctx.e(1));
        }

        @Override
        public Integer visitAdd(LExprParser.AddContext ctx) {
            return visit(ctx.e(0)) + visit(ctx.e(1));
        }

        @Override
        public Integer visitInt(LExprParser.IntContext ctx) {
            return Integer.valueOf(ctx.INT().getText());
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

        EvalVisitor evalVisitor = new EvalVisitor();
        int result = evalVisitor.visit(tree);
        System.out.println("visitor result = "+result);
    }
}
