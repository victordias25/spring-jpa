package com.br.ecommerce.springjpa.controller;

import com.br.ecommerce.springjpa.controller.dto.PedidoRq;
import com.br.ecommerce.springjpa.controller.dto.ProdutoRq;
import com.br.ecommerce.springjpa.model.Pedido;
import com.br.ecommerce.springjpa.model.Produto;
import com.br.ecommerce.springjpa.repository.ClienteRepository;
import com.br.ecommerce.springjpa.repository.PedidoRepository;
import com.br.ecommerce.springjpa.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
        ArrayList<Produto> produto = new ArrayList<>();
        p.setCliente(clienteRepository.getById(pedido.getIdCliente()));

        pedido.getProduto().forEach(product -> {
            produto.add(produtoRepository.getById(product));
        });
        p.setProdutos(produto);

        pedidoRepository.save(p);
    }
}
