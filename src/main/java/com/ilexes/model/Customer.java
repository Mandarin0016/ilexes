package com.ilexes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Table(name = "customers")
public class Customer extends User {
    @OneToMany(mappedBy = "customer", targetEntity = Ticket.class)
    private List<Ticket> tickets = new ArrayList<>();

}
