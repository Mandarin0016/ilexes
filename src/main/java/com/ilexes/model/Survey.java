package com.ilexes.model;

import com.ilexes.model.enums.SatisfactionLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@EnableJpaAuditing
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @OneToOne(mappedBy = "survey", targetEntity = Ticket.class)
    @JoinColumn()
    private Ticket ticket;
    private String comment;
    @Enumerated(EnumType.STRING)
    private SatisfactionLevel satisfactionLevel;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime lastModified;
}
