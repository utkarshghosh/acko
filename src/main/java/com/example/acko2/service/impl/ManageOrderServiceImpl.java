package com.example.acko2.service.impl;

import com.example.acko2.models.BuyOrder;
import com.example.acko2.models.Orders;
import com.example.acko2.models.SellOrder;
import com.example.acko2.models.Transactions;
import com.example.acko2.service.ManageOrderService;
import com.example.acko2.utils.dtos.OrdersDto;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.PriorityBlockingQueue;

public class ManageOrderServiceImpl implements ManageOrderService {

    PriorityBlockingQueue<Orders> buyOrders = new PriorityBlockingQueue<>();
    PriorityBlockingQueue<Orders> sellOrders = new PriorityBlockingQueue<>((Collection) Collections.reverseOrder());



//    <o1 , o2 , o3 >
//
//
//
//    <OP , CAN>
//    <o3 > -> db -> false;
    @Override
    public void placeOrder(Orders order) {
        switch (order.getOrderType()){
            case BUY :
                buyOrders.add(order);
            case SELL:
                sellOrders.add(order);
            default:
                //TODO: throw invalid input exception
        }
    }






    @Override
    public boolean matchOrder() {
        BuyOrder latestBuyOrder = (BuyOrder) buyOrders.peek();
        SellOrder latestSellOrder = (SellOrder) sellOrders.peek();
        if(checkforMatch(latestBuyOrder , latestSellOrder)){

            if(latestSellOrder.getSellOrderType().equals("Market")){
                Transactions transactions = createTransactionForMarketPrice(latestBuyOrder , latestSellOrder);
            }else {
                Transactions transactions = createTransactionForLimitOrder(latestBuyOrder , latestSellOrder);
            }

        }
    }

    private Transactions createTransactionForMarketPrice(BuyOrder latestBuyOrder, SellOrder latestSellOrder) {
    }

    private Boolean checkforMatch(BuyOrder latestBuyOrder , SellOrder latestSellOrder ) {


        if(latestSellOrder.getSellOrderType().equals("Market")){
            return Boolean.TRUE;
        }else {
            if(latestSellOrder.getPrice() <= latestBuyOrder.getPrice()){
                return Boolean.TRUE;
            }
            else return Boolean.FALSE;
        }


    }
}
