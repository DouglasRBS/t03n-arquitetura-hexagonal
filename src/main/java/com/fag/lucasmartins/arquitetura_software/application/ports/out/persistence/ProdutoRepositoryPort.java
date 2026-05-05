package com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence;

import java.util.List;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;

public interface ProdutoRepositoryPort {

    ProdutoBO salvar(ProdutoBO produtoBO);

    List<ProdutoBO> salvarTodos(List<ProdutoBO> produtosBO); // ✅ adicionar

    ProdutoBO encontrarPorId(Integer produtoId);

    List<ProdutoBO> encontrarPorIds(List<Integer> listaIdProduto); // ✅ adicionar
}