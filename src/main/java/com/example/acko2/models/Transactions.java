package com.example.acko2.models;

import org.springframework.data.util.Pair;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Transactions {

    private Long transactionId;
    private List<Pair<BuyOrder , SellOrder>> orders;
    private Date transactionDate;
    private String transactionState;

}
