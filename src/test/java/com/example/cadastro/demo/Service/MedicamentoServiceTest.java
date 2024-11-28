package com.example.cadastro.demo.Service;

import com.example.cadastro.demo.model.Medicamento;
import com.example.cadastro.demo.repository.MedicamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MedicamentoServiceTest {

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @InjectMocks
    private MedicamentoService medicamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarRetornarMedicamentos() {
        Medicamento medicamento1 = new Medicamento();
        medicamento1.setNome("Coristina D");

        when(medicamentoRepository.findAll()).thenReturn(Arrays.asList(medicamento1));

        List<Medicamento> medicamentos = medicamentoService.listarTodos();

        assertEquals(1, medicamentos.size());
        assertEquals("Coristina D", medicamentos.get(0).getNome());
        verify(medicamentoRepository, timeout(0)).findAll();
    }

    @Test
    void salvarRetornarMedicamento() {
        Medicamento medicamento = new Medicamento();
        medicamento.setNome("Coristina D");

        when(medicamentoRepository.save(medicamento)).thenReturn(medicamento);

        Medicamento salvo = medicamentoService.salvarMedicamento(medicamento);

        assertNotNull(salvo);
        assertEquals("Coristina D", salvo.getNome());
        verify(medicamentoRepository, times(1)).save(medicamento);
    }

    @Test
    void deletarRetornarMedicamento() {

        Long id = 1L;

        medicamentoService.deletarMedicamento(id);

        verify(medicamentoRepository, times(1)).deleteById(id);
    }

    @Test
    void atualizarRetornarMedicamento() {
        // Arrange
        Long id = 1L;
        Medicamento medicamentoExistente = new Medicamento();
        medicamentoExistente.setId(id);
        medicamentoExistente.setNome("Antigo");

        Medicamento medicamentoAtualizado = new Medicamento();
        medicamentoAtualizado.setNome("Novo");
        medicamentoAtualizado.setDescricao("Descrição atualizada");
        medicamentoAtualizado.setQuantidade(20);
        medicamentoAtualizado.setPrecoCusto(BigDecimal.valueOf(10));
        medicamentoAtualizado.setPrecoVenda(BigDecimal.valueOf(15));
        medicamentoAtualizado.setDataValidade(LocalDate.now().plusDays(30));

        when(medicamentoRepository.findById(id)).thenReturn(Optional.of(medicamentoExistente));
        when(medicamentoRepository.save(medicamentoExistente)).thenReturn(medicamentoExistente);

        // Act
        Medicamento resultado = medicamentoService.atualizarMedicamento(id, medicamentoAtualizado);

        // Assert
        assertNotNull(resultado);
        assertEquals("Novo", resultado.getNome());
        assertEquals("Descrição atualizada", resultado.getDescricao());
        verify(medicamentoRepository, times(1)).findById(id);
        verify(medicamentoRepository, times(1)).save(medicamentoExistente);
    }
}