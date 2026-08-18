package com.me.Parafrase.exercicio;

import com.me.Parafrase.anotacao.Anotacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExercicioDTO {

    private Long id;
    private String enunciado;
    private boolean resolvido;
    private String linkSolucao;
    private Anotacao anotacoes;

}
