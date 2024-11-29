package com.example.cadastro.demo.Service;


import com.example.cadastro.demo.model.Login;
import com.example.cadastro.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

   private static final String ALLOWED_USERNAME = "a";
   private static final String ALLOWED_PASSWORD = "123";

   public List<Login> listarTodos() { //comando para listar todos logins
       return loginRepository.findAll();
   }

   public boolean loginAutorizado(String nome, String senha) {
       return ALLOWED_USERNAME.equals(nome) && ALLOWED_PASSWORD.equals(senha);
   }

}
