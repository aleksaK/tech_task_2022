package lv.kalashnikov.insurance.core.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Policy {

    @NotBlank(message = "Policy number is required")
    final private String policyNumber;

    final private boolean isApproved;

    @Size(min = 1, message = "At least one entity is required")
    final private List<@Valid Entity> entities;

}