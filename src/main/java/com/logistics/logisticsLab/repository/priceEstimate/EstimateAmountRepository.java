package com.logistics.logisticsLab.repository.priceEstimate;

import org.springframework.stereotype.Repository;

@Repository
public class EstimateAmountRepository {

    private Double maxLength;
    private Double maxWidth;
    private Double maxHeight;
    private Double basePrice;
    private Double platformPrice;

    public EstimateAmountRepository(){
        this.maxLength=15.0;
        this.maxWidth=15.0;
        this.maxHeight=20.0;
        this.basePrice=118.0;
        this.platformPrice=3.0;
    }

    public Double getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Double maxLength) {
        this.maxLength = maxLength;
    }

    public Double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getPlatformPrice() {
        return platformPrice;
    }

    public void setPlatformPrice(Double platformPrice) {
        this.platformPrice = platformPrice;
    }

}
