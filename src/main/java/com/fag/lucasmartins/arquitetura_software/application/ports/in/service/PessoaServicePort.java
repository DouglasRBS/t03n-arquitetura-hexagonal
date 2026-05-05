package com.fag.lucasmartins.arquitetura_software.application.ports.in.service;

import java.util.List;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

public interface PessoaServicePort {
    PessoaBO cadastrar(PessoaBO pessoaBO);
    PessoaBO buscarPorId(Integer id);
    List<PessoaBO> listarTodos();
}