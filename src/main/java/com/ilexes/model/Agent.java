package com.ilexes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Agent extends User {
    @ManyToOne
    private Group group;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private User manager;
    @OneToMany(mappedBy = "agent", targetEntity = Ticket.class)
    private List<Ticket> tickets = new ArrayList<>();
}
