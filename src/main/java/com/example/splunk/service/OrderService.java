package com.example.splunk.service;

import com.example.splunk.dto.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
//@Slf4j
public class OrderService {
    private List<Order> orderList = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = LogManager.getLogger(OrderService.class);

    public Order addOrder(Order order) throws JsonProcessingException {
        log.info("OrderService addOrder execution started..");
        log.info("OrderService addOrder request payload {}", mapper.writeValueAsString(order));
        order.setOrderPlacedDate(new Date());
        order.setTransactionId(UUID.randomUUID().toString());
        orderList.add(order);
        log.info("OrderService addOrder response payload {}", mapper.writeValueAsString(order));
        log.info("OrderService addOrder execution ended..");
        return order;
    }

    public List<Order> getOrders() throws JsonProcessingException {
        log.info("OrderService getOrders execution started..");
        List<Order> list = new ArrayList<>();
        list.addAll(orderList);
        log.info("OrderService getOrders response payload {}", mapper.writeValueAsString(list));
        log.info("OrderService getOrders execution ended..");
        return list;
    }

    public Order getOrder(int id) throws JsonProcessingException {
        log.info("OrderService getOrder execution started..");
        Order order = orderList.stream()
                .filter(o -> o.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("oder not found with id " + id));
        log.info("OrderService getOrders response payload {}", mapper.writeValueAsString(order));
        log.info("OrderService getOrder execution ended..");
        return order;
    }
}
