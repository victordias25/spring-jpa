package com.br.ecommerce.springjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@NoArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "produto_pedido",
            joinColumns = {@JoinColumn(name="pedido_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="produto_id",referencedColumnName = "id")})
    private Set<Produto> produtos = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "idCliente",
            referencedColumnName = "idCliente"
    )
    private Cliente cliente;


}
