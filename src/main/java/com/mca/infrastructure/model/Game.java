package com.mca.infrastructure.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.message.LeaderAndIsrRequestData;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VIDEOGAME")
public class Game {

    @Id
    private Long id;

    @Column(name = "TITLE")
    private String name;

    @OneToOne(mappedBy = "game")
    private Stock stock;

    @OneToMany(mappedBy = "game", cascade = {CascadeType.ALL})
    private List<Promotion> promotions;

}
