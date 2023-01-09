package com.ilexes.model.dto.expose.location;
import com.ilexes.model.enums.Continent;
import com.ilexes.model.enums.Region;
import lombok.Data;

@Data
public class LocationExposeDTO {
    private Long id;
    private String address;
    private String country;
    private String city;
    private Continent continent;
    private Region region;
}
