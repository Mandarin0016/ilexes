package com.ilexes.repository;

import com.ilexes.model.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository <Agent, Long> {
}
