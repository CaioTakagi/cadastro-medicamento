package com.example.cadastro.demo.Controller;


import com.example.cadastro.demo.Service.MedicamentoService;
import com.example.cadastro.demo.model.Medicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentosService;

    @GetMapping
    public List<Medicamento> listarMedicamento() {
        return medicamentosService.listarTodos();
    }

    @PostMapping
    public Medicamento SalvarMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentosService.salvarMedicamento(medicamento);
    }

    @DeleteMapping("/{id}")
    public void deletarMedicamento(@PathVariable Long id) {
        medicamentosService.deletarMedicamento(id);
    }

    @PutMapping("/{id}")
    public Medicamento atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        return medicamentosService.atualizarMedicamento(id, medicamento);
    }
}
