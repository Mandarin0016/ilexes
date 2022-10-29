package com.ilexes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SupportReceiver extends Company {
    @OneToMany
    private List<Customer> customers = new ArrayList<>();
    @JoinColumn(nullable = false)
    @ManyToOne(targetEntity = BillingPlan.class)
    private BillingPlan billingPlan;
}
