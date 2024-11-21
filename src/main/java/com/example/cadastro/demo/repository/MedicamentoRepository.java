package com.example.cadastro.demo.repository;

import com.example.cadastro.demo.model.Medicamento;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
