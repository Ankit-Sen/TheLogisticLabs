package com.logistics.logisticsLab.dto.itemEvaluation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {
    private String name;
    private String  itemType;
    private Double height;
    private Double length;
    private Double width;
    private Double weight;

}
