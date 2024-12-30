package com.logistics.logisticsLab.service.fuelCalculation;


public interface IFuelService {
    public  double getFuelPrice(String city, String id);
    double getCostToCompany(Double dist,String id, String city);
    double refuelling(double price, String id, String city, double dist);

    void updateBalance(String id, double dist);
    void updateTripNum(String id, long num);
}

