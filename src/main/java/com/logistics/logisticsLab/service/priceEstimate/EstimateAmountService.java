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
        Double basePrice = getBasePrice(); // Base price for delivery
        Double weightFactorInKg = getWeightFactorInKg(); // Price per kg
        Double weightFactorInG = weightFactorInKg/1000;
        Double platformPrice = getPlatformPrice();
        Double dimensionBasedPrice = getLengthBasedPricing(request.getLength())+getWidthBasedPricing(request.getWidth())+getHeightBasedPricing(request.getHeight());
        Double distanceFactor = calculateDistanceFactor(request.getSourceCode(), request.getDestinationCode());
        Double deliveryTypeMultiplier = "Express".equalsIgnoreCase(request.getDeliveryType()) ? 1.5 : 1.0;
        Double fragileAmount = calculateFragileValue(request.getItemType());
        Double estimatedPrice = (basePrice + dimensionBasedPrice    + platformPrice + (request.getWeight() * weightFactorInG) + distanceFactor) * deliveryTypeMultiplier+fragileAmount;

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

    private Double getLengthBasedPricing(Double length) {
        if(length < getMaximumLengthPermeableLimit()){
            return 0.0;
        }else{
            return (length- getMaximumLengthPermeableLimit()/4)*10.0;
        }
    }

    private Double getMaximumLengthPermeableLimit() {
        return 15.0;
    }

    private Double getWidthBasedPricing(Double length) {
        if(length < getMaximumWidthPermeableLimit()){
            return 0.0;
        }else{
            return (length- getMaximumWidthPermeableLimit()/4)*10.0;
        }
    }

    private Double getMaximumWidthPermeableLimit() {
        return 15.0;
    }


    private Double getPlatformPrice() {
        return 3.0;
    }

    private Double getHeightBasedPricing(Double length) {
        if(length < getMaximumHeightPermeableLimit()){
            return 0.0;
        }else{
            return (length- getMaximumHeightPermeableLimit()/10)*30.0;
        }
    }

    private Double getMaximumHeightPermeableLimit() {
        return 20.0;
    }


    private Double getWeightFactorInKg() {
        return 150.0;
    }

    private double calculateDistanceFactor(Integer sourceCode, Integer destinationCode) {
        Double distance = genericAppEntity.getDistance(sourceCode, destinationCode);
        Double cost=fuelService.getCostToCompany(distance,"1","Kolkata");
        return getPerKmCost()*distance; // Assume a fixed distance factor for simplicity
    }

    private double calculateFragileValue(String itemType){
        if(itemType.equalsIgnoreCase("Glass"))
            return 5.0;
        else if (itemType.equalsIgnoreCase("Ceramic")) {
            return 10.0;
        }else{
            return 0.0;
        }
    }

    private double getPerKmCost(){
        return genericAppEntity.getDistance(0,0)/ genericAppEntity.getMileage("test");
//        return 2.0;//To get the Cost per KM
    }

    private Double getBasePrice(){
        return 118.0;
    }
}

