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
    @OneToMany(targetEntity = Application.class)
    private Set<Application> applications;
    @Enumerated(EnumType.STRING)
    private SupportScope supportScope;
    private boolean isKnowledgeBaseIncluded;
    private boolean isArticleSuggesterIncluded;
    private boolean isEmailSupportIncluded;
    private boolean isPhoneSupportIncluded;
    private boolean isChatSupportIncluded;
}
