package com.logistics.logisticsLab.service.priceEstimate;

import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateRequest;
import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateResponse;
import com.logistics.logisticsLab.repository.priceEstimate.EstimateAmountRepository;
import com.logistics.logisticsLab.service.GenericAppEntity;
import com.logistics.logisticsLab.service.fuelCalculation.IFuelService;
import com.logistics.logisticsLab.service.fuelCalculation.IRiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimateAmountService implements IEstimateAmountService{

    @Autowired
    GenericAppEntity genericAppEntity;
    @Autowired
    IFuelService fuelService;
    @Autowired
    EstimateAmountRepository estimateAmountRepository;
    @Autowired
    IRiderService riderService;

    public PriceEstimateResponse calculatePriceEstimate(PriceEstimateRequest request) {
        // Required fields to calculate price
        Double basePrice = getBasePrice(); // Base price for delivery
        Double weightBasedPricing = getWeightBasedPricing(request.getWeight()); // Price per kg
//        Double platformPrice = getPlatformPrice();
        Double dimensionBasedPrice = getLengthBasedPricing(request.getLength())+getWidthBasedPricing(request.getWidth())+getHeightBasedPricing(request.getHeight());
        Double distanceBasedPricing = calculateDistancebasedPricing(request.getSourceCode(), request.getDestinationCode());
        double deliveryTypeMultiplier = "Express".equalsIgnoreCase(request.getDeliveryType()) ? 1.5 : 1.0;
        Double fragileAmount = calculateFragileValue(request.getItemType());
        Double estimatedPrice = (basePrice + dimensionBasedPrice + weightBasedPricing + distanceBasedPricing) * deliveryTypeMultiplier;
//        +fragileAmount+platformPrice

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
                .openBoxCharges(30.0)//Provided details for open box delivery
                .costToCompany(distanceBasedPricing)
                .build();
    }

    private Double getLengthBasedPricing(Double length) {
        Double getMaximumLengthPermeableLimit = estimateAmountRepository.getMaxLength();
        if(length <= getMaximumLengthPermeableLimit){
            return 0.0;
        }else{
            return (length- getMaximumLengthPermeableLimit/4)*10.0;
        }
    }

    private void setMaximumLengthPermeableLimit(Double length) {
        estimateAmountRepository.setMaxLength(length);
    }

    private Double getWidthBasedPricing(Double length) {
        Double getMaximumWidthPermeableLimit = estimateAmountRepository.getMaxWidth();
        if(length < getMaximumWidthPermeableLimit){
            return 0.0;
        }else{
            return (length- getMaximumWidthPermeableLimit/4)*10.0;
        }
    }

    private void setMaximumWidthPermeableLimit(Double width) {
        estimateAmountRepository.setMaxWidth(width);
    }


    private Double getPlatformPrice() {
        return estimateAmountRepository.getPlatformPrice();
    }

    private Double getHeightBasedPricing(Double length) {
        Double getMaximumHeightPermeableLimit = estimateAmountRepository.getMaxHeight();
        if(length <= getMaximumHeightPermeableLimit){
            return 0.0;
        }else{
            return (length- getMaximumHeightPermeableLimit/10)*30.0;
        }
    }

    private void getMaximumHeightPermeableLimit(Double Height) {
        estimateAmountRepository.setMaxHeight(Height);
    }


    private Double getWeightBasedPricing(Double weight) {
        return weight < 3.0 ? 0.0 : Math.ceil(((Math.ceil(weight / 0.5) * 0.5)-3.0)/.5)*10;
    }

    private Double calculateDistancebasedPricing(Integer sourceCode, Integer destinationCode) {
        String riderId = riderService.filterRider(genericAppEntity.getRiderPool());
        Double distance = genericAppEntity.getDistance(sourceCode, destinationCode);
        double cost = fuelService.getCostToCompany(distance,riderId,"Kolkata");
        fuelService.updateBalance(riderId,cost);
        return cost;
//        if(distance < 7)
//            return 0.0;
//        else if(distance < 15){
//            return fuelService.getCostToCompany(distance,riderId,"Kolkata")-fuelService.getCostToCompany(distance-7,riderId,"Kolkata");
//        }
//        else
//            return fuelService.getCostToCompany(distance,riderId,"Kolkata")-fuelService.getCostToCompany(distance-15,riderId,"Kolkata");
//        return getPerKmCost()*distance; // Assume a fixed distance factor for simplicity
    }

    private double calculateFragileValue(String itemType){
        if((itemType.equalsIgnoreCase("Glass")) || (itemType.equalsIgnoreCase("Ceramic")))
            return 10.0;
        else if (itemType.equalsIgnoreCase("Marble")) {
            return 15.0;
        }else{
            return 0.0;
        }
    }

    private double getPerKmCost(){
        return genericAppEntity.getDistance(0,0)/ genericAppEntity.getMileage("test");
//        return 2.0;//To get the Cost per KM
    }

    private Double getBasePrice(){
        return estimateAmountRepository.getBasePrice();
    }
}

