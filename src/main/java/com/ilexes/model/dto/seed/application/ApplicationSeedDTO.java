package com.ilexes.model.dto.seed.application;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class ApplicationSeedDTO {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 20)
    private String description;
    @NotNull
    @URL
    private String photoUrl;
    @NotNull
    @URL
    private String website;
}
