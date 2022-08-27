package com.br.ecommerce.springjpa.repository;

import com.br.ecommerce.springjpa.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

}
