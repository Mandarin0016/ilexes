package com.ilexes.model.dto.seed.billingPlan;

import com.ilexes.model.enums.Currency;
import com.ilexes.model.enums.SupportScope;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class BillingPlanSeedDTO {
    @Size(min = 2, max = 20)
    @NotNull
    private String name;
    @Size(min = 10)
    @NotNull
    private String description;
    @NotNull
    private Currency currency;
    @Positive
    @NotNull
    private BigDecimal price;
    @NotNull
    private SupportScope supportScope;
    @NotNull
    private Boolean isKnowledgeBaseIncluded;
    @NotNull
    private Boolean isArticleSuggesterIncluded;
    @NotNull
    private Boolean isEmailSupportIncluded;
    @NotNull
    private Boolean isPhoneSupportIncluded;
    @NotNull
    private Boolean isChatSupportIncluded;

}
