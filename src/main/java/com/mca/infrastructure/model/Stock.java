package com.mca.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    private Long id;
    private boolean availability;
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VIDEOGAME_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "items"})
    @JsonIgnore
    private Game game;
}
