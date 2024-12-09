package com.logistics.logisticsLab.dto.priceEstimate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PriceEstimateResponse {
    private String itemName;
    private Double height;//20 CM
    private Double length;//14 CM
    private Double width;//14 CM
    private Double weight;//1000 G          // Weight of the item in kg
    private String  itemType;// Glass
    private Boolean fragile;// If given by user then take that only otherwise call a isFragile function
    private Double fragileValue;// Amount depending on the product type
    private String sourceAddress;   // Source address
    private String destinationAddress; // Destination address
    private String message;         // Any additional message for the user
    private Double estimatedPrice;  // Estimated delivery price
    private String deliveryType;    // Delivery type (e.g., "Standard", "Express")

    public Boolean getFragile() {
        if (fragile == null) {
            return isFragile(itemType);
        }
        return fragile;
    }

    private static boolean isFragile(String itemType) {
        return "Glass".equalsIgnoreCase(itemType) || "Ceramic".equalsIgnoreCase(itemType);
    }
}

