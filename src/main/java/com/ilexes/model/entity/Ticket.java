package com.ilexes.model.entity;

import com.ilexes.model.enums.Priority;
import com.ilexes.model.enums.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EnableJpaAuditing
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(columnDefinition = "TEXT")
    @Min(20)
    private String description;
    @Enumerated(EnumType.STRING)
    private State state;
    @JoinColumn(nullable = false)
    @ManyToOne(targetEntity = User.class)
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "tickets_files",
            joinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id"))
    private List<InputFile> attachments = new ArrayList<>();
    @ManyToOne(targetEntity = Agent.class)
    private Agent agent;
    @ManyToOne
    @JoinColumn(name = "application_name", referencedColumnName = "name", columnDefinition = "VARCHAR(50)")
    private Application application;
    @JoinColumn(nullable = false)
    @ManyToOne(targetEntity = Group.class)
    private Group supportGroup;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @OneToOne(targetEntity = Survey.class)
    private Survey survey;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime lastModified;
}
