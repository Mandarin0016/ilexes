package com.ilexes.model;

import com.ilexes.model.enums.SupportScope;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "billing_plans")
public class BillingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private BigDecimal price;
    @ManyToMany(targetEntity = Application.class)
    @JoinTable(
            name = "billing_plans_applications",
            joinColumns = @JoinColumn(name = "plan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "application_id", referencedColumnName = "id"))
    private Set<Application> applicationsIncluded;
    @Enumerated(EnumType.STRING)
    private SupportScope supportScope;
    private boolean isKnowledgeBaseIncluded;
    private boolean isArticleSuggesterIncluded;
    private boolean isEmailSupportIncluded;
    private boolean isPhoneSupportIncluded;
    private boolean isChatSupportIncluded;
}
