package com.anhen.anltr.array;

/**
 * @classname: ShortToUnicodeString
 * @description: 将类似{1, 2, 3}的short数组翻译成"\u0001\u0002\u0003"
 * @author: wuxiaojian
 * @create: 2020-08-20 10:20
 */
public class ShortToUnicodeString extends ArrayInitBaseListener{

    /**
     * 将 { 翻译成 "
     **/
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx){
        System.out.print('"');
    }

    /**
     * 将 } 翻译成 "
     **/
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx){
        System.out.print('"');
    }

    /**
     * 将每个整数翻译成四位的十六进制形式，然后加前缀
     **/
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx){
        //假定不存在嵌套结构
        int value = Integer.parseInt(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }

}
