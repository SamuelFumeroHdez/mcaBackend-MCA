package com.mca.mapper;

import com.mca.infrastructure.dto.GameDTO;
import com.mca.infrastructure.model.Game;
import com.mca.infrastructure.model.Promotion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameMapper {

    public static GameDTO toDTO(Game game){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setTitle(game.getName());
        gameDTO.setAvailability(game.getStock().isAvailability());

        // El contrato indica devolver solo un unico precio, por lo que vos a suponer que nos queremos quedar
        // con la fecha de promoción más reciente
        gameDTO.setPrice(game.getPromotions().stream()
                .max((d1, d2) -> d1.getValidFrom().compareTo(d2.getValidFrom()))
                .map(Promotion::getPrice)
                .orElse(null));

        return gameDTO;
    }
}
