package com.ilexes.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilexes.model.enums.AccountStatus;
import com.ilexes.model.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EnableJpaAuditing
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Min(2)
    @Max(25)
    private String firstName;
    @Min(2)
    @Max(25)
    private String lastName;
    @Email
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @URL
    private String photoUrl;
    private String phoneNumber;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @ManyToOne(targetEntity = Company.class)
    private Company company;
    @ManyToOne(targetEntity = Location.class)
    private Location location;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime lastModified;
}
