package com.ilexes.model.dto.expose.billingPlan;

import com.ilexes.model.enums.Currency;
import com.ilexes.model.enums.SupportScope;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillingPlanExposeDTO {
    private Long id;
    private String name;
    private String description;
    private Currency currency;
    private BigDecimal price;
    private SupportScope supportScope;
    private boolean isKnowledgeBaseIncluded;
    private boolean isArticleSuggesterIncluded;
    private boolean isEmailSupportIncluded;
    private boolean isPhoneSupportIncluded;
    private boolean isChatSupportIncluded;
}
