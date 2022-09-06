package com.br.ecommerce.springjpa.repository;

import com.br.ecommerce.springjpa.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
    List<Pedido> findPedidoByProdutosId(Long id);

}
