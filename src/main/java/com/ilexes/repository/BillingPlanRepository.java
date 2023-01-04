package com.ilexes.repository;

import com.ilexes.model.entity.BillingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingPlanRepository extends JpaRepository <BillingPlan, Long> {
}
