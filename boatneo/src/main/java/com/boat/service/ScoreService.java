package com.boat.service;

import com.boat.model.Score;
import com.boat.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea 
public class ScoreService {

    @Autowired  //se trata de la anotación que permite inyectar unas dependencias con otras dentro de Spring 
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int scoreId) {
        return scoreRepository.getScore(scoreId);
    }

    public Score save(Score score) {
        if (score.getStars() >= 0 && score.getStars() <= 5) {
            if (score.getIdScore() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> e = scoreRepository.getScore(score.getIdScore());
                if (e.isEmpty()) {
                    return scoreRepository.save(score);
                }
            }

        }
        return score;
    }

}
