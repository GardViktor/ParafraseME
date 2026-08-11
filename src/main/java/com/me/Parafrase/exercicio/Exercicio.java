package com.me.Parafrase.exercicio;

import com.me.Parafrase.anotacao.Anotacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private boolean resolvido;
    @Column(name = "solucao")
    private String linkSolucao;
    @ManyToOne
    @Column(name = "anotacao_id", nullable = false)
    private Anotacao anotacao;
}
