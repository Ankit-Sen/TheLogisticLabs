package com.logistics.logisticsLab.service.itemEvaluation;

import com.logistics.logisticsLab.dto.itemEvaluation.OrderRequest;
import com.logistics.logisticsLab.model.itemEvaluation.Order;
import com.logistics.logisticsLab.model.itemEvaluation.Status;
import com.logistics.logisticsLab.repository.itemEvaluation.IOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private FinalAmountService finalAmountService;


    @Override
    public Order createOrder(OrderRequest order) {
        // Save the order to the database
        Order newOrder = new Order();
        newOrder.setCustomerName(order.getCustomerName()); 
        newOrder.setPaymentMethod(order.getPaymentMethod());
        newOrder.setOrderDate(order.getOrderDate());
        newOrder.setDeliveryDate(order.getDeliveryDate());
        newOrder.setItem(order.getItem());
        newOrder.setSourceAddress(order.getShippingAddress());
        newOrder.setBillingAddress(order.getBillingAddress());
        newOrder.setStatus(Status.PENDING);
        newOrder.setTotalAmount(finalAmountService.calculateFinalAmount());

        return orderRepository.save(newOrder);
    }

    @Override
    public Order getOrderById(Long id) {
        // Find the order by ID and return it, or throw an exception if not found
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public List<Order> getAllOrders() {
        // Retrieve and return all orders
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order orderDetails) {
        // Find the existing order
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        // Update fields
        existingOrder.setCustomerName(orderDetails.getCustomerName());
        existingOrder.setDeliveryDate(orderDetails.getDeliveryDate());
        existingOrder.setTotalAmount(orderDetails.getTotalAmount());
        existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setPaymentMethod(orderDetails.getPaymentMethod());
        existingOrder.setDestinationAddress(orderDetails.getDestinationAddress());
        existingOrder.setSourceAddress(orderDetails.getSourceAddress());
        existingOrder.setBillingAddress(orderDetails.getBillingAddress());

        // Save and return the updated order
        return orderRepository.save(existingOrder);
    }

    @Override
    public boolean deleteOrder(Long id) {
        // Check if the order exists
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Order not found with id: " + id);
        }
    }
}
