package com.logistics.logisticsLab.model.fuelCalculation;

import jakarta.persistence.Column;
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
@Table(name = "Rider_Details")
public class RiderInfo {
    @Id
    @Column(name="Rider_ID")
    private String id;
    @Column(name="Rider_Name")
    private String Name;
    private String Category;
    private double mileage;
    private double distTravelled;
    private String vehicle;
    private String fuel_Type;
    private double totKWH;
    private double balance;
    private String order_Status;
    private String riderStatus;
    private long tripNum;
    private String lastAddress;
    private boolean onLease;

}
