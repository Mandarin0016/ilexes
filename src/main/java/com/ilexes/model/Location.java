package com.ilexes.model;

import com.ilexes.model.enums.Continent;
import com.ilexes.model.enums.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@NoArgsConstructor
@EnableJpaAuditing
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Min(4)
    @Max(30)
    private String address;
    @Min(4)
    @Max(30)
    @Column(nullable = false)
    private String country;
    @Min(4)
    @Max(30)
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Continent continent;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Region region;
}
