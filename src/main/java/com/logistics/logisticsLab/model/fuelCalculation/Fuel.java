package com.logistics.logisticsLab.model.fuelCalculation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fuel {
    @Id
    private String fuel_ID;
    private String fuel_desc;

}
