// Generated from D:/Code/IdeaProjects/demo/src/main/java/com/anhen/anltr/examples/sql\SOAREL.g4 by ANTLR 4.8
package com.moon.demo.anltr.examples.sql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SOARELParser}.
 */
public interface SOARELListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SOARELParser#soar}.
	 * @param ctx the parse tree
	 */
	void enterSoar(SOARELParser.SoarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SOARELParser#soar}.
	 * @param ctx the parse tree
	 */
	void exitSoar(SOARELParser.SoarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOperation}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndOperation(SOARELParser.AndOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOperation}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndOperation(SOARELParser.AndOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprValue}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprValue(SOARELParser.ExprValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprValue}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprValue(SOARELParser.ExprValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orOperation}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrOperation(SOARELParser.OrOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orOperation}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrOperation(SOARELParser.OrOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(SOARELParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(SOARELParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLtExpr(SOARELParser.LtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLtExpr(SOARELParser.LtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(SOARELParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(SOARELParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code likeExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLikeExpr(SOARELParser.LikeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code likeExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLikeExpr(SOARELParser.LikeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link SOARELParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SOARELParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link SOARELParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SOARELParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayOfValues}
	 * labeled alternative in {@link SOARELParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayOfValues(SOARELParser.ArrayOfValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayOfValues}
	 * labeled alternative in {@link SOARELParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayOfValues(SOARELParser.ArrayOfValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link SOARELParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(SOARELParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link SOARELParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(SOARELParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link SOARELParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(SOARELParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link SOARELParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(SOARELParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link SOARELParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAtom(SOARELParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link SOARELParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAtom(SOARELParser.AtomContext ctx);
}