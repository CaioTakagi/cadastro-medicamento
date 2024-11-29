package com.example.cadastro.demo.repository;

import com.example.cadastro.demo.model.Medicamento;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findAllByOrderByIdAsc();
    List<Medicamento> findAllByOrderByIdDesc();

    List<Medicamento> findAllByOrderByNomeAsc();
    List<Medicamento> findAllByOrderByNomeDesc();

    List<Medicamento> findAllByOrderByFabricanteAsc();
    List<Medicamento> findAllByOrderByFabricanteDesc();

    List<Medicamento> findAllByOrderByDescricaoAsc();
    List<Medicamento> findAllByOrderByDescricaoDesc();

    List<Medicamento> findAllByOrderByQuantidadeAsc();
    List<Medicamento> findAllByOrderByQuantidadeDesc();

    List<Medicamento> findAllByOrderByPrecoCustoAsc();
    List<Medicamento> findAllByOrderByPrecoCustoDesc();

    List<Medicamento> findAllByOrderByPrecoVendaAsc();
    List<Medicamento> findAllByOrderByPrecoVendaDesc();


    List<Medicamento> findAllByOrderByDataValidadeAsc();
    List<Medicamento> findAllByOrderByDataValidadeDesc();
}
