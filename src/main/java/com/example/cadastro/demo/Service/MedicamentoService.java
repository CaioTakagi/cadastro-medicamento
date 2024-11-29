package com.example.cadastro.demo.Service;

import com.example.cadastro.demo.model.Medicamento;
import com.example.cadastro.demo.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento buscarPorId(Long id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    public Medicamento salvarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deletarMedicamento(Long id) {
        medicamentoRepository.deleteById(id);

    }

    public Medicamento atualizarMedicamento(Long id, Medicamento medicamentoAtualizado) {
        if (!medicamentoRepository.existsById(id)) {
            throw new RuntimeException("Medicamento não encontrado");
        }

        medicamentoRepository.deleteById(id);

        medicamentoAtualizado.setId(id);

        return medicamentoRepository.save(medicamentoAtualizado);
    }



    public List<Medicamento> listarTodosEmOrdemCrescente() {
        return medicamentoRepository.findAllByOrderByIdAsc();
    }
    public List<Medicamento> listarTodosEmOrdemDecrescente() {
        return medicamentoRepository.findAllByOrderByIdDesc();
    }

    public List<Medicamento> listarMedicamentosPorNomeCrescente() {
        return medicamentoRepository.findAllByOrderByNomeAsc();
    }
    public List<Medicamento> listarMedicamentosPorNomeDecrescente() {
        return medicamentoRepository.findAllByOrderByNomeDesc();
    }

    public List<Medicamento> listarMedicamentosPorFabricanteCrescente() {
        return medicamentoRepository.findAllByOrderByFabricanteAsc();
    }
    public List<Medicamento> listarMedicamentosPorFabricanteDecrescente() {
        return medicamentoRepository.findAllByOrderByFabricanteDesc();
    }

    public List<Medicamento> listarMedicamentosPorDescricaoCrescente() {
        return medicamentoRepository.findAllByOrderByDescricaoAsc();
    }
    public List<Medicamento> listarMedicamentosPorDescricaoDecrescente() {
        return medicamentoRepository.findAllByOrderByDescricaoDesc();
    }

    public List<Medicamento> listarMedicamentosPorQuantidadeCrescente() {
        return medicamentoRepository.findAllByOrderByQuantidadeAsc();
    }
    public List<Medicamento> listarMedicamentosPorQuantidadeDecrescente() {
        return medicamentoRepository.findAllByOrderByQuantidadeDesc();
    }
    public List<Medicamento> listarMedicamentosPorPrecoCustoCrescente() {
        return medicamentoRepository.findAllByOrderByPrecoCustoAsc();
    }
    public List<Medicamento> listarMedicamentosPorPrecoCustoDecrescente() {
        return medicamentoRepository.findAllByOrderByPrecoCustoDesc();
    }

    public List<Medicamento> listarMedicamentosPorPrecoVendaCrescente() {
        return medicamentoRepository.findAllByOrderByPrecoVendaAsc();
    }
    public List<Medicamento> listarMedicamentosPorPrecoVendaDecrescente() {
        return medicamentoRepository.findAllByOrderByPrecoVendaDesc();
    }

    public List<Medicamento> listarMedicamentosPorDataValidadeCrescente() {
        return medicamentoRepository.findAllByOrderByDataValidadeAsc();
    }
    public List<Medicamento> listarMedicamentosPorDataValidadeDecrescente() {
        return medicamentoRepository.findAllByOrderByDataValidadeDesc();
    }

}
