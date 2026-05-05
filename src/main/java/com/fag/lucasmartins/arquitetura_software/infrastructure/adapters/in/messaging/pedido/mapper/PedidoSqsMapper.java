package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.*;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoSqsEventDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoSqsMapper {

    public PedidoBO toBO(PedidoSqsEventDTO dto) {

        PessoaBO pessoa = new PessoaBO();
        pessoa.setId(dto.getCustomerId());

        List<PedidoProdutoBO> itens = dto.getOrderItems()
                .stream()
                .map(item -> {
                    ProdutoBO produto = new ProdutoBO();
                    produto.setId(item.getSku());

                    PedidoProdutoBO pp = new PedidoProdutoBO();
                    pp.setProduto(produto);
                    pp.setQuantidade(item.getAmount());
                    return pp;
                })
                .collect(Collectors.toList());

        PedidoBO pedido = new PedidoBO();
        pedido.setPessoa(pessoa);
        pedido.setItens(itens);
        pedido.setCep(dto.getZipCode());

        return pedido;
    }
}