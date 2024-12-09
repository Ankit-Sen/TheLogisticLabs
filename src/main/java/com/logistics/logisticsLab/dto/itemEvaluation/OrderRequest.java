package com.logistics.logisticsLab.dto.itemEvaluation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String customerName;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status; // Example: "Pending", "Shipped", "Delivered"
    private Long item;
    private String paymentMethod;
    private String sourceAddress;
    private String shippingAddress;
    private String billingAddress;

}
