package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.ProdutoEntity;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Integer> {
    List<ProdutoEntity> findByIdIn(List<Integer> ids); // ✅ adicionar isso
}