package com.br.ecommerce.springjpa.controller.dto;

import com.br.ecommerce.springjpa.model.Cliente;
public class ClienteResponse {
    public static ClienteResponse converter (Cliente c){
        var cliente = new ClienteResponse();
        cliente.setId(c.getIdCliente());
        cliente.setNome(c.getNome());
        cliente.setSobrenome(c.getSobrenome());
        cliente.setCpf(c.getCpf());
        cliente.setEmail(c.getEmail());
        cliente.setTelefone(c.getTelefone());
        cliente.setCep(c.getCep());
        cliente.setLogadouro(c.getLogadouro());
        cliente.setNumero(c.getNumero());
        cliente.setComplemento(c.getComplemento());
        cliente.setBairro(c.getBairro());
        cliente.setCidade(c.getCidade());
        cliente.setEstado(c.getEstado());
        return cliente;
    }
    private Long id_cliente;
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

    public Long getId() {
        return id_cliente;
    }

    public void setId(Long id) {
        this.id_cliente = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
