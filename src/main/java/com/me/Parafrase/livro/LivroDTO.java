package com.me.Parafrase.livro;

import com.me.Parafrase.anotacao.Anotacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer anoPublicacao;
    private Integer numeroPaginas;
    private List<Anotacao> anotacoes;
}
