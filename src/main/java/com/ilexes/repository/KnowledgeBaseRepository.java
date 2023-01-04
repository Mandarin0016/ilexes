package com.ilexes.repository;

import com.ilexes.model.entity.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeBaseRepository extends JpaRepository <KnowledgeBase, Long> {
}
