package com.example.cadastro.demo.Controller;


import com.example.cadastro.demo.Service.MedicamentoService;
import com.example.cadastro.demo.model.Medicamento;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentosService;

    @GetMapping   // Get buscar os items
    public String listarMedicamento(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarTodos();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/novo")
    public String exibirFormularioDeCadastro(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        return "formulario-medicamento";
    }


    @PostMapping
    public String salvarMedicamento(@ModelAttribute Medicamento medicamento) {
        medicamentosService.salvarMedicamento(medicamento);
        return "redirect:/medicamentos"; // Redirecionar
    }

    @PostMapping("/editar/{id}")
    public String salvarMedicamentoEditado(@PathVariable Long id, @ModelAttribute Medicamento medicamentoEditado) {
        Medicamento medicamento = medicamentosService.listarTodos()
                .stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);

        // Verifica se o medicamento foi encontrado
        if (medicamento == null) {
            return "redirect:/medicamentos";
        }

        return "redirect:/medicamentos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMedicamento(@PathVariable Long id) {
        medicamentosService.deletarMedicamento(id);
        return "redirect:/medicamentos";
    }


}
