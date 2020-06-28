package com.goldcard.headfirstdesign.compound;

/**
 * @ClassName GooseFactory
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/20 19:37
 */
public class GooseFactory extends AbstractGooseFactory {
    @Override
    public Quackable createGooseDuck() {
        return new GooseAdapter(new Goose());
    }
}
