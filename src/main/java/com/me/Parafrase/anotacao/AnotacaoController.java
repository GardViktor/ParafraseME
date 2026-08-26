package com.me.Parafrase.anotacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anotacoes")
public class AnotacaoController {

    private final AnotacaoService anotacaoService;
    public AnotacaoController(AnotacaoService anotacaoService) {
        this.anotacaoService = anotacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarAnotacao(@RequestBody AnotacaoDTO anotacaoDTO) {
        AnotacaoDTO anotacaoCreate = anotacaoService.criarAnotacao(anotacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Anotação ID[" + anotacaoCreate.getId() + "] Criada");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AnotacaoDTO>> listarAnotacao() {
        List<AnotacaoDTO> anotacoes = anotacaoService.listarAnotacao();
        return ResponseEntity.ok(anotacoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAnotacaoID(@PathVariable Long id) {
        AnotacaoDTO anotacaoRead = anotacaoService.listarAnotacaoID(id);
        if (anotacaoRead != null) {
            return ResponseEntity.ok(anotacaoRead);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Anotação ID[" + id + "] Não encontrada");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarAnotacao(@PathVariable Long id, @RequestBody AnotacaoDTO anotacaoDTO) {
        AnotacaoDTO anotacaoUpdate = anotacaoService.alterarAnotacao(id, anotacaoDTO);
        if (anotacaoUpdate != null) {
            return ResponseEntity.ok(anotacaoUpdate);
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Anotação ID[" + id + "] Não encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAnotacao(@PathVariable Long id) {
        if (anotacaoService.listarAnotacaoID(id) != null) {
            anotacaoService.deletarAnotacao(id);
            return ResponseEntity.ok("Anotação ID[" + id + "] Deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Anotação ID[" + id + "] Não encontrada");
        }
    }
}
