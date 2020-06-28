package com.goldcard.headfirstdesign.compound;

import com.goldcard.headfirstdesign.instruction.Quack;

/**
 * @ClassName DuckSimulator
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/20 18:56
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
//        simulator.simulate();

        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        AbstractGooseFactory gooseFactory = new GooseFactory();
        simulator.simulate(duckFactory, gooseFactory);
    }

    public void simulate(AbstractDuckFactory duckFactory, AbstractGooseFactory gooseFactory){
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = gooseFactory.createGooseDuck();
        System.out.println("\nDuck Simulator: with Composite - Flocks");

        Flock flockDucks = new Flock();

        flockDucks.add(redheadDuck);
        flockDucks.add(duckCall);
        flockDucks.add(rubberDuck);
        flockDucks.add(gooseDuck);

        Flock flockMallards = new Flock();

        Quackable mallardDuck1 = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();

        flockMallards.add(mallardDuck1);
        flockMallards.add(mallardDuck2);
        flockMallards.add(mallardDuck3);
        flockMallards.add(mallardDuck4);

        System.out.println("\nDuck Simulator: With Observer");
        Quacklogist quacklogist = new Quacklogist();
        flockMallards.registerObserver(quacklogist);
        flockDucks.registerObserver(quacklogist);

        simulate(flockDucks);

        simulate(flockMallards);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    public void simulate(){
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    public void simulate(Quackable duck){
        duck.quack();
    }
}
