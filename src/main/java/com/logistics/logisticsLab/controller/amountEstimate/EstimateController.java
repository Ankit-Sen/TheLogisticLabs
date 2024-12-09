package com.logistics.logisticsLab.controller.amountEstimate;

import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateRequest;
import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateResponse;
import com.logistics.logisticsLab.service.priceEstimate.IEstimateAmountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/api/estimate")
public class EstimateController {

    @Autowired
    private IEstimateAmountService estimateService;

    // Endpoint to calculate price estimate for a given item
    @GetMapping
    public ResponseEntity<PriceEstimateResponse> getPriceEstimate(@RequestBody PriceEstimateRequest estimateRequest) {
        try {
            log.info("Received price estimate request for item: {}", estimateRequest);

            // Call the service to calculate the price estimate
            PriceEstimateResponse estimateResponse = estimateService.calculatePriceEstimate(estimateRequest);

            log.info("Price estimate calculated: {}", estimateResponse);
            return ResponseEntity.ok(estimateResponse);
        } catch (IllegalArgumentException ex) {
            log.error("Invalid request: {}", ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("Error calculating price estimate: {}", ex.getMessage(), ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
