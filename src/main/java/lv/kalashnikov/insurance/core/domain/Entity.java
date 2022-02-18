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
public class Entity {

    @NotBlank(message = "Name is required")
    final private String name;

    @Size(min = 1, message = "At least one item is required")
    final private List<@Valid Item> items;

}