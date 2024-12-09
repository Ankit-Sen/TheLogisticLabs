package com.logistics.logisticsLab.repository.fuelCalculation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.logisticsLab.model.fuelCalculation.Diesel;



@Repository
public interface DieselRepository extends JpaRepository<Diesel, String> {
}
