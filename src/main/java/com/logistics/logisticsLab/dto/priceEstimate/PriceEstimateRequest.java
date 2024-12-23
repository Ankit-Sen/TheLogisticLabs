package com.logistics.logisticsLab.dto.priceEstimate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEstimateRequest {
    private String itemName;
    private Double height;//20 CM
    private Double length;//14 CM
    private Double width;//14 CM
    private Double weight;//1000 G          // Weight of the item in kg
    private String  itemType;// Glass
    private Boolean fragile;// If given by user then take that only otherwise call a isFragile function
    private String sourceAddress;   // Source address
    private Integer sourceCode;
    private String destinationAddress; // Destination address
    private Integer destinationCode;
    private String deliveryType;    // Delivery type (e.g., "Standard", "Express")
    private String message;// Delivery instruction
//    private Integer inventoryCost;
}

//There was also a box outside this Dimension would be Around 14 CM × 14 CM × 20 CM With box,
// weight will be around 1 kg But honey net weight is 530 gm