package com.me.Parafrase.exercicio;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping("/criar")
    public ExercicioDTO criarExercicio(@RequestBody ExercicioDTO exercicioDTO) {
        return exercicioService.criarExercicio(exercicioDTO);

    }

    @GetMapping("/listar")
    public List<ExercicioDTO> listarExercicio() {
        return exercicioService.listarExercicio();
    }

    @GetMapping("/listar/{id}")
    public ExercicioDTO listarExercicioID(@PathVariable Long id) {
        return exercicioService.listarExercicioID(id);
    }

    @PutMapping("/alterar/{id}")
    public ExercicioDTO alterarExercicio(@PathVariable Long id, @RequestBody ExercicioDTO exercicioDTO) {
        return exercicioService.alterarExercicio(id, exercicioDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarExercicio(@PathVariable Long id) {
        exercicioService.deletarExercicio(id);
    }
}
