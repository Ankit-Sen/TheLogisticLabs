package com.logistics.logisticsLab.service.itemEvaluation;

import com.logistics.logisticsLab.controller.itemEvaluation.Order;

import java.util.List;

public class OrderService implements IOrderService{
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public Order updateOrder(Long id, Order orderDetails) {
        return null;
    }

    @Override
    public boolean deleteOrder(Long id) {
        return false;
    }
}
