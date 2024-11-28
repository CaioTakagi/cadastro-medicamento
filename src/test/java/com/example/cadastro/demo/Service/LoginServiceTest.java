package com.example.cadastro.demo.Service;

import com.example.cadastro.demo.repository.LoginRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Mock        // Simula um login repository pra não usar o banco de dados
    private LoginRepository loginRepository;

    @InjectMocks    // injeta o mock na classe login service para simular
    private LoginService loginService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retornarLoginSenhaAutorizado() {
        String nomeValido = "DrogaMil";
        String senhaValido = "123";

        boolean resultado = loginService.loginAutorizado(nomeValido, senhaValido);

        // retornar o login e senha autorizado e validado
        assertTrue(resultado);
    }

    @Test
    void retornarLoginSenhaInvalido() {
        String nomeInvalido = "rivaldo";
        String senhaInvalido = "pixUrubu10";

        boolean resultado = loginService.loginAutorizado(nomeInvalido, senhaInvalido);

        // retornar os logins e senhas invalidas
        assertFalse(resultado);
    }

    @Test
    void retornarLoginParcialmenteValido() {
        String nomeValido = "DrogaMil";
        String senhaInvalido = "seila123";

        boolean resultado = loginService.loginAutorizado(nomeValido, senhaInvalido);

        // retornar login valido e senha invalido
        assertFalse(resultado);
    }

    @Test
    void retornarCampoVazio() {
        boolean resultado = loginService.loginAutorizado(null, null);

        assertFalse(resultado);
    }



}