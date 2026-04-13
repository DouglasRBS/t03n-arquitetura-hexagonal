package com.fag.lucasmartins.arquitetura_software.application.ports.in.service;

import java.util.List;
import java.util.UUID;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

public interface PessoaServicePort {

    PessoaBO cadastrar(PessoaBO pessoaBO);

    PessoaBO buscarPorId(UUID id);

    List<PessoaBO> listarTodos();
}
