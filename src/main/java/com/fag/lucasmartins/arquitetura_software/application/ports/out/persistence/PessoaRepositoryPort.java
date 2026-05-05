package com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence;

import java.util.List;
import java.util.Optional;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

public interface PessoaRepositoryPort {

    PessoaBO salvar(PessoaBO pessoaBO);

    Optional<PessoaBO> buscarPorId(Integer id);

    PessoaBO encontrarPorId(Integer id);

    List<PessoaBO> buscarTodos();
}