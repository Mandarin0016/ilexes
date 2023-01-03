package com.ilexes.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Customer extends User {
    @OneToMany(mappedBy = "customer", targetEntity = Ticket.class)
    private List<Ticket> tickets = new ArrayList<>();
}
