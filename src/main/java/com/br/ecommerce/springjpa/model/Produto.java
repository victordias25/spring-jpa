package com.br.ecommerce.springjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Entidade Produto
@Entity
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@NoArgsConstructor
@Table (name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String descricao;

    private String quantidade;

    private BigDecimal valor;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "produtos", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos = new HashSet<>();
}