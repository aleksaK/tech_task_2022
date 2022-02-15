package lv.kalashnikov.insurance.core.fees;

import lv.kalashnikov.insurance.core.domain.RiskType;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.Map.*;

@Component
public class PolicyFees {

    private final Map<Predicate<Entry<RiskType, Double>>, Double> fees = ofEntries(
            entry(entry -> entry.getKey().equals(RiskType.FIRE) && entry.getValue() > 100,
                    0.024),
            entry(entry -> entry.getKey().equals(RiskType.FIRE) && entry.getValue() <= 100,
                    0.014),
            entry(entry -> entry.getKey().equals(RiskType.THEFT) && entry.getValue() >= 15,
                    0.05),
            entry(entry -> entry.getKey().equals(RiskType.THEFT) && entry.getValue() < 15,
                    0.11)
    );

    public Map<Predicate<Entry<RiskType, Double>>, Double> getFees() {
        return fees;
    }

}