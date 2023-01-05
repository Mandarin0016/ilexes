package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.group.GroupExposeDTO;
import com.ilexes.model.dto.seed.group.GroupSeedDTO;
import com.ilexes.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GroupServiceImpl implements GroupService {
    @Override
    public Collection<GroupExposeDTO> findAll() {
        return null;
    }

    @Override
    public GroupExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public GroupExposeDTO update(GroupSeedDTO groupSeedDTO) {
        return null;
    }

    @Override
    public GroupExposeDTO create(GroupSeedDTO groupSeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
