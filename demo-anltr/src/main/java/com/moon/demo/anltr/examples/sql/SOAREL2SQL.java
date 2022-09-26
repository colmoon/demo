package com.moon.demo.anltr.examples.sql;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @classname: SOAREL2SQL
 * @description: SoarEl to SQL
 * @author: wuxiaojian
 * @create: 2020-09-02 17:04
 */
public class SOAREL2SQL {
    public static class SqlEmitter extends SOARELBaseListener{
        ParseTreeProperty<String> sql = new ParseTreeProperty<>();
        String getSQL(ParseTree ctx) { return sql.get(ctx); }
        void setSQL(ParseTree ctx, String s) { sql.put(ctx, s); }


        @Override
        public void exitSoar(SOARELParser.SoarContext ctx) {
            setSQL(ctx, getSQL(ctx.expression()));
        }

        @Override
        public void exitAndOperation(SOARELParser.AndOperationContext ctx) {
            List<SOARELParser.ExpressionContext> expressionContexts = ctx.expression();
            String value1 = getSQL(expressionContexts.get(0));
            String value2 = getSQL(expressionContexts.get(1));
            String andSql = value1 + " and " + value2;
            setSQL(ctx, andSql);
        }

        @Override
        public void exitOrOperation(SOARELParser.OrOperationContext ctx) {
            List<SOARELParser.ExpressionContext> expressionContexts = ctx.expression();
            String value1 = getSQL(expressionContexts.get(0));
            String value2 = getSQL(expressionContexts.get(1));
            String andSql = value1 + " or " + value2;
            setSQL(ctx, andSql);
        }

        @Override
        public void exitExprValue(SOARELParser.ExprValueContext ctx) {
            setSQL(ctx, getSQL(ctx.expr()));
        }

        @Override
        public void exitEqExpr(SOARELParser.EqExprContext ctx) {
            SOARELParser.PrimaryContext primaryContext = ctx.primary();
            String primary = getSQL(primaryContext);
            SOARELParser.ValueContext valueContext = ctx.value();
            String value = getSQL(valueContext);
            if (ctx.op.getType() == SOARELLexer.EQ) {
                String inSql = primary + " = " + "'" + value + "'";
                setSQL(ctx, inSql);
            } else if (ctx.op.getType() == SOARELLexer.NE){
                String inSql = primary + " != " + "'" + value + "'";
                setSQL(ctx, inSql);
            }
        }

        @Override
        public void exitLtExpr(SOARELParser.LtExprContext ctx) {
            SOARELParser.PrimaryContext primaryContext = ctx.primary();
            String primary = getSQL(primaryContext);
            SOARELParser.ValueContext valueContext = ctx.value();
            String value = getSQL(valueContext);
            String operation = "";
            if (ctx.op.getType() == SOARELLexer.LT) {
                operation = "<";
            } else if (ctx.op.getType() == SOARELLexer.GT){
                operation = ">";
            } else if (ctx.op.getType() == SOARELLexer.LE){
                operation = "<=";
            } else if (ctx.op.getType() == SOARELLexer.GE){
                operation = ">=";
            }
            String sql = primary + " " + operation +  "" + "'" + value + "'";
            setSQL(ctx, sql);
        }

        @Override
        public void exitInExpr(SOARELParser.InExprContext ctx) {
            SOARELParser.PrimaryContext primaryContext = ctx.primary();
            String primary = getSQL(primaryContext);
            SOARELParser.ArrayContext arrayContext = ctx.array();
            String value = getSQL(arrayContext);
            if (ctx.op.getType() == SOARELLexer.IN) {
                String inSql = primary + " in " + value;
                setSQL(ctx, inSql);
            } else if (ctx.op.getType() == SOARELLexer.NOTIN){
                String inSql = primary + " not in " + value;
                setSQL(ctx, inSql);
            }
        }

        @Override
        public void exitLikeExpr(SOARELParser.LikeExprContext ctx) {
            SOARELParser.PrimaryContext primaryContext = ctx.primary();
            String primary = getSQL(primaryContext);
            SOARELParser.ValueContext valueContext = ctx.value();
            String value = getSQL(valueContext);
            String likeSql = primary + " like " + "'%" + value + "%'";
            setSQL(ctx, likeSql);
        }

        @Override
        public void exitIdentifier(SOARELParser.IdentifierContext ctx) {
            setSQL(ctx, ctx.getText());
        }

        @Override
        public void exitArrayOfValues(SOARELParser.ArrayOfValuesContext ctx) {
            StringBuilder buf = new StringBuilder();
            buf.append("(");
            for (SOARELParser.ValueContext valueContext : ctx.value()) {
                buf.append("'"); // conjure up element for valid XML
                buf.append(getSQL(valueContext));
                buf.append("'");
                buf.append(",");
            }
            buf.setLength(buf.length() - 1);
            buf.append(")");
            setSQL(ctx, buf.toString());
        }

        @Override
        public void exitEmptyArray(SOARELParser.EmptyArrayContext ctx) {
            setSQL(ctx, "");
        }

        @Override
        public void exitAtom(SOARELParser.AtomContext ctx) {
            setSQL(ctx, ctx.getText());
        }

        @Override
        public void exitString(SOARELParser.StringContext ctx) {
            setSQL(ctx, stripQuotes(ctx.getText()));
        }

        public static String stripQuotes(String s) {
            if ( s==null || s.charAt(0)!='"' ) {
                return s;
            }
            return s.substring(1, s.length() - 1);
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
        SOARELLexer lexer = new SOARELLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SOARELParser parser = new SOARELParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.soar();
        // show tree in text form
//        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        SOAREL2SQL.SqlEmitter converter = new SOAREL2SQL.SqlEmitter();
        walker.walk(converter, tree);
        System.out.println(converter.getSQL(tree));
    }
}
