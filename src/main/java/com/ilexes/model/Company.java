package com.ilexes.model;

import com.ilexes.model.enums.CompanyType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String information;
    @URL
    private String companyWebsite;
    @ManyToOne(targetEntity = Location.class)
    private Location location;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyType companyType;
    @OneToMany(mappedBy = "company", targetEntity = User.class)
    private Set<User> employees = new HashSet<>();
    @JoinColumn(nullable = false)
    @ManyToOne(targetEntity = BillingPlan.class)
    private BillingPlan billingPlan;
}
