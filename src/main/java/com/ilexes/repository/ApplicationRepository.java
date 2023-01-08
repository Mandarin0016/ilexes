package com.ilexes.repository;

import com.ilexes.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Collection<Application> findAllByNameIn(Collection<String> name);
}
