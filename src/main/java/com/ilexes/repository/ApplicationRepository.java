package com.ilexes.repository;

import com.ilexes.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Collection<Application> findAllByNameIn(Collection<String> name);

    Optional<Application> findByName(String name);

    @Query(value = """
            DELETE FROM billing_plans_applications
            WHERE application_id = :id
            """, nativeQuery = true)
    @Modifying
    void detachRelationBillingPlanApplications(@Param("id") Long id);

    @Query(value = """
            UPDATE knowledge_bases
            SET application_name = null
            WHERE application_name = :appName
            """, nativeQuery = true)
    @Modifying
    void detachRelationKnowledgeBases(@Param("appName") String name);

    @Query(value = """
            DELETE FROM support_groups_applications
            WHERE applications_id = :id
            """, nativeQuery = true)
    @Modifying
    void detachRelationSupportGroupApplications(@Param("id") Long id);

    @Query(value = """
            UPDATE tickets
            SET application_name = null
            WHERE application_name = :appName
            """, nativeQuery = true)
    @Modifying
    void detachRelationTickets(@Param("appName") String name);
}
