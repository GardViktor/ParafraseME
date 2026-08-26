package com.me.Parafrase.livro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService livroService;
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO livroCreate = livroService.criarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Livro ID[" + livroCreate.getId() + "] Criado");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LivroDTO>> listarLivro() {
        List<LivroDTO> livros = livroService.listarLivro();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarLivroID(@PathVariable Long id) {
        LivroDTO livroRead = livroService.listarLivroID(id);
        if (livroRead != null) {
            return ResponseEntity.ok(livroRead);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro ID[" + id + "] Não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        LivroDTO livroUpdate = livroService.atualizarNinja(id, livroDTO);
        if (livroUpdate != null) {
            return ResponseEntity.ok(livroUpdate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro ID[" + id + "] Não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long id) {
        if (livroService.listarLivroID(id) != null) {
            livroService.deletarLivro(id);
            return ResponseEntity.ok("Livro ID[" + id + "] Deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro ID[" + id + "] Não encontrado");
        }
    }
}
