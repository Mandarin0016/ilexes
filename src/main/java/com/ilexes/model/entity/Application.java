package com.ilexes.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@NoArgsConstructor
@EnableJpaAuditing
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Min(2)
    @Column(nullable = false, columnDefinition = "VARCHAR(50)", unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @URL
    private String photoUrl;
    @URL
    private String website;
}
