package com.moon.demo.design.design.chapter14.mediator.instance;

public class Mediator extends AbstractMediator {
    //中介者最重要的方法
    @Override
    public void execute(String str, Object... objects) {
        if ("purchase.buy".equals(str)) {
            //采购电脑
            this.buyComputer((Integer) objects[0]);
        } else if ("sale.sell".equals(str)) {
            //销售电脑
            this.sellComputer((Integer) objects[0]);
        } else if ("sale.offsell".equals(str)) {
            //折价销售
            this.offSell();
        } else if ("stock.clear".equals(str)) {
            //清仓处理
            this.clearStock();
        }
    }

    //采购电脑
    private void buyComputer(int number) {
        int saleStatus = super.sale.getSaleStatus();
        if (saleStatus > 80) {
            //销售情况良好
            System.out.println("采购IBM电脑:" + number + "台");
            super.stock.increase(number);
        } else {
            //销售情况不好
            int buyNumber = number / 2; //折半采购
            System.out.println("采购IBM电脑： " + buyNumber + "台");
        }
    }

    //销售电脑
    private void sellComputer(int number) {
        if (super.stock.getStockNumber() < number) { //库存数量不够销售
            super.purchase.buyIBMcomputer(number);
        }
        super.stock.decrease(number);
    }

    //折价销售电脑
    private void offSell() {
        System.out.println("折价销售IBM电脑" + stock.getStockNumber() + "台");
    }

    //清仓处理
    private void clearStock() {
        //要求清仓销售
        super.sale.offSale();
        //要求采购人员不要采购
        super.purchase.refuseBuyIBM();
    }
}