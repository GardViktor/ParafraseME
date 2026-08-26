package com.me.Parafrase.anotacao;

import org.springframework.stereotype.Component;

@Component
public class AnotacaoMapper {

    public Anotacao map(AnotacaoDTO anotacaoDTO) {

        Anotacao anotacao = new Anotacao();
        anotacao.setId(anotacaoDTO.getId());
        anotacao.setCapitulo(anotacaoDTO.getCapitulo());
        anotacao.setPagina(anotacaoDTO.getPagina());
        anotacao.setMinhaAnotacao(anotacaoDTO.getMinhaAnotacao());
        anotacao.setDataCadastro(anotacaoDTO.getDataCadastro());
        anotacao.setLivros(anotacaoDTO.getLivros());
        anotacao.setExercicios(anotacaoDTO.getExercicios());

        return anotacao;
    }

    public AnotacaoDTO map(Anotacao anotacao) {

        AnotacaoDTO anotacaoDTO = new AnotacaoDTO();
        anotacaoDTO.setId(anotacao.getId());
        anotacaoDTO.setCapitulo(anotacao.getCapitulo());
        anotacaoDTO.setPagina(anotacao.getPagina());
        anotacaoDTO.setMinhaAnotacao(anotacao.getMinhaAnotacao());
        anotacaoDTO.setDataCadastro(anotacao.getDataCadastro());
        anotacaoDTO.setLivros(anotacao.getLivros());
        anotacaoDTO.setExercicios(anotacao.getExercicios());

        return anotacaoDTO;
    }
}
