package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.exceptions.RepositorioException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaMapper;

@Component
public class PessoaRepositoryPortAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository pessoaJpaRepository;

    public PessoaRepositoryPortAdapter(PessoaJpaRepository pessoaJpaRepository) {
        this.pessoaJpaRepository = pessoaJpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        return PessoaMapper.toBO(pessoaJpaRepository.save(PessoaMapper.toEntity(pessoaBO)));
    }

    @Override
    public Optional<PessoaBO> buscarPorId(Integer id) {
        return pessoaJpaRepository.findById(id)
                .map(PessoaMapper::toBO);
    }

    @Override
    public PessoaBO encontrarPorId(Integer id) {
        return buscarPorId(id)
                .orElseThrow(() -> new RepositorioException("Pessoa não encontrada para o ID: " + id));
    }

    @Override
    public List<PessoaBO> buscarTodos() {
        return pessoaJpaRepository.findAll()
                .stream()
                .map(PessoaMapper::toBO)
                .collect(Collectors.toList());
    }
}