package com.example.cadastro.demo.repository;

import com.example.cadastro.demo.model.Login;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoginRepositoryTest {
    @Autowired
    private LoginRepository loginRepository;

    @Test
    void retornarLoginPeloNome() {
        Login login = new Login();
        login.setNome("DrogaMil");
        login.setSenha("123");
        loginRepository.save(login);

        Login buscarNome = loginRepository.findByNome("DrogaMil");
        assertNotNull(buscarNome);
        assertEquals("DrogaMil", buscarNome.getNome());
        assertEquals("123", buscarNome.getSenha());
    }

    @Test
    void retornarVazioSeNaoEncontrar() {
        Login naoRetornado = loginRepository.findByNome("usuario invalido ou inexistente");

        assertNull(naoRetornado);
    }



}