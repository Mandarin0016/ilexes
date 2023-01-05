package com.ilexes.service.impl;

import com.ilexes.model.dto.expose.ticket.TicketExposeDTO;
import com.ilexes.model.dto.seed.ticket.TicketSeedDTO;
import com.ilexes.model.entity.Customer;
import com.ilexes.model.enums.State;
import com.ilexes.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public Collection<TicketExposeDTO> findAll() {
        return null;
    }

    @Override
    public TicketExposeDTO findById(Long id) {
        return null;
    }

    @Override
    public Collection<TicketExposeDTO> findByState(State state) {
        return null;
    }

    @Override
    public Collection<TicketExposeDTO> findByCustomer(Customer customer) {
        return null;
    }

    @Override
    public TicketExposeDTO update(TicketSeedDTO ticketSeedDTO) {
        return null;
    }

    @Override
    public TicketExposeDTO create(TicketSeedDTO ticketSeedDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
