package com.example.cadastro.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data             // Data = Getter, Setter, Construtores, Hashequals
@Entity           // Login é principal
@NoArgsConstructor // nao precisa passar as variave no construtor
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;

}
