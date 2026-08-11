package com.me.Parafrase.anotacao;

import com.me.Parafrase.livro.Livro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_anotacoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String capitulo;
    private Integer pagina;
    @Column(nullable = false, name = "anotacao")
    private String minhaAnotacao;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

}
