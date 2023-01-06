package com.ilexes.service;

import com.ilexes.model.dto.expose.agent.AgentExposeDTO;
import java.util.Collection;

public interface AgentService {
    Collection<AgentExposeDTO> findAll();

}
