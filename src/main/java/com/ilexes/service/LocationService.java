package com.ilexes.service;

import com.ilexes.model.dto.expose.location.LocationExposeDTO;
import com.ilexes.model.dto.seed.location.LocationSeedDTO;

import java.util.Collection;

public interface LocationService {
    LocationExposeDTO create(LocationSeedDTO locationSeedDTO);
    LocationExposeDTO update(LocationSeedDTO locationSeedDTO, Long id);
    Collection<LocationExposeDTO> findAll();
    LocationExposeDTO findById(Long id);
    void deleteById(Long id);

}
