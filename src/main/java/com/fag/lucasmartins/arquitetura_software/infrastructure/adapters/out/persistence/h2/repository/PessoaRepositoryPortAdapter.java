package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaMapper;

@Component
public class PessoaRepositoryPortAdapter implements PessoaRepositoryPort {

    private final PessoaJpaRepository pessoaJpaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaRepositoryPortAdapter(PessoaJpaRepository pessoaJpaRepository, PessoaMapper pessoaMapper) {
        this.pessoaJpaRepository = pessoaJpaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        
        PessoaEntity entity = pessoaMapper.toEntity(pessoaBO);
        
        PessoaEntity salva = pessoaJpaRepository.save(entity);
        
        return pessoaMapper.toBO(salva);
    }

    @Override
    public Optional<PessoaBO> buscarPorId(UUID id) {
        return pessoaJpaRepository.findById(id)
                .map(pessoaMapper::toBO);
    }

    @Override
    public List<PessoaBO> buscarTodos() {
        return pessoaJpaRepository.findAll()
                .stream()
                .map(pessoaMapper::toBO)
                .collect(Collectors.toList());
    }
}
