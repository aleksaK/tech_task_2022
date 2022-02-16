package lv.kalashnikov.insurance.core.services;

import lv.kalashnikov.insurance.core.domain.Item;
import lv.kalashnikov.insurance.core.domain.Policy;
import lv.kalashnikov.insurance.core.domain.RiskType;
import lv.kalashnikov.insurance.core.fees.PolicyFees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

@Service
public class PremiumCalculator {

    final private PolicyFees fees;

    @Autowired
    public PremiumCalculator(PolicyFees fees) {
        this.fees = fees;
    }

    public double calculate(Policy policy) {
        Map<RiskType, Double> totalAmountByType = getTotalAmountByType(policy);
        double finalPremium = totalAmountByType.entrySet().stream()
                .map(this::getSingleRiskTypePremium)
                .reduce(.0, Double::sum);
        return Math.round(finalPremium * 100.) / 100.;
    }

    private Map<RiskType, Double> getTotalAmountByType(Policy policy) {
        return policy.getEntities().stream()
                .map(entity -> entity.getItems().stream()
                        .collect(groupingBy(Item::getType, summingDouble(Item::getInsuranceAmount))))
                .flatMap(map -> map.entrySet().stream())
                .collect(toMap(Entry::getKey, Entry::getValue, Double::sum));
    }

    private double getSingleRiskTypePremium(Entry<RiskType, Double> entry) {
        return fees.getFees().entrySet().stream()
                .filter(feesEntry -> feesEntry.getKey().test(entry))
                .map(feesEntry -> feesEntry.getValue() * entry.getValue())
                .findAny().orElseThrow();
    }

}