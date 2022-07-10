package com.moon.demo.anltr.tour.label; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {
    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<>();

    /** ID '=' expr NEWLINE */
    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        // id is left-hand side of '='
        String id = ctx.ID().getText();
        // compute value of expression on right
        int value = visit(ctx.expr());
        // store it in our memory
        memory.put(id, value);
        return value;
    }

    /** expr NEWLINE */
    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        // evaluate the expr child
        Integer value = visit(ctx.expr());
        // print the result
        System.out.println(value);
        // return dummy value
        return 0;
    }

    /** INT */
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    /** ID */
    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) {
            return memory.get(id);
        }
        return 0;
    }

    /** expr op=('*'|'/') expr */
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        // get value of left subexpression
        int left = visit(ctx.expr(0));
        // get value of right subexpression
        int right = visit(ctx.expr(1));
        if ( ctx.op.getType() == LabeledExprParser.MUL ) {
            return left * right;
        }
        // must be DIV
        return left / right;
    }

    /** expr op=('+'|'-') expr */
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        // get value of left subexpression
        int left = visit(ctx.expr(0));
        // get value of right subexpression
        int right = visit(ctx.expr(1));

        if ( ctx.op.getType() == LabeledExprParser.ADD ) {
            return left + right;
        }
        // must be SUB
        return left - right;
    }

    /** '(' expr ')' */
    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        // return child expr's value
        return visit(ctx.expr());
    }
}
