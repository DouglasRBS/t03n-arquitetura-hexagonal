package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;

@Component
public class PessoaDTOMapper {

    public PessoaBO toBO(PessoaRequestDTO dto) {
        return new PessoaBO(
                UUID.randomUUID(),
                dto.getNomeCompleto(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getEmail(),
                dto.getTelefone()
        );
    }

    public PessoaResponseDTO toResponseDTO(PessoaBO bo) {
        return new PessoaResponseDTO(
                bo.getId(),
                bo.getNomeCompleto(),
                bo.getCpf(),
                bo.getDataNascimento(),
                bo.getEmail(),
                bo.getTelefone()
        );
    }
}
