package com.me.Parafrase.anotacao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnotacaoService {

    private AnotacaoRepository anotacaoRepository;

    public AnotacaoService(AnotacaoRepository anotacaoRepository) {
        this.anotacaoRepository = anotacaoRepository;
    }

    public Anotacao criarAnotacao(Anotacao anotacao) {
        return anotacaoRepository.save(anotacao);

    }

    public List<Anotacao> listarAnotacao() {
        return anotacaoRepository.findAll();
    }

    public Anotacao listarAnotacaoID(Long id) {
        Optional<Anotacao> anotacao = anotacaoRepository.findById(id);
                return anotacao.orElse(null);
    }

    public Anotacao alterarAnotacao(Long id, Anotacao anotacaoUpdate) {
        if (anotacaoRepository.existsById(id)) {
            anotacaoUpdate.setId(id);
            return anotacaoRepository.save(anotacaoUpdate);

        }
        return null;

    }

    public void deletarAnotacao(Long id) {
        anotacaoRepository.deleteById(id);
    }



}
