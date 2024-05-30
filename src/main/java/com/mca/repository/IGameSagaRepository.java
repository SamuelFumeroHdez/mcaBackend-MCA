package com.mca.repository;

import com.mca.infrastructure.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameSagaRepository extends JpaRepository<Game, Long> {

}
