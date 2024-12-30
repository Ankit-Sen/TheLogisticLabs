package com.logistics.logisticsLab.dto.priceEstimate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEstimateRequest {
    @NotNull(message = "Item Name cannot be null")
    private String itemName;
    @Size(min = 2, max = 40, message = "Height must be between 2 - 40 cm")
    private Double height;//20 CM
    @Size(min = 2, max = 20, message = "Length must be between 2 - 26 cm")
    private Double length;//14 CM
    @Size(min = 2, max = 20, message = "Width must be between 2 - 26 cm")
    private Double width;//14 CM
    @Size(min = 1, max = 10, message = "Weight must be between 1 - 10 cm")
    private Double weight;//1000 G          // Weight of the item in kg
    @NotBlank
    private String  itemType;// Glass
    private Boolean fragile;// If given by user then take that only otherwise call a isFragile function
    @NotNull(message = "Source Address cannot be null")
    private String sourceAddress;   // Source address
    @NotNull(message = "Source Code cannot be null")
    private Integer sourceCode;
    @NotNull(message = "Destination Address cannot be null")
    private String destinationAddress; // Destination address
    @NotNull(message = "Destination Code cannot be null")
    private Integer destinationCode;
    private String deliveryType;    // Delivery type (e.g., "Standard", "Express")
    private String message;// Delivery instruction
//    private Integer inventoryCost;
}

//There was also a box outside this Dimension would be Around 14 CM × 14 CM × 20 CM With box,
// weight will be around 1 kg But honey net weight is 530 gm