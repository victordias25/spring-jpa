package com.br.ecommerce.springjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "produtos", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos = new HashSet<>();
}