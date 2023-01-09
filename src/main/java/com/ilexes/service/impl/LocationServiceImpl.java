package com.ilexes.service.impl;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.NonExistingEntityException;
import com.ilexes.model.dto.expose.location.LocationExposeDTO;
import com.ilexes.model.dto.seed.location.LocationSeedDTO;
import com.ilexes.model.entity.Location;
import com.ilexes.repository.LocationRepository;
import com.ilexes.service.LocationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.ilexes.exception.ExceptionMessages.RESOURCE_WITH_ID_DOES_NOT_EXIST;

@Service
public class LocationServiceImpl implements LocationService {
    private final ModelMapper modelMapper;
    private final LocationRepository locationRepository;

    public LocationServiceImpl(ModelMapper modelMapper, LocationRepository locationRepository) {
        this.modelMapper = modelMapper;
        this.locationRepository = locationRepository;
    }

    @Override
    public Long count() {
        return locationRepository.count();
    }

    @Override
    public Collection<LocationExposeDTO> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(dto -> modelMapper.map(dto, LocationExposeDTO.class))
                .toList();
    }

    @Override
    public LocationExposeDTO findById(Long id) {
        return locationRepository.findById(id)
                .map(dto -> modelMapper.map(dto, LocationExposeDTO.class))
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.LOCATION_DOES_NOT_EXIST, id)));
    }

    @Override
    public LocationExposeDTO create(LocationSeedDTO locationSeedDTO) {
        Location location = modelMapper.map(locationSeedDTO, Location.class);
        locationRepository.save(location);
        return modelMapper.map(location, LocationExposeDTO.class);
    }

    @Override
    public LocationExposeDTO update(LocationSeedDTO locationSeedDTO, Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.LOCATION_DOES_NOT_EXIST, id)));
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        modelMapper.map(locationSeedDTO, location);
        locationRepository.save(location);
        return modelMapper.map(location, LocationExposeDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!locationRepository.existsById(id)) {
            throw new NonExistingEntityException(String.format(RESOURCE_WITH_ID_DOES_NOT_EXIST, id));
        }
        locationRepository.deleteById(id);
    }
}
