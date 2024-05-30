package com.mca.controller;

import com.mca.infrastructure.dto.GameDTO;
import com.mca.infrastructure.model.Game;
import com.mca.service.GameSagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class SagaController {

    private final GameSagaService gameSagaService;

    @Autowired
    public SagaController(GameSagaService gameSagaService){
        this.gameSagaService = gameSagaService;
    }

    @GetMapping("/{id}/saga")
    public ResponseEntity<List<GameDTO>> findSimilarSmartphones(@PathVariable Integer id) {
        List<GameDTO> gamesList = gameSagaService.getSimilarSagas(id);

        return gamesList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(gamesList);
    }

}
