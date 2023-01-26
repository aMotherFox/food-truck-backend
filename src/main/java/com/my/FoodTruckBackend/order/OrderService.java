package com.my.FoodTruckBackend.order;

import com.my.FoodTruckBackend.appetizer.AppetizerRepository;
import com.my.FoodTruckBackend.entree.Entree;
import com.my.FoodTruckBackend.entree.EntreeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final EntreeRepository entreeRepository;
    private final AppetizerRepository appetizerRepository;
    private final OrderRepository orderRepository;

    public OrderDTO createOrder(NewOrderRequestBody newOrderRequestBody) {
        Order newOrder = orderRepository.createOrder(newOrderRequestBody);
        // need to get entrees and apps by their ID, is it ok to do this in this story??
        return new OrderDTO();
    }
}
