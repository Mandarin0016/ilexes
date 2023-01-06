package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.application.ApplicationExposeDTO;
import com.ilexes.model.dto.seed.application.ApplicationSeedDTO;
import com.ilexes.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public Collection<ApplicationExposeDTO> findAll() {
        return null;
    }

    @Override
    public ApplicationExposeDTO findById(Long id) {
        return null;
    }


    @Override
    public ApplicationExposeDTO update(ApplicationSeedDTO applicationSeedDTO, Long id) {
        return null;
    }

    @Override
    public ApplicationExposeDTO create(ApplicationSeedDTO applicationSeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
