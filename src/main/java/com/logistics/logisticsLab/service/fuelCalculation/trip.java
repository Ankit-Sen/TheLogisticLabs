package com.logistics.logisticsLab.service.fuelCalculation;

import java.util.Scanner;

import com.logistics.logisticsLab.service.GenericAppEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class trip {
    @Autowired
    GenericAppEntity genAppEntity;
    @Autowired
    FuelService fuelService;

    public void CompleteTrip()
    {
        Scanner sc=new Scanner(System.in);
        String id=sc.nextLine();
        boolean tripStatus=false;
        boolean deliveredFlag=false;
        int tripNum=0;
        double balance=0.0;
        double dist=0.0;
        String city="";
        if(genAppEntity.getRiderStatus(id)=="active")
        {
            while(tripStatus==true)
            {
                balance=fuelService.getCostToCompany(dist,id,city);
                fuelService.updateBalance(id,balance+genAppEntity.getBalance(id));
                if(deliveredFlag==true)
                {

                }
            }
            fuelService.updateTripNum(id,tripNum++);
        }
    }
}

