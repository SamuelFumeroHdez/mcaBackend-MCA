package com.mca.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GameDTO {

    private Long id;
    private String title;
    private Double price;
    private boolean availability;
}
