package com.example.cadastro.demo.repository;

import com.example.cadastro.demo.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
        Login findByNome(String nome);
}
