package com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

public interface PessoaRepositoryPort {

    PessoaBO salvar(PessoaBO pessoaBO);

    Optional<PessoaBO> buscarPorId(UUID id);

    List<PessoaBO> buscarTodos();
}
