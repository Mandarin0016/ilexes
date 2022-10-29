package com.ilexes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EnableJpaAuditing
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "support_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Min(5)
    @Max(30)
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "group", targetEntity = Agent.class)
    private Set<Agent> agents = new HashSet<>();
    @OneToMany(targetEntity = Application.class)
    private Set<Application> applications = new HashSet<>();
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private User manager;
    @Email
    private String groupMailbox;
    @OneToMany(mappedBy = "supportGroup", targetEntity = Ticket.class)
    private Set<Ticket> tickets = new HashSet<>();
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime lastModified;
}
