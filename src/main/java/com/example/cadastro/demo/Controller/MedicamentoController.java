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


    @GetMapping("/deletar/{id}")
    public String deletarMedicamento(@PathVariable Long id) {
        medicamentosService.deletarMedicamento(id);
        return "redirect:/medicamentos";
    }

    @GetMapping("/editar/{id}")
    public String editarMedicamento(@PathVariable Long id, Model model) {
        Medicamento medicamento = medicamentosService.buscarPorId(id);
        if (medicamento == null) {
            return "redirect:/medicamentos";
        }
        model.addAttribute("medicamento", medicamento);
        return "formulario-medicamento";

    }

    @PostMapping("/editar/{id}")
    public String atualizarMedicamento(@PathVariable Long id, @ModelAttribute Medicamento medicamentoAtualizado) {
        medicamentosService.atualizarMedicamento(id, medicamentoAtualizado);
        return "redirect:/medicamentos";
    }



    @GetMapping("/crescente")
    public String listarMedicamentosEmOrdemCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarTodosEmOrdemCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";  // Página de exibição
    }

    @GetMapping("/decrescente")
    public String listarMedicamentosEmOrdemDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarTodosEmOrdemDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";  // Página de exibição
    }

    @GetMapping("/nome/crescente")
    public String listarMedicamentosEmOrdemNomeCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorNomeCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";  // Página de exibição
    }

    @GetMapping("/nome/decrescente")
    public String listarMedicamentosPorNomeDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorNomeDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";  // Página de exibição
    }

    @GetMapping("/fabricante/crescente")
    public String listarMedicamentosPorFabricanteCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorFabricanteCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/fabricante/decrescente")
    public String listarMedicamentosPorFabricanteDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorFabricanteDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/descricao/crescente")
    public String listarMedicamentosPorDescricaoCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorDescricaoCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/descricao/decrescente")
    public String listarMedicamentosPorDescricaoDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorDescricaoDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/preco-custo/crescente")
    public String listarMedicamentosPorPrecoCustoCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorPrecoCustoCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/preco-custo/decrescente")
    public String listarMedicamentosPorPrecoCustoDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorPrecoCustoDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/preco-venda/crescente")
    public String listarMedicamentosPorPrecoVendaCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorPrecoVendaCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/preco-venda/decrescente")
    public String listarMedicamentosPorPrecoVendaDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorPrecoVendaDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/quantidade/crescente")
    public String listarMedicamentosPorQuantidadeCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorQuantidadeCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/quantidade/decrescente")
    public String listarMedicamentosPorQuantidadeDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorQuantidadeDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/data-validade/crescente")
    public String listarMedicamentosPorDataValidadeCrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorDataValidadeCrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

    @GetMapping("/data-validade/decrescente")
    public String listarMedicamentosPorDataValidadeDecrescente(Model model) {
        List<Medicamento> medicamentos = medicamentosService.listarMedicamentosPorDataValidadeDecrescente();
        model.addAttribute("medicamentos", medicamentos);
        return "medicamentos";
    }

}
