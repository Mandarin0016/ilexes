package com.ilexes.repository;

import com.ilexes.model.entity.BillingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingPlanRepository extends JpaRepository<BillingPlan, Long> {

    @Query(value = """
            DELETE FROM billing_plans_applications
            WHERE plan_id = :id
            """, nativeQuery = true)
    @Modifying
    void detachRelationBillingPlanApplications(@Param("id") Long id);

    @Query(value = """
            UPDATE companies
            SET billing_plan_id = null
            WHERE billing_plan_id = :id
            """, nativeQuery = true)
    @Modifying
    void detachRelationCompanies(@Param("id") Long id);
}
