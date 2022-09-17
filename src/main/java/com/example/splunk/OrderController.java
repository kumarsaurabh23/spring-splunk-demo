package com.example.splunk;

import com.example.splunk.dto.Order;
import com.example.splunk.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) throws JsonProcessingException {
        return orderService.addOrder(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders() throws JsonProcessingException {
        return orderService.getOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrder(@PathVariable int id) throws JsonProcessingException {
        return orderService.getOrder(id);
    }
}
