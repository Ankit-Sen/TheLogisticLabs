package com.logistics.logisticsLab.service.itemEvaluation;

import com.logistics.logisticsLab.dto.itemEvaluation.OrderRequest;
import com.logistics.logisticsLab.model.itemEvaluation.Order;
import java.util.List;

public interface IOrderService {
    Order createOrder(OrderRequest order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Long id, Order orderDetails);
    boolean deleteOrder(Long id);
}
