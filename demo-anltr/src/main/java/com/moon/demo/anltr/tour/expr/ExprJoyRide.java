package com.moon.demo.anltr.tour.expr; /***
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

import java.io.FileInputStream;
import java.io.InputStream;
public class ExprJoyRide {
    public static void main(String[] args) throws Exception {
        String inputFile = null; 
        if ( args.length>0 ) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is); 
        ExprLexer lexer = new ExprLexer(input); 
        CommonTokenStream tokens = new CommonTokenStream(lexer); 
        ExprParser parser = new ExprParser(tokens);
        // parse; start at prog <label id="code.tour.main.6"/>
        ParseTree tree = parser.prog();
        // print tree as text <label id="code.tour.main.7"/>
        System.out.println(tree.toStringTree(parser));
    }
}
