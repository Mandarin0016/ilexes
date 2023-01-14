package com.ilexes.model.dto.seed.location;
import com.ilexes.model.enums.Continent;
import com.ilexes.model.enums.Region;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class LocationSeedDTO {
    @Size(min = 4, max = 30)
    @NotBlank
    private String address;
    @Size(min = 4, max = 30)
    @NotBlank
    private String country;
    @Size(min = 4, max = 30)
    @NotBlank
    private String city;
    @NotNull
    private Continent continent;
    @NotNull
    private Region region;
}
