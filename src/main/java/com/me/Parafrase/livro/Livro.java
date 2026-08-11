package com.me.Parafrase.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_livros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false)
    private String autor;
    @Column(name = "publicacao")
    private Integer anoPublicacao;
    @Column(name = "qtd_paginas")
    private Integer numeroPaginas;

}
