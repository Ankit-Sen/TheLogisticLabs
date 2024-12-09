package com.logistics.logisticsLab.service.priceEstimate;

import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateRequest;
import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateResponse;

public interface IEstimateAmountService {
    public PriceEstimateResponse calculatePriceEstimate(PriceEstimateRequest request);
}
