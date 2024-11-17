package com.sayan.microservices.order.controller;

import com.sayan.microservices.order.dto.OrderRequest;
import com.sayan.microservices.order.dto.OrderResponse;
import com.sayan.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        String orderNumber = orderService.placeOrder(orderRequest);
        return "Order " + orderNumber + " placed successfully!";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

}
