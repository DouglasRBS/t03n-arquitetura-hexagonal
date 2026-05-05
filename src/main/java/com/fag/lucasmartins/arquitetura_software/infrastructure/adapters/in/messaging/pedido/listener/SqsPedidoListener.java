package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoSqsEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.PedidoSqsMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class SqsPedidoListener {

    private final ObjectMapper objectMapper;
    private final PedidoSqsMapper mapper;
    private final PedidoServicePort pedidoServicePort;

    public SqsPedidoListener(ObjectMapper objectMapper,
                            PedidoSqsMapper mapper,
                            PedidoServicePort pedidoServicePort) {
        this.objectMapper = objectMapper;
        this.mapper = mapper;
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener(value = "${aws.order-event}")
    public void receiveMessage(String message) {
        try {
            PedidoSqsEventDTO dto =
                    objectMapper.readValue(message, PedidoSqsEventDTO.class);

            PedidoBO pedidoBO = mapper.toBO(dto);

            pedidoServicePort.criarPedido(pedidoBO);

            System.out.println("Pedido processado com sucesso via SQS!");

        } catch (Exception e) {
            System.err.println("Erro ao processar mensagem SQS: " + e.getMessage());
        }
    }
}