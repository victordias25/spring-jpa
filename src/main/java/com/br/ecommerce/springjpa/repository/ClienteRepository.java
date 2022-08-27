package com.br.ecommerce.springjpa.repository;

import com.br.ecommerce.springjpa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
