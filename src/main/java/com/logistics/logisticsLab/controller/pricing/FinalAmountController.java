package com.logistics.logisticsLab.controller.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.logisticsLab.service.itemEvaluation.FinalAmountService;

@RestController
@RequestMapping("/api/final-amount")
public class FinalAmountController {
    // @Autowired
    // private FinalAmountService finalAmountService;

    // /**
    //  * Endpoint to calculate the final amount for an order.
    //  *
    //  * @param orderId The ID of the order.
    //  * @return The final amount including taxes and discounts.
    //  */
    // @GetMapping("/{orderId}")
    // public ResponseEntity<Double> calculateFinalAmount(@PathVariable Long orderId) {
    //     double finalAmount = finalAmountService.calculateFinalAmount(orderId);
    //     return ResponseEntity.ok(finalAmount);
    // }

    // /**
    //  * Endpoint to apply a discount to an order.
    //  *
    //  * @param orderId The ID of the order.
    //  * @param discountPercentage The percentage of the discount to apply.
    //  * @return The final amount after applying the discount.
    //  */
    // @PostMapping("/{orderId}/apply-discount")
    // public ResponseEntity<Double> applyDiscount(@PathVariable Long orderId, @RequestParam double discountPercentage) {
    //     double discountedAmount = finalAmountService.applyDiscount(orderId, discountPercentage);
    //     return ResponseEntity.ok(discountedAmount);
    // }

    // /**
    //  * Endpoint to update the tax rate for final amount calculation.
    //  *
    //  * @param taxRate The new tax rate as a percentage.
    //  * @return A confirmation message.
    //  */
    // @PutMapping("/update-tax-rate")
    // public ResponseEntity<String> updateTaxRate(@RequestParam double taxRate) {
    //     finalAmountService.updateTaxRate(taxRate);
    //     return ResponseEntity.ok("Tax rate updated to: " + taxRate + "%");
    // }
}
