
package com.logistics.logisticsLab.model.fuelCalculation;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Diesel_Prices")
public class Diesel {
    @Id
    private String city;
    private double price;
}
