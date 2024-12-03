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
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }



    @Test
    void testBuscarPorId_NotFound() {
        // Arrange
        when(medicamentoRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Medicamento resultado = medicamentoService.buscarPorId(1L);

        // Assert
        assertNull(resultado);
        verify(medicamentoRepository, times(1)).findById(1L);
    }


    @Test
    void testDeletarMedicamento() {
        // Arrange
        Long id = 1L;

        // Act
        medicamentoService.deletarMedicamento(id);

        // Assert
        verify(medicamentoRepository, times(1)).deleteById(id);
    }



}
