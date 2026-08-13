package com.me.Parafrase.anotacao;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anotacoes")
public class AnotacaoController {

    private AnotacaoService anotacaoService;

    public AnotacaoController(AnotacaoService anotacaoService) {
        this.anotacaoService = anotacaoService;
    }

    @PostMapping("/criar")
    public Anotacao criarAnotacao(@RequestBody Anotacao anotacao) {
        return anotacaoService.criarAnotacao(anotacao);
    }

    @GetMapping("/listar")
    public List<Anotacao> listarAnotacao() {
        return anotacaoService.listarAnotacao();
    }

    @GetMapping("/listar/{id}")
    public Anotacao listarAnotacaoID(@PathVariable Long id) {
        return anotacaoService.listarAnotacaoID(id);
    }

    @PutMapping("/alterar/{id}")
    public Anotacao alterarAnotacao(@PathVariable Long id, @RequestBody Anotacao anotacao) {
        return anotacaoService.alterarAnotacao(id, anotacao);
    }

    @DeleteMapping("/deletar/{id}")
    public void  deletarAnotacao(@PathVariable Long id) {
        anotacaoService.deletarAnotacao(id);
    }



}
