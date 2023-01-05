package com.ilexes.service;

import com.ilexes.model.dto.expose.group.GroupExposeDTO;
import com.ilexes.model.dto.seed.group.GroupSeedDTO;

import java.util.Collection;

public interface GroupService {

    Collection<GroupExposeDTO> findAll();
    GroupExposeDTO findById(Long id);
    GroupExposeDTO update(GroupSeedDTO groupSeedDTO);
    GroupExposeDTO create(GroupSeedDTO groupSeedDTO);
    void deleteById(Long id);
}
