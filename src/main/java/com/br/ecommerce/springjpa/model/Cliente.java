package com.br.ecommerce.springjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Entidade Cliente
@Entity @NoArgsConstructor
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCliente;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private String telefone;

    private String cep;

    private String logadouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

}