package com.example.cadastro.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String fabricante;
    private String descricao;
    private int quantidade;
    private BigDecimal precoCusto; // aumenta numero limite
    private BigDecimal precoVenda;
    private LocalDate dataValidade;


    @ManyToOne     // Login é o chefe e ta mandando no Medicamento, vinculado
    @JoinColumn(name = "login_id")
    private Login login;
}
