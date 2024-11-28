package com.logistics.logisticsLab.dto.itemEvaluation;
import com.logistics.logisticsLab.model.itemEvaluation.Item;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResquestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private Double totalAmount;

    private String status; // Example: "Pending", "Shipped", "Delivered"

    @ElementCollection
    private List<Item> items;

    private String paymentMethod;

    private String shippingAddress;

    private String billingAddress;

}
