package com.br.ecommerce.springjpa.repository;

import com.br.ecommerce.springjpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
