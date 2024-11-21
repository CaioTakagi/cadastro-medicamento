package com.example.cadastro.demo.Controller;


import com.example.cadastro.demo.Service.LoginService;
import com.example.cadastro.demo.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/listar")
    public List<Login> listarTodos() {
        return loginService.listarTodos();
    }
}
