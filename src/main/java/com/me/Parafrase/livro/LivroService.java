package com.me.Parafrase.livro;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

   private LivroRepository livroRepository;
   private LivroMapper livroMapper;
    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public LivroDTO criarLivro(LivroDTO livroDTO) {
        Livro livro = livroMapper.map(livroDTO);
        livro = livroRepository.save(livro);
        return livroMapper.map(livro);
    }

    public List<LivroDTO> listarLivro() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
                .map(livroMapper::map)
                .collect(Collectors.toList());
    }

    public LivroDTO listarLivroID(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.map(livroMapper::map).orElse(null);
    }

    public LivroDTO atualizarNinja(Long id, LivroDTO livroDTO) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            Livro livroUpdate = livroMapper.map(livroDTO);
            livroUpdate.setId(id);
            Livro livroNew = livroRepository.save(livroUpdate);
            return livroMapper.map(livroNew);
        }
        return null;
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
