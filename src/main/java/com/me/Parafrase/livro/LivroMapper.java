package com.me.Parafrase.livro;

import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro map(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setId(livroDTO.getId());
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setEditora(livroDTO.getEditora());
        livro.setAnoPublicacao(livroDTO.getAnoPublicacao());
        livro.setNumeroPaginas(livroDTO.getNumeroPaginas());

        return livro;
    }

    public LivroDTO map(Livro livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setTitulo(livro.getTitulo());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setEditora(livro.getEditora());
        livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
        livroDTO.setNumeroPaginas(livro.getNumeroPaginas());

        return livroDTO;
    }
}
