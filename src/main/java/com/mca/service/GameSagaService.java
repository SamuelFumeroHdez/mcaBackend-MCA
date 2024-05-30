package com.mca.service;

import com.mca.infrastructure.dto.GameDTO;
import com.mca.infrastructure.model.Game;
import com.mca.mapper.GameMapper;
import com.mca.repository.IGameSagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameSagaService implements IGameSagaService{

    private final IGameSagaRepository gameSagaRepository;
    private final RestTemplate restTemplate;

    @Value("${videogames.api.url}")
    private String baseUrl;

    @Autowired
    public GameSagaService(IGameSagaRepository gameSagaRepository, RestTemplate restTemplate){
        this.gameSagaRepository = gameSagaRepository;
        this.restTemplate = restTemplate;
    }

    public List<GameDTO> getSimilarSagas(int id){
        String url = baseUrl.concat("/").concat(String.valueOf(id)).concat("/").concat("related-sagas");
        List<Integer> similarGamesIds = restTemplate.getForEntity(url,List.class).getBody();

        return similarGamesIds.stream()
                .map(Integer::longValue)
                .map(this::findGameById)
                .map(GameMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Game findGameById(Long id) {
        return gameSagaRepository.findById(id).orElse(null);
    }
}
