package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class ProdutoBO {

    private Integer id; // ✅ adicionar

    private String nome;

    private Integer estoque;

    private double preco;

    private double precoFinal;

    public void validarPrecoProdutoPremium() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            if (this.preco < 100.0) {
                throw new DomainException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    public void calcularPrecoFinalPorEstoqueBaixo() {
        if (estoque != null && estoque >= 50) {
            this.precoFinal = preco - (preco * 0.10);
        }
    }

    public void validarEstoqueDisponivel(int quantidade) { // ✅ implementar
        if (this.estoque == null || this.estoque < quantidade) {
            throw new DomainException("Estoque insuficiente para o produto: " + this.nome);
        }
    }

    public void diminuirEstoque(Integer quantidade) { // ✅ implementar
        validarEstoqueDisponivel(quantidade);
        this.estoque -= quantidade;
    }

    public void adicionarEstoque(Integer quantidade) { // ✅ implementar
        this.estoque += quantidade;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public double getPrecoFinal() { return precoFinal; }
    public void setPrecoFinal(double precoFinal) { this.precoFinal = precoFinal; }
}