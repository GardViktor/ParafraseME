package com.me.Parafrase.anotacao;

import com.me.Parafrase.exercicio.Exercicio;
import com.me.Parafrase.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnotacaoDTO {

    private Long id;
    private String capitulo;
    private Integer pagina;
    private String minhaAnotacao;
    private LocalDate dataCadastro;
    private Livro livros;
    private List<Exercicio> exercicios;
}
