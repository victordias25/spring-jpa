package com.br.ecommerce.springjpa.controller;

import com.br.ecommerce.springjpa.controller.dto.PedidoRq;
import com.br.ecommerce.springjpa.controller.dto.PedidoRq2;
import com.br.ecommerce.springjpa.controller.dto.ProdutoResponse;
import com.br.ecommerce.springjpa.controller.dto.ProdutoRq;
import com.br.ecommerce.springjpa.model.Pedido;
import com.br.ecommerce.springjpa.model.Produto;
import com.br.ecommerce.springjpa.repository.ClienteRepository;
import com.br.ecommerce.springjpa.repository.PedidoRepository;
import com.br.ecommerce.springjpa.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;


    @PostMapping("/")
    public void cadastrarPedido(@RequestBody PedidoRq pedido){
        var p = new Pedido();
        Set<Produto> produto = new HashSet<>();
        p.setCliente(clienteRepository.getById(pedido.getIdCliente()));
        pedido.getProduto().forEach(product -> {
            produto.add(produtoRepository.getById(product));
        });
        p.setProdutos(produto);

        pedidoRepository.save(p);
    }

    @GetMapping("/")
    public PedidoRq2 findAll(){
        Pedido pedido = pedidoRepository.findById(1l).get();

        return new PedidoRq2().builder()
                .id(pedido.getId())
                .idCliente(pedido.getCliente())
                .produto(pedido.getProdutos())
                .build();
    }
}
