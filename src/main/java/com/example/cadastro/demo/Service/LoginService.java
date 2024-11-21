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

   public List<Login> listarTodos() {
       return loginRepository.findAll();
   }
}
