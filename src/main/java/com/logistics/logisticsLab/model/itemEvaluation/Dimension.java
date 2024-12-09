package com.logistics.logisticsLab.model.itemEvaluation;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Dimension {
    // private Height height;
    private Double height;
    private Double length;
    private Double width;
    private Double weight;

    public Double getVolume(){
        return height * length * width;
    }
}
