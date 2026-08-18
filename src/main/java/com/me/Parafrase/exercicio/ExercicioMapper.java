package com.me.Parafrase.exercicio;

import org.springframework.stereotype.Component;

@Component
public class ExercicioMapper {

    public Exercicio map(ExercicioDTO exercicioDTO) {
        Exercicio exercicio = new Exercicio();
        exercicio.setId(exercicioDTO.getId());
        exercicio.setEnunciado(exercicioDTO.getEnunciado());
        exercicio.setResolvido(exercicioDTO.isResolvido());
        exercicio.setLinkSolucao(exercicioDTO.getLinkSolucao());
        exercicio.setAnotacoes(exercicioDTO.getAnotacoes());

        return exercicio;

    }

    public ExercicioDTO map(Exercicio exercicio) {
        ExercicioDTO exercicioDTO = new ExercicioDTO();
        exercicioDTO.setId(exercicio.getId());
        exercicioDTO.setEnunciado(exercicio.getEnunciado());
        exercicioDTO.setResolvido(exercicio.isResolvido());
        exercicioDTO.setLinkSolucao(exercicio.getLinkSolucao());
        exercicioDTO.setAnotacoes(exercicio.getAnotacoes());

        return exercicioDTO;
    }
}
