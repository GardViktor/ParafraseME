package com.me.Parafrase.livro;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

   private LivroRepository livroRepository;
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    //Create
    public Livro criarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
    //Read
    public List<Livro> listarLivro() {
        return livroRepository.findAll();
    }
    //ReadID
    public Livro listarLivroID(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null);

    }
    //Update
    public Livro atualizarNinja(Long id, Livro livroUpdate) {
        if (livroRepository.existsById(id)) {
            livroUpdate.setId(id);
            return livroRepository.save(livroUpdate);
        }
        return null;
    }
    //Delete
    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

}
