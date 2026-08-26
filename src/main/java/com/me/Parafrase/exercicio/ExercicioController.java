package com.me.Parafrase.exercicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;
    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarExercicio(@RequestBody ExercicioDTO exercicioDTO) {
        ExercicioDTO exercicioCreate = exercicioService.criarExercicio(exercicioDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Exercicio ID[" + exercicioCreate.getId() + "] Criado");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ExercicioDTO>> listarExercicio() {
        List<ExercicioDTO> exercicios = exercicioService.listarExercicio();
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarExercicioID(@PathVariable Long id) {
        ExercicioDTO exercicioRead = exercicioService.listarExercicioID(id);
        if (exercicioRead != null) {
            return ResponseEntity.ok(exercicioRead);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Exercicio ID[" + id + "] Não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarExercicio(@PathVariable Long id, @RequestBody ExercicioDTO exercicioDTO) {
        ExercicioDTO exercicioUpdate = exercicioService.alterarExercicio(id, exercicioDTO);
        if (exercicioUpdate != null) {
            return ResponseEntity.ok(exercicioUpdate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exercicio ID[" + id + "] Não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarExercicio(@PathVariable Long id) {
        if(exercicioService.listarExercicioID(id) != null) {
            exercicioService.deletarExercicio(id);
            return ResponseEntity.ok("Exercicio ID[" + id + "] Deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Exercicio ID[" + id + "] Não encontrado");
        }
    }
}
