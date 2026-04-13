package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaServicePort;
    private final PessoaDTOMapper pessoaDTOMapper;

    public PessoaControllerAdapter(PessoaServicePort pessoaServicePort, PessoaDTOMapper pessoaDTOMapper) {
        this.pessoaServicePort = pessoaServicePort;
        this.pessoaDTOMapper = pessoaDTOMapper;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrar(@RequestBody PessoaRequestDTO requestDTO) {
        
        PessoaBO pessoaBO = pessoaDTOMapper.toBO(requestDTO);

        PessoaBO pessoaSalva = pessoaServicePort.cadastrar(pessoaBO);

        PessoaResponseDTO responseDTO = pessoaDTOMapper.toResponseDTO(pessoaSalva);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPorId(@PathVariable UUID id) {
        PessoaBO pessoaBO = pessoaServicePort.buscarPorId(id);
        return ResponseEntity.ok(pessoaDTOMapper.toResponseDTO(pessoaBO));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listarTodos() {
        List<PessoaResponseDTO> lista = pessoaServicePort.listarTodos()
                .stream()
                .map(pessoaDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
