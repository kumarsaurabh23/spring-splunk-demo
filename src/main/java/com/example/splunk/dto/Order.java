package com.example.splunk.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Order {
    private int id;
    private Date orderPlacedDate;
    private String transactionId;
}
