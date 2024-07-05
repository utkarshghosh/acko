package com.example.acko2.utils.dtos;

import com.example.acko2.utils.enums.OrderTypeEnum;
import lombok.Data;

import java.util.Date;
@Data
public class OrdersDto {
    private String orderId;
    private OrderTypeEnum orderType;
    private Double price;
    private Integer quantity;
    private Date timeStamp;

}
