// Generated from D:/Code/IdeaProjects/demo/src/main/java/com/anhen/anltr/examples/file\PropertyFile.g4 by ANTLR 4.8
package com.anhen.anltr.examples.file;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PropertyFileParser}.
 */
public interface PropertyFileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PropertyFileParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(PropertyFileParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropertyFileParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(PropertyFileParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropertyFileParser#prop}.
	 * @param ctx the parse tree
	 */
	void enterProp(PropertyFileParser.PropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropertyFileParser#prop}.
	 * @param ctx the parse tree
	 */
	void exitProp(PropertyFileParser.PropContext ctx);
}