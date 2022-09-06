package com.br.ecommerce.springjpa.controller.dto;

import com.br.ecommerce.springjpa.model.Cliente;
import com.br.ecommerce.springjpa.model.Pedido;
import com.br.ecommerce.springjpa.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoRq2 {
    private Long id;
    private Cliente idCliente;
    private Set<Produto> produto;
}
