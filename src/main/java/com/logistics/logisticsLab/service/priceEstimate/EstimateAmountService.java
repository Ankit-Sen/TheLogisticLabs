package com.logistics.logisticsLab.service.priceEstimate;

import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateRequest;
import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateResponse;
import com.logistics.logisticsLab.service.GenericAppEntity;
import com.logistics.logisticsLab.service.fuelCalculation.IFuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimateAmountService implements IEstimateAmountService{

    @Autowired
    GenericAppEntity genericAppEntity;
    @Autowired
    IFuelService fuelService;

    public PriceEstimateResponse calculatePriceEstimate(PriceEstimateRequest request) {
        // Required fields to calculate price
        double basePrice = 50; // Base price for delivery
        double weightFactorInKg = 10; // Price per kg
        double weightFactorInG = weightFactorInKg/1000;
        double platformPrice = 5;
        double distanceFactor = calculateDistanceFactor(request.getSourceCode(), request.getDestinationCode());
        double deliveryTypeMultiplier = "Express".equalsIgnoreCase(request.getDeliveryType()) ? 1.5 : 1.0;
        double fragileAmount = calculateFragileValue(request.getItemType());
        double estimatedPrice = (basePrice + platformPrice + (request.getWeight() * weightFactorInG) + distanceFactor) * deliveryTypeMultiplier+fragileAmount;

        return   PriceEstimateResponse.builder()
                .itemName(request.getItemName())
                .height(request.getHeight())
                .length(request.getLength())
                .width(request.getWidth())
                .weight(request.getWeight())
                .itemType(request.getItemType())
                .fragile(request.getFragile())
                .fragileValue(fragileAmount)
                .sourceAddress(request.getSourceAddress())
                .destinationAddress(request.getDestinationAddress())
                .message(request.getMessage())
                .estimatedPrice(estimatedPrice)
                .deliveryType(request.getDeliveryType())
                .build();
    }

    private double calculateDistanceFactor(Integer sourceCode, Integer destinationCode) {
        Double distance = genericAppEntity.getDistance(sourceCode, destinationCode);
//        Double cost=fuelService.getCostToCompany(distance,"Class1","Kolkata");
        return getPerKmCost()*distance; // Assume a fixed distance factor for simplicity
    }

    private double calculateFragileValue(String itemType){
        if(itemType.equalsIgnoreCase("Glass"))
            return 20.0;
        else if (itemType.equalsIgnoreCase("Ceramic")) {
            return 10.0;
        }else{
            return 0.0;
        }
    }

    private double getPerKmCost(){
        return 2.0;//To get the Cost per KM
    }
}

