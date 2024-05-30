package com.mca.service;

import com.mca.infrastructure.model.Game;

public interface IGameSagaService {

    Game findGameById(Long id);
}
