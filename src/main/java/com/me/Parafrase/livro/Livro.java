package com.me.Parafrase.livro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.Parafrase.anotacao.Anotacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    private String autor;
    private String editora;
    @Column(name = "publicacao")
    private Integer anoPublicacao;
    @Column(name = "qtd_paginas")
    private Integer numeroPaginas;
    @OneToMany(mappedBy = "livros")
    @JsonIgnore
    private List<Anotacao> anotacoes;
}
