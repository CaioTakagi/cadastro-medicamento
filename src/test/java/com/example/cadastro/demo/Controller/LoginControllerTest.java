package com.example.cadastro.demo.Controller;

import com.example.cadastro.demo.Service.LoginService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoginController.class) // Indica que estamos testando o controlador
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simula as requisições HTTP

    @MockBean
    private LoginService loginService; // Mock para a camada de serviço

    @Test
    public void deveRetornarPaginaDeLogin() throws Exception {
        mockMvc.perform(get("/api/login"))
                .andExpect(status().isOk()) // Verifica se o status é 200 (OK)
                .andExpect(view().name("login")); // Verifica se a view retornada é "login"
    }

    @Test
    public void deveValidarLoginComSucesso() throws Exception {
        // Configurando o comportamento do mock
        Mockito.when(loginService.loginAutorizado("admin", "123")).thenReturn(true);

        mockMvc.perform(post("/api/login")
                        .param("nome", "admin")
                        .param("senha", "123"))
                .andExpect(status().is3xxRedirection()) // Verifica redirecionamento
                .andExpect(redirectedUrl("/medicamentos")); // Verifica URL de redirecionamento
    }

    @Test
    public void deveFalharNaValidacaoDeLogin() throws Exception {
        // Configurando o comportamento do mock
        Mockito.when(loginService.loginAutorizado("admin", "senhaIncorreta")).thenReturn(false);

        mockMvc.perform(post("/api/login")
                        .param("nome", "admin")
                        .param("senha", "senhaIncorreta"))
                .andExpect(status().isOk()) // Página de login é carregada novamente
                .andExpect(view().name("login")) // Verifica se retorna à view "login"
                .andExpect(model().attributeExists("erro")); // Verifica se o modelo contém o atributo "erro"
    }
}
