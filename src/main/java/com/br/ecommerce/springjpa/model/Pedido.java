package com.br.ecommerce.springjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "pedidos")
    private List<Produto> produtos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idCliente",
            referencedColumnName = "idCliente"
    )
    private Cliente cliente;


}
