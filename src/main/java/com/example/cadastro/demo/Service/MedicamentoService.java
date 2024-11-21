package com.example.cadastro.demo.Service;

import com.example.cadastro.demo.model.Medicamento;
import com.example.cadastro.demo.repository.MedicamentoRepository;
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

    public Medicamento salvarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deletarMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }

    public Medicamento atualizarMedicamento(Long id, Medicamento medicamentoAtualizado) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);
        if (optionalMedicamento.isPresent()) {
            Medicamento medicamento = optionalMedicamento.get();
            medicamento.setNome(medicamentoAtualizado.getNome());
            medicamento.setFabricante(medicamentoAtualizado.getDescricao());
            medicamento.setDescricao(medicamentoAtualizado.getDescricao());
            medicamento.setQuantidade(medicamentoAtualizado.getQuantidade());
            medicamento.setPrecoCusto(medicamentoAtualizado.getPrecoCusto());
            medicamento.setPrecoVenda(medicamentoAtualizado.getPrecoVenda());
            medicamento.setDataValidade(medicamentoAtualizado.getDataValidade());
            return medicamentoRepository.save(medicamento);

        } else {
            throw new RuntimeException("Medicamento não encontrado");
        }
    }
}
