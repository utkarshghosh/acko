package com.example.acko2.models;

import lombok.Data;

@Data
public class SellOrder extends  Orders{

    private String sellOrderType;
        @Override
    public boolean equals(Object o) {
            SellOrder sellOrder = (SellOrder) o;
            if(sellOrder.getOrderType().equals(this.getOrderType())){
                if( sellOrder.getPrice() != this.getPrice()){
                    return sellOrder.getPrice() > this.getPrice();
                }else
                    return sellOrder.getTimeStamp().toInstant().isBefore(this.getTimeStamp().toInstant());
            }else {
                if(this.sellOrderType.equals("Market"))
                    return Boolean.TRUE;
                else
                    return Boolean.FALSE;
            }

    }
}
