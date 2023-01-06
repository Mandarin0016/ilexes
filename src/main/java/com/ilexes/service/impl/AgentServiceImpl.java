package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.agent.AgentExposeDTO;

import com.ilexes.service.AgentService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AgentServiceImpl implements AgentService {
    @Override
    public Collection<AgentExposeDTO> findAll() {
        return null;
    }

}
