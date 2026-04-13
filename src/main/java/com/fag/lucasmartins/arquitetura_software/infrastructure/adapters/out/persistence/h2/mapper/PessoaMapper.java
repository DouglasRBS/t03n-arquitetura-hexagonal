package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

@Component
public class PessoaMapper {

    
    public PessoaEntity toEntity(PessoaBO bo) {
        return new PessoaEntity(
                bo.getId(),
                bo.getNomeCompleto(),
                bo.getCpf(),
                bo.getDataNascimento(),
                bo.getEmail(),
                bo.getTelefone()
        );
    }

    public PessoaBO toBO(PessoaEntity entity) {
        return new PessoaBO(
                entity.getId(),
                entity.getNomeCompleto(),
                entity.getCpf(),
                entity.getDataNascimento(),
                entity.getEmail(),
                entity.getTelefone()
        );
    }
}
