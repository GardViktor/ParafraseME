package com.me.Parafrase.anotacao;

import com.me.Parafrase.livro.LivroDTO;
import com.me.Parafrase.livro.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("anotacoes/ui")
public class AnotacaoControllerUI {

    private final AnotacaoService anotacaoService;
    private final LivroService livroService;

    public AnotacaoControllerUI(
            AnotacaoService anotacaoService,
            LivroService livroService) {
        this.anotacaoService = anotacaoService;
        this.livroService = livroService;
    }

    @GetMapping("/listar")
    public String listarAnotacoes(Model model) {
        List<AnotacaoDTO> anotacoes = anotacaoService.listarAnotacao();
        model.addAttribute("anotacoes", anotacoes);
        return "listarAnotacoes";
    }

    @GetMapping("/listar/{id}")
    public String listarAnotacaoID(
            @PathVariable Long id,
            Model model) {

        AnotacaoDTO anotacaoRead = anotacaoService.listarAnotacaoID(id);

        if (anotacaoRead != null) {
            model.addAttribute("anotacao", anotacaoRead);
            return "detalhesAnotacoes";
        }

        model.addAttribute("mensagem", "Anotação não encontrada");
        return "redirect:/anotacoes/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String abrirAlteracao(
            @PathVariable Long id,
            Model model) {

        AnotacaoDTO anotacao = anotacaoService.listarAnotacaoID(id);

        if (anotacao != null) {
            model.addAttribute("anotacao", anotacao);
            return "alterarAnotacoes";
        }

        return "redirect:/anotacoes/ui/listar";
    }

    @PostMapping("/alterar/{id}")
    public String atualizarAnotacao(
            @PathVariable Long id,
            @ModelAttribute AnotacaoDTO anotacaoDTO,
            RedirectAttributes redirectAttributes) {

        AnotacaoDTO anotacaoAtualizado =
                anotacaoService.atualizarAnotacao(id, anotacaoDTO);

        if (anotacaoAtualizado != null) {
            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Anotação alterada com sucesso!"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Anotação não encontrada!"
            );
        }

        return "redirect:/anotacoes/ui/listar";
    }

    @GetMapping("/adicionar")
    public String formAnotacaoSemLivro(Model model) {

        List<LivroDTO> livros = livroService.listarLivro();

        AnotacaoDTO anotacao = new AnotacaoDTO();
        anotacao.setDataCadastro(LocalDate.now());

        model.addAttribute("livros", livros);
        model.addAttribute("anotacao", anotacao);

        return "formAnotacoes";
    }

    @GetMapping("/adicionar/{livroId}")
    public String formAnotacaoComLivro(
            @PathVariable Long livroId,
            Model model) {

        LivroDTO livro = livroService.listarLivroID(livroId);

        if (livro == null) {
            return "redirect:/livros/ui/listar";
        }

        AnotacaoDTO anotacao = new AnotacaoDTO();
        anotacao.setDataCadastro(LocalDate.now());

        model.addAttribute("livro", livro);
        model.addAttribute("anotacao", anotacao);

        return "formAnotacoes";
    }

    @PostMapping("/salvar")
    public String salvarAnotacao(
            @RequestParam Long livroId,
            @ModelAttribute AnotacaoDTO anotacao,
            RedirectAttributes redirectAttributes) {

        anotacaoService.criarAnotacaoComLivro(livroId, anotacao);

        redirectAttributes.addFlashAttribute(
                "mensagem",
                "Anotação cadastrada com sucesso!"
        );

        return "redirect:/anotacoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAnotacao(@PathVariable Long id) {

        anotacaoService.deletarAnotacao(id);

        return "redirect:/anotacoes/ui/listar";
    }
}