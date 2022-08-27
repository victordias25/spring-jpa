package com.br.ecommerce.springjpa.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class PedidoRq {
    private Long id;
    private Long idCliente;
    private List<Long> produto;
}
