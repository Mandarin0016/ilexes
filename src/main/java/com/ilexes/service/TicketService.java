package com.ilexes.service;

import com.ilexes.model.dto.expose.ticket.TicketExposeDTO;
import com.ilexes.model.dto.seed.ticket.TicketSeedDTO;
import com.ilexes.model.entity.Customer;
import com.ilexes.model.enums.State;

import java.util.Collection;

public interface TicketService {
    Collection<TicketExposeDTO> findAll();
    TicketExposeDTO findById(Long id);

    Collection<TicketExposeDTO> findByState(State state);

    Collection<TicketExposeDTO> findByCustomer(Customer customer);

    TicketExposeDTO update(TicketSeedDTO ticketSeedDTO);

    TicketExposeDTO create(TicketSeedDTO ticketSeedDTO);

    void deleteById(Long id);
}
