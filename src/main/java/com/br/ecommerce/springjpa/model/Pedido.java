package com.br.ecommerce.springjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_produto9",
            joinColumns = {@JoinColumn(name="pedido_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="produto_id",referencedColumnName = "id")})
    private Set<Produto> produtos = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idCliente",
            referencedColumnName = "idCliente"
    )
    private Cliente cliente;


}
