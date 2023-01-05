package com.ilexes.service;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;

import java.util.Collection;

public interface ApplicationService {
    Collection<ApplicationExposeDTO> findAll();
    ApplicationExposeDTO findById(Long id);
    ApplicationExposeDTO findByName(String name);
    ApplicationExposeDTO update(ApplicationSeedDTO applicationSeedDTO);
    ApplicationExposeDTO create(ApplicationSeedDTO applicationSeedDTO);
    void deleteById(Long id);

}
