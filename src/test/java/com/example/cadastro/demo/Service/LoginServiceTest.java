package com.example.cadastro.demo.Service;

import com.example.cadastro.demo.model.Login;
import com.example.cadastro.demo.repository.LoginRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginServiceTest {

    @Mock
    private LoginRepository loginRepository;

    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }


    @Test
    void testLoginAutorizado_Success() {
        // Act: Chama o método com credenciais corretas
        boolean resultado = loginService.loginAutorizado("admin", "123");

        // Assert: Deve retornar verdadeiro
        assertTrue(resultado);
    }

    @Test
    void testLoginAutorizado_Failure() {
        // Act: Chama o método com credenciais incorretas
        boolean resultado = loginService.loginAutorizado("wrongUser", "wrongPassword");

        // Assert: Deve retornar falso
        assertFalse(resultado);
    }
}
