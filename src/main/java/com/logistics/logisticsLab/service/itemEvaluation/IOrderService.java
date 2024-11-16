package com.logistics.logisticsLab.service.itemEvaluation;

import com.logistics.logisticsLab.controller.itemEvaluation.Order;
import java.util.List;

public interface IOrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Long id, Order orderDetails);
    boolean deleteOrder(Long id);
}
