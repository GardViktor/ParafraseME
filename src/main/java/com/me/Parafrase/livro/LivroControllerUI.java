package com.me.Parafrase.livro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/livros/ui")
public class LivroControllerUI {

    private final LivroService livroService;

    public LivroControllerUI(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/listar")
    public String listarLivro(Model model) {
        List<LivroDTO> livros = livroService.listarLivro();
        model.addAttribute("livros", livros);
        return "listarLivros.html";
    }

    @GetMapping("/listar/{id}")
    public String listarLivroID(@PathVariable Long id, Model model) {
        LivroDTO livroRead = livroService.listarLivroID(id);
        if (livroRead != null) {
            model.addAttribute("livro", livroRead);      // singular, igual ao template
            return "detalhesLivros.html";                     // sem .html
        } else {
            model.addAttribute("mensagem", "Livro não encontrado");
            return "redirect:/livros/ui/listar";          // evita quebrar por falta de "livros" na listagem
        }
    }

    @GetMapping("/alterar/{id}")
    public String abrirAlteracao(@PathVariable Long id, Model model) {

        LivroDTO livro = livroService.listarLivroID(id);

        if (livro != null) {
            model.addAttribute("livro", livro);
            return "alterarLivros";
        }

        return "redirect:/livros/ui/listar";
    }

    // Salva a alteração
    @PostMapping("/alterar/{id}")
    public String atualizarLivro(
            @PathVariable Long id,
            @ModelAttribute LivroDTO livroDTO,
            RedirectAttributes redirectAttributes) {

        LivroDTO livroAtualizado =
                livroService.atualizarNinja(id, livroDTO);

        if (livroAtualizado != null) {

            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Livro alterado com sucesso!"
            );

        } else {

            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Livro não encontrado!"
            );
        }

        return "redirect:/livros/ui/listar";
    }


    @GetMapping("/adicionar")
    public String formLivro(Model model) {
        model.addAttribute("livro", new LivroDTO());
        return "formLivros.html";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute LivroDTO livro, RedirectAttributes redirectAttributes) {
        livroService.criarLivro(livro);
        redirectAttributes.addFlashAttribute("mensagem", "Livro cadastrado com sucesso!");
        return "redirect:/livros/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarLivro(@PathVariable Long id, Model model) {
        livroService.deletarLivro(id);
        return "redirect:/livros/ui/listar";
    }
}