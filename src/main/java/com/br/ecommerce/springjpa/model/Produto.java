package com.br.ecommerce.springjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Entidade Produto
@Entity
@Data
@NoArgsConstructor
@Table (name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String descricao;

    private String quantidade;

    private BigDecimal valor;

    @ManyToMany
    @JoinTable(name = "produto_pedido",
            joinColumns = {@JoinColumn(name="produto_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="cliente_id",referencedColumnName = "id")})
    private List<Pedido> pedidos = new ArrayList<Pedido>();
}