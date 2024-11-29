package com.example.cadastro.demo.Controller;

import com.example.cadastro.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Alterado de @RestController para @Controller para suportar páginas HTML
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Renderizar a página de login (GET)
    @GetMapping("/login")
    public String mostrarPaginaDeLogin() {
        return "login"; // Nome do arquivo HTML (src/main/resources/templates/login.html)
    }

    // Validar o login (POST)
    @PostMapping("/login")
    public String validarLogin(@RequestParam String nome,
                               @RequestParam String senha,
                               Model model) {
        if (loginService.loginAutorizado(nome, senha)) {
            model.addAttribute("mensagem", "Acesso Liberado, Bem-Vindo ");
            return "redirect:/medicamentos"; // Substitua por um HTML que represente o sucesso
        } else {
            model.addAttribute("erro", "Acesso Negado, Tente novamente.");
            return "login"; // Retorna à página de login com mensagem de erro
        }
    }
}