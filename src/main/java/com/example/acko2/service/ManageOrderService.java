package com.example.acko2.service;

import com.example.acko2.models.Orders;

public interface ManageOrderService {

    void placeOrder(Orders order);
    boolean matchOrder();
}
