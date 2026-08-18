package com.me.Parafrase.exercicio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExercicioService {
    
    private ExercicioRepository exercicioRepository;
    private ExercicioMapper exercicioMapper;

    public ExercicioService(ExercicioRepository exercicioRepository, ExercicioMapper exercicioMapper) {
        this.exercicioRepository = exercicioRepository;
        this.exercicioMapper = exercicioMapper;
    }

    public ExercicioDTO criarExercicio(ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioMapper.map(exercicioDTO);
        exercicio = exercicioRepository.save(exercicio);
        return exercicioMapper.map(exercicio);

    }

    public List<ExercicioDTO> listarExercicio() {
        List<Exercicio> exercicios = exercicioRepository.findAll();
        return  exercicios.stream()
                .map(exercicioMapper::map)
                .collect(Collectors.toList());

    }

    public ExercicioDTO listarExercicioID(Long id) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        return exercicio.map(exercicioMapper::map).orElse(null);
    }

    public ExercicioDTO alterarExercicio(Long id, ExercicioDTO exercicioDTO) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        if (exercicio.isPresent()) {
            Exercicio exercicioUpdate = exercicioMapper.map(exercicioDTO);
            exercicioUpdate.setId(id);
            Exercicio exercicioNew = exercicioRepository.save(exercicioUpdate);
            return exercicioMapper.map(exercicioNew);
        }
        return null;
    }

    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}
