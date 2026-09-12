package com.me.Parafrase.exercicio;

import com.me.Parafrase.anotacao.AnotacaoDTO;
import com.me.Parafrase.anotacao.AnotacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("exercicios/ui")
public class ExercicioControllerUI {

    private final ExercicioService exercicioService;
    private final AnotacaoService anotacaoService;

    public ExercicioControllerUI(ExercicioService exercicioService, AnotacaoService anotacaoService) {
        this.exercicioService = exercicioService;
        this.anotacaoService = anotacaoService;
    }

    @GetMapping("/listar")
    public String listarExercicios(Model model) {
        List<ExercicioDTO> exercicios = exercicioService.listarExercicio();
        model.addAttribute("exercicios", exercicios);
        return "listarExercicios";
    }

    @GetMapping("/listar/{id}")
    public String listarExercicioID(@PathVariable Long id, Model model) {
        ExercicioDTO exercicioRead = exercicioService.listarExercicioID(id);
        if (exercicioRead != null) {
            model.addAttribute("exercicio", exercicioRead);
            return "detalhesExercicios";
        } else {
            model.addAttribute("mensagem", "Exercicio não encontrado");
            return "redirect:/exercicios/ui/listar";
        }
    }

    @GetMapping("/alterar/{id}")
    public String abrirAlteracao(@PathVariable Long id, Model model) {

        ExercicioDTO exercicio = exercicioService.listarExercicioID(id);

        if (exercicio != null) {
            model.addAttribute("exercicio", exercicio);
            return "alterarExercicios";
        }

        return "redirect:/exercicios/ui/listar";
    }

    @PostMapping("/alterar/{id}")
    public String atualizarExercicio(
            @PathVariable Long id,
            @ModelAttribute ExercicioDTO exercicioDTO,
            RedirectAttributes redirectAttributes) {

        ExercicioDTO exercicioAtualizado =
                exercicioService.atualizarExercicio(id, exercicioDTO);

        if (exercicioAtualizado != null) {

            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Exercicio alterado com sucesso!"
            );

        } else {

            redirectAttributes.addFlashAttribute(
                    "mensagem",
                    "Exercicio não encontrado!"
            );
        }

        return "redirect:/exercicios/ui/listar";
    }

    @GetMapping("/adicionar")
    public String formExercicio(Model model) {
        model.addAttribute("exercicio", new ExercicioDTO());
        return "formExercicios";
    }

    @GetMapping("/adicionar/{anotacaoId}")
    public String formExercicioComAnotacao(@PathVariable Long anotacaoId, Model model) {
        AnotacaoDTO anotacao = anotacaoService.listarAnotacaoID(anotacaoId);

        if (anotacao == null) {
            return "redirect:/anotacoes/ui/listar";
        }

        model.addAttribute("anotacao", anotacao);
        model.addAttribute("exercicio", new ExercicioDTO());
        return "formExercicios";
    }

    @PostMapping("/salvar")
    public String salvarExercicio(@ModelAttribute ExercicioDTO exercicio, RedirectAttributes redirectAttributes) {
        exercicioService.criarExercicio(exercicio);
        redirectAttributes.addFlashAttribute("mensagem", "Exercicio cadastrado com sucesso!");
        return "redirect:/exercicios/ui/listar";
    }

    @PostMapping("/salvar/{anotacaoId}")
    public String salvarExercicioComAnotacao(
            @PathVariable Long anotacaoId,
            @ModelAttribute ExercicioDTO exercicio,
            RedirectAttributes redirectAttributes) {

        exercicioService.criarExercicioComAnotacao(anotacaoId, exercicio);
        redirectAttributes.addFlashAttribute("mensagem", "Exercicio cadastrado com sucesso!");
        return "redirect:/anotacoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarExercicio(@PathVariable Long id, Model model) {
        exercicioService.deletarExercicio(id);
        return "redirect:/exercicios/ui/listar";
    }
}