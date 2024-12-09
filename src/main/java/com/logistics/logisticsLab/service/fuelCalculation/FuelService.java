package com.logistics.logisticsLab.service.fuelCalculation;

import com.logistics.logisticsLab.service.GenericAppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.logisticsLab.repository.fuelCalculation.RiderInfoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FuelService implements IFuelService {
    private static Logger logger = LoggerFactory.getLogger(GenericAppEntity.class);
    @Autowired
    GenericAppEntity genericAppEntity;
    @Autowired
    RiderInfoRepository repo;
    public double getFuelPrice(String city,String id) {
        //returns the real time fuel price of our rider
        double fuelPrice=0.0;
        //double costToComp;

        if(genericAppEntity.findFuelId(genericAppEntity.getRiderFuelType(id))=="1")
        {
            fuelPrice=genericAppEntity.getPetrolPrice(city.toLowerCase());
        }
        else if (genericAppEntity.findFuelId(genericAppEntity.getRiderFuelType(id))=="2")
        {
            fuelPrice=genericAppEntity.getDieselPrice(city.toLowerCase());
        }

        return fuelPrice;

    }
    @Override
    public double getCostToCompany(double dist,String id, String city) {
        // returns the total fuel price charged for a certain distance
        return (getFuelPrice(city,id)/genericAppEntity.getMileage(id))*(dist+10);

    }

    @Override
    public double refuelling(double price, String id, String city, double dist) {
        // returns distance that can be travelled after the refuelling
        double balance=genericAppEntity.getBalance(id);
        double newBalance= getCostToCompany(dist,id,city)-balance;
        updateBalance(id, newBalance);
        return newBalance;
    }
    @Override
    public void updateBalance(String id, double price) {
        repo.updateBalance(id, price);
    }
    @Override
    public void updateTripNum(String id, long num)
    {
        repo.updateTripNum(id, num);

    }

}
