package com.logistics.logisticsLab.controller.fuelCalculation;

import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateRequest;
import com.logistics.logisticsLab.dto.priceEstimate.PriceEstimateResponse;
import com.logistics.logisticsLab.service.fuelCalculation.IFuelService;
import com.logistics.logisticsLab.service.priceEstimate.IEstimateAmountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/api/price")
public class FuelPricingController {

    @Autowired
    private IFuelService fuelService;

    // Endpoint to calculate price estimate for a given item
    @GetMapping
    public ResponseEntity<Double> getPriceEstimate(@RequestParam(name = "dist") double dist,
                                                   @RequestParam(name = "id") String id,
                                                   @RequestParam(name = "city", defaultValue = "Kolkata") String city) {
        try {
            log.info("Received price estimate request for item: {}", dist);
            Double costToCompany = fuelService.getCostToCompany(dist,id,city);
            if (dist <= 0.0) {
                return new ResponseEntity<>(costToCompany, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (IllegalArgumentException ex) {
            log.error("Invalid request: {}", ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("Error calculating price estimate: {}", ex.getMessage(), ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}