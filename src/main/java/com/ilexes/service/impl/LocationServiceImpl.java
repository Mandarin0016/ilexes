package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.location.LocationExposeDTO;
import com.ilexes.model.dto.seed.location.LocationSeedDTO;
import com.ilexes.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocationServiceImpl implements LocationService {
    @Override
    public LocationExposeDTO create(LocationSeedDTO locationSeedDTO) {
        return null;
    }

    @Override
    public LocationExposeDTO update(LocationSeedDTO locationSeedDTO, Long id) {
        return null;
    }

    @Override
    public Collection<LocationExposeDTO> findAll() {
        return null;
    }

    @Override
    public LocationExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
