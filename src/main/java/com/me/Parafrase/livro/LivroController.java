package com.me.Parafrase.livro;

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
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.criarLivro(livro);

    }
    @GetMapping("/listar")
    public List<Livro> listarLivro() {
        return livroService.listarLivro();
    }

    @GetMapping("/listar/{id}")
    public Livro listarLivroID(@PathVariable Long id){
        return livroService.listarLivroID(id);
    }

    @PutMapping("/alterar/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livroUpdate) {
        return livroService.atualizarNinja(id, livroUpdate);

    }
    @DeleteMapping("/deletar/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }

}
