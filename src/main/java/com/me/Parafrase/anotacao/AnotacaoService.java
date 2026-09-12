package com.me.Parafrase.anotacao;

import com.me.Parafrase.livro.Livro;
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

    public AnotacaoDTO criarAnotacaoComLivro(Long livroId, AnotacaoDTO anotacaoDTO) {
        Anotacao anotacao = anotacaoMapper.map(anotacaoDTO);

        Livro livro = new Livro();
        livro.setId(livroId);
        anotacao.setLivros(livro);

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

    public AnotacaoDTO atualizarAnotacao(Long id, AnotacaoDTO anotacaoDTO) {
        Optional<Anotacao> anotacaoExistente = anotacaoRepository.findById(id);
        if (anotacaoExistente.isPresent()) {
            Anotacao anotacao = anotacaoExistente.get();

            anotacao.setCapitulo(anotacaoDTO.getCapitulo());
            anotacao.setPagina(anotacaoDTO.getPagina());
            anotacao.setMinhaAnotacao(anotacaoDTO.getMinhaAnotacao());
            anotacao.setDataCadastro(anotacaoDTO.getDataCadastro());

            Anotacao anotacaoAtualizada = anotacaoRepository.save(anotacao);
            return anotacaoMapper.map(anotacaoAtualizada);
        }

        return null;
    }

    public void deletarAnotacao(Long id) {
        anotacaoRepository.deleteById(id);
    }
}