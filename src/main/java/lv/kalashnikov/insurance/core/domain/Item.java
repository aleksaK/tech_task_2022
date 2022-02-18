package lv.kalashnikov.insurance.core.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Item {

    @NotBlank(message = "Name is required")
    final private String name;

    @Min(value = 1, message = "Minimum item insurable amount is 1.00")
    final private double insuranceAmount;

    @NotNull
    final private RiskType type;

}