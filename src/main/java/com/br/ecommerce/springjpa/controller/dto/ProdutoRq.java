package com.br.ecommerce.springjpa.controller.dto;

import java.math.BigDecimal;
public class ProdutoRq {
    private String descricao;
    private String quantidade;
    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
