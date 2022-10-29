package com.ilexes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SupportProvider extends Company {
    @OneToMany(mappedBy = "company", targetEntity = Agent.class)
    private List<Agent> agents = new ArrayList<>();
}
