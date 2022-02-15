package lv.kalashnikov.insurance.web;

import lv.kalashnikov.insurance.core.domain.Policy;
import lv.kalashnikov.insurance.core.services.PremiumCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    final private PremiumCalculator calculator;

    @Autowired
    public CalculatorController(PremiumCalculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping(path = "/calculator/",
            consumes = "application/json",
            produces = "application/json")
    public double calculatePremium(@RequestBody Policy policy) {
        return calculator.calculate(policy);
    }

}