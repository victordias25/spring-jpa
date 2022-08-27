package com.br.ecommerce.springjpa.controller;

import com.br.ecommerce.springjpa.controller.dto.ProdutoResponse;
import com.br.ecommerce.springjpa.controller.dto.ProdutoRq;
import com.br.ecommerce.springjpa.model.Produto;
import com.br.ecommerce.springjpa.repository.ProdutoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/")
    @Cacheable("/produto")
    public List<ProdutoResponse> findAll(){
        var produto = produtoRepository.findAll();
        return produto
                .stream()
                .map(ProdutoResponse::converter)
                .collect(Collectors.toList());
    }
    @Cacheable("/produto")
    @GetMapping("/{id}")
        public ProdutoResponse findById(@PathVariable("id") Long id){
            var produto = produtoRepository.getOne(id);
                return ProdutoResponse.converter(produto);
    }
    @Cacheable("/produto")
    @PostMapping("/")
    public void cadastrarProduto(@RequestBody ProdutoRq produto){
        var p = new Produto();
        p.setDescricao(produto.getDescricao());
        p.setQuantidade(produto.getQuantidade());
        p.setValor(produto.getValor());
        produtoRepository.save(p);
    }
    @Cacheable("/produto")
    @PutMapping("/{id}")
    public void alterarProduto(@PathVariable("id") Long id, @RequestBody ProdutoRq produto) throws Exception {
        var p = produtoRepository.findById(id);

        if (p.isPresent()){
            var produtoSalvar = p.get();
            produtoSalvar.setDescricao(produto.getDescricao());
            produtoSalvar.setQuantidade(produto.getQuantidade());
            produtoSalvar.setValor(produto.getValor());
            produtoRepository.save(produtoSalvar);
        }else{
            throw new Exception("Produto não encontrado");
        }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirProduto(@PathVariable Long id) {
        var produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        produtoRepository.delete(produto.get());
    }
    @CacheEvict("produto")
    public String limparCache(){
        System.out.println("Limpando Cahe");
        return "Limpando";
    }
}
