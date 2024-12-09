package com.logistics.logisticsLab.model.itemEvaluation;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Double totalAmount;
    private Status status; // Example: "Pending", "Shipped", "Delivered"
    private Long item;
    private Long invoiceNumber;
    private String paymentMethod;
    private String sourceAddress;
    private String destinationAddress;
    private String billingAddress;
}
