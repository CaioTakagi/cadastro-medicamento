package com.example.cadastro.demo.repository;

import com.example.cadastro.demo.model.Medicamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MedicamentoRepositoryTest {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Test
    void medicamentosSalvosCorretamente() {

        Medicamento medicamento = new Medicamento();
        medicamento.setNome("Rivotril");
        medicamento.setFabricante("FarmaFicticia");
        medicamento.setDescricao("Colocar em promoção");
        medicamento.setQuantidade(50);
        medicamento.setPrecoCusto(BigDecimal.valueOf(20.5));
        medicamento.setPrecoVenda(BigDecimal.valueOf(52.9));
        medicamento.setDataValidade(LocalDate.now().plusMonths(6));

        Medicamento salvarMedicamento = medicamentoRepository.save(medicamento);

        Optional<Medicamento> found = medicamentoRepository.findById(salvarMedicamento.getId());
        assertTrue(found.isPresent());
    }
}