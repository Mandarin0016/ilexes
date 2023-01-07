package com.ilexes.model.dto.seed.application;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Size;
@Data
public class ApplicationSeedDTO {
    @Size(min = 2, max = 30)
    private String name;
    @Size(min = 20)
    private String description;
    @URL
    private String photoUrl;
    @URL
    private String website;
}
