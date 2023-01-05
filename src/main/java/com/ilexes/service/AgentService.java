package com.ilexes.service;

import com.ilexes.model.dto.expose.agent.AgentExposeDTO;
import com.ilexes.model.dto.seed.agent.AgentSeedDTO;
import com.ilexes.model.entity.Group;

import java.util.Collection;

public interface AgentService {
    Collection<AgentExposeDTO> findAll();
    AgentExposeDTO findByUserId(Long id);
    AgentExposeDTO findByUserEmail(String email);
    AgentExposeDTO update(AgentSeedDTO agentSeedDTO);
    AgentExposeDTO create(AgentSeedDTO agentSeedDTO);
    void deleteByUserId(Long id);

}
