// Generated from D:/Code/IdeaProjects/demo/src/main/java/com/anhen/anltr/examples/sql\SOAREL.g4 by ANTLR 4.8
package com.anhen.anltr.examples.sql;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SOARELParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SOARELVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SOARELParser#soar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoar(SOARELParser.SoarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOperation}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperation(SOARELParser.AndOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprValue}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValue(SOARELParser.ExprValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orOperation}
	 * labeled alternative in {@link SOARELParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperation(SOARELParser.OrOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(SOARELParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpr(SOARELParser.LtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(SOARELParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeExpr}
	 * labeled alternative in {@link SOARELParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeExpr(SOARELParser.LikeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link SOARELParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SOARELParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayOfValues}
	 * labeled alternative in {@link SOARELParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOfValues(SOARELParser.ArrayOfValuesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link SOARELParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(SOARELParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link SOARELParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(SOARELParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link SOARELParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(SOARELParser.AtomContext ctx);
}