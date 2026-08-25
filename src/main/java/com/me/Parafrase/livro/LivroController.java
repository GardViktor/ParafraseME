package com.me.Parafrase.livro;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public List<LivroDTO> listarLivro() {
        return livroService.listarLivro();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarLivroID(@PathVariable Long id) {
        LivroDTO livroRead = livroService.listarLivroID(id);
        if (livroRead != null) {
            return ResponseEntity.ok(livroRead);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro ID[" + livroRead.getId() + "] Não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public LivroDTO atualizarLivro(@PathVariable Long id, @RequestBody LivroDTO livroUpdate) {
        return livroService.atualizarNinja(id, livroUpdate);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}
