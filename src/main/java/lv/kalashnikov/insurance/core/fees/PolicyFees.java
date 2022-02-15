package lv.kalashnikov.insurance.core.fees;

import lv.kalashnikov.insurance.core.domain.RiskType;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.function.Predicate;

@Component
public class PolicyFees {

    private final Map<Predicate<Map.Entry<RiskType, Double>>, Double> fees = Map.ofEntries(
            Map.entry(entry -> entry.getKey().equals(RiskType.FIRE) && entry.getValue() > 100,
                    0.024),
            Map.entry(entry -> entry.getKey().equals(RiskType.FIRE) && entry.getValue() <= 100,
                    0.014),
            Map.entry(entry -> entry.getKey().equals(RiskType.THEFT) && entry.getValue() >= 15,
                    0.05),
            Map.entry(entry -> entry.getKey().equals(RiskType.THEFT) && entry.getValue() < 15,
                    0.11)
    );

    public Map<Predicate<Map.Entry<RiskType, Double>>, Double> getFees() {
        return fees;
    }

}