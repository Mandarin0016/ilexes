package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.agent.AgentExposeDTO;
import com.ilexes.model.dto.seed.agent.AgentSeedDTO;
import com.ilexes.service.AgentService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AgentServiceImpl implements AgentService {


    @Override
    public Collection<AgentExposeDTO> findAll() {
        return null;
    }

    @Override
    public AgentExposeDTO findByUserId(Long id) {
        return null;
    }

    @Override
    public AgentExposeDTO findByUserEmail(String email) {
        return null;
    }

    @Override
    public AgentExposeDTO update(AgentSeedDTO agentSeedDTO) {
        return null;
    }

    @Override
    public AgentExposeDTO create(AgentSeedDTO agentSeedDTO) {
        return null;
    }

    @Override
    public void deleteByUserId(Long id) {

    }
}
