package com.br.ecommerce.springjpa.controller.dto;

import com.br.ecommerce.springjpa.model.Cliente;
import com.br.ecommerce.springjpa.model.Produto;

import java.math.BigDecimal;

public class ProdutoResponse {
    public static ProdutoResponse converter (Produto p){
        var produto = new ProdutoResponse();
        produto.setId_produto(p.getId());
        produto.setDescricao(p.getDescricao());
        produto.setQuantidade(p.getQuantidade());
        produto.setValor(p.getValor());
        return produto;
    }
    private Long id_produto;
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

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }
}
