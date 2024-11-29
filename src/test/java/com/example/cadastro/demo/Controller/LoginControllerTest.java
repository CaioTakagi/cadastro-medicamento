package com.example.cadastro.demo.Controller;

import com.example.cadastro.demo.Service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    void loginSucesso() throws Exception {
        when(loginService.loginAutorizado("usuario", "senha")).thenReturn(true);

        mockMvc.perform(get("/api/login/login")
                .param("nome", "usuario")
                .param("senha", "senha"))
                .andExpect(status().isOk())
                .andExpect(content().string("Acesso liberado, bem vindo"));

    }

    @Test
    void testLoginComFalha() throws Exception {
        when(loginService.loginAutorizado("usuario", "senhaErrada")).thenReturn(false);

        mockMvc.perform(get("/api/login/login")
                        .param("nome", "usuario")
                        .param("senha", "senhaErrada"))
                .andExpect(status().isForbidden())
                .andExpect(content().string("Acesso Negado. Verifique suas credenciais."));
    }


}