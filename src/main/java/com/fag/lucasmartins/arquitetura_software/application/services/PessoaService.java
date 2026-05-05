package com.fag.lucasmartins.arquitetura_software.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort pessoaRepositoryPort;

    public PessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
    }

    @Override
    public PessoaBO cadastrar(PessoaBO pessoaBO) {
        return pessoaRepositoryPort.salvar(pessoaBO);
    }

    @Override
    public PessoaBO buscarPorId(Integer id) {
        return pessoaRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new DomainException("Pessoa não encontrada com o id: " + id));
    }

    @Override
    public List<PessoaBO> listarTodos() {
        return pessoaRepositoryPort.buscarTodos();
    }
}