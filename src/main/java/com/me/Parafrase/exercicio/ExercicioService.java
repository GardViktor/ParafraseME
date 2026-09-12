package com.me.Parafrase.exercicio;

import com.me.Parafrase.anotacao.Anotacao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;
    private final ExercicioMapper exercicioMapper;

    public ExercicioService(ExercicioRepository exercicioRepository, ExercicioMapper exercicioMapper) {
        this.exercicioRepository = exercicioRepository;
        this.exercicioMapper = exercicioMapper;
    }

    public ExercicioDTO criarExercicio(ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioMapper.map(exercicioDTO);
        exercicio = exercicioRepository.save(exercicio);
        return exercicioMapper.map(exercicio);
    }

    public ExercicioDTO criarExercicioComAnotacao(Long anotacaoId, ExercicioDTO exercicioDTO) {
        Exercicio exercicio = exercicioMapper.map(exercicioDTO);

        Anotacao anotacao = new Anotacao();
        anotacao.setId(anotacaoId);
        exercicio.setAnotacoes(anotacao);

        exercicio = exercicioRepository.save(exercicio);
        return exercicioMapper.map(exercicio);
    }

    public List<ExercicioDTO> listarExercicio() {
        List<Exercicio> exercicios = exercicioRepository.findAll();
        return exercicios.stream()
                .map(exercicioMapper::map)
                .collect(Collectors.toList());
    }

    public ExercicioDTO listarExercicioID(Long id) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        return exercicio.map(exercicioMapper::map).orElse(null);
    }

    public ExercicioDTO atualizarExercicio(Long id, ExercicioDTO exercicioDTO) {
        Optional<Exercicio> exercicioExistente = exercicioRepository.findById(id);
        if (exercicioExistente.isPresent()) {
            Exercicio exercicio = exercicioExistente.get();

            exercicio.setEnunciado(exercicioDTO.getEnunciado());
            exercicio.setResolvido(exercicioDTO.isResolvido());
            exercicio.setLinkSolucao(exercicioDTO.getLinkSolucao());

            Exercicio exercicioAtualizado = exercicioRepository.save(exercicio);
            return exercicioMapper.map(exercicioAtualizado);
        }

        return null;
    }

    public void deletarExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }
}