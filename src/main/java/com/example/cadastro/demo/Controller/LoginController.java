package com.example.cadastro.demo.Controller;


import com.example.cadastro.demo.Service.LoginService;
import com.example.cadastro.demo.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;    // Controller é a pasta onde faço o spring andar

@RestController    // comando os controles no geral e suporte
@RequestMapping("/api/login")    // vinculado rest
public class LoginController {

    @Autowired    // vinculado rest
    private LoginService loginService;

    @GetMapping("/login")    // vinculado rest
    public ResponseEntity<String> login(@RequestParam String nome, @RequestParam String senha) {
        if (loginService.loginAutorizado(nome, senha)) {
            return ResponseEntity.ok("Acesso Liberado, Bem-Vindo");
        } else  {
            return ResponseEntity.status(403).body("Acesso Negado, Login ou Senha inválido tente novamente");
        }
    }
}
