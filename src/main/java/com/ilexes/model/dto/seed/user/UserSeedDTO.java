package com.ilexes.model.dto.seed.user;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class UserSeedDTO {
    @Min(2)
    @Max(25)
    private String firstName;
    @Min(2)
    @Max(25)
    private String lastName;
    @Email
    private String email;
    @Pattern(regexp = "")
    private String password;
    @URL
    private String photoUrl;
    private String phoneNumber;
    private String companyName;
}
