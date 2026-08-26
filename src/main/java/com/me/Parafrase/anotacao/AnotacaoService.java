package com.me.Parafrase.anotacao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnotacaoService {

    private final AnotacaoRepository anotacaoRepository;
    private final AnotacaoMapper anotacaoMapper;
    public AnotacaoService(AnotacaoRepository anotacaoRepository, AnotacaoMapper anotacaoMapper) {
        this.anotacaoRepository = anotacaoRepository;
        this.anotacaoMapper = anotacaoMapper;
    }

    public AnotacaoDTO criarAnotacao(AnotacaoDTO anotacaoDTO) {
        Anotacao anotacao = anotacaoMapper.map(anotacaoDTO);
        anotacao = anotacaoRepository.save(anotacao);
        return anotacaoMapper.map(anotacao);
    }

    public List<AnotacaoDTO> listarAnotacao() {
        List<Anotacao> anotacaos = anotacaoRepository.findAll();
        return anotacaos.stream()
                .map(anotacaoMapper::map)
                .collect(Collectors.toList());
    }

    public AnotacaoDTO listarAnotacaoID(Long id) {
        Optional<Anotacao> anotacao = anotacaoRepository.findById(id);
                return anotacao.map(anotacaoMapper::map).orElse(null);
    }

    public AnotacaoDTO alterarAnotacao(Long id, AnotacaoDTO anotacaoDTO) {
        Optional<Anotacao> anotacao = anotacaoRepository.findById(id);
        if(anotacao.isPresent()) {
            Anotacao anotacaoUpdate = anotacaoMapper.map(anotacaoDTO);
            anotacaoUpdate.setId(id);
            Anotacao anotacaoNew = anotacaoRepository.save(anotacaoUpdate);
            return  anotacaoMapper.map(anotacaoNew);
        }

        return null;
    }

    public void deletarAnotacao(Long id) {
        anotacaoRepository.deleteById(id);
    }
}
