package com.br.ecommerce.springjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "pedidos")
    private Set<Produto> produtos = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idCliente",
            referencedColumnName = "idCliente"
    )
    private Cliente cliente;


}
