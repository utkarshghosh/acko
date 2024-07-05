package com.example.acko2.models;

import com.example.acko2.utils.enums.OrderTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public abstract class Orders {

    private String orderId;
    private OrderTypeEnum orderType;
    private Double price;
    private Integer quantity;
    private Date timeStamp;
    private Boolean isActive;


}
