package com.br.ecommerce.springjpa.controller;

import com.br.ecommerce.springjpa.controller.dto.ClienteResponse;
import com.br.ecommerce.springjpa.controller.dto.ClienteRq;
import com.br.ecommerce.springjpa.model.Cliente;
import com.br.ecommerce.springjpa.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/")
    public List<ClienteResponse> findAll(){
        var cliente = clienteRepository.findAll();
        return cliente
                .stream()
                .map(ClienteResponse::converter)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
        public ClienteResponse findById(@PathVariable("id") Long id){
            var cliente = clienteRepository.getOne(id);
                return ClienteResponse.converter(cliente);
    }
    @PostMapping("/")
    public void cadastrarCliente(@RequestBody ClienteRq cliente){
        var c = new Cliente();
        c.setNome(cliente.getNome());
        c.setSobrenome(cliente.getSobrenome());
        c.setCpf(cliente.getCpf());
        c.setEmail(cliente.getEmail());
        c.setTelefone(cliente.getTelefone());
        c.setCep(cliente.getCep());
        c.setLogadouro(cliente.getLogadouro());
        c.setNumero(cliente.getNumero());
        c.setComplemento(cliente.getComplemento());
        c.setBairro(cliente.getBairro());
        c.setCidade(cliente.getCidade());
        c.setEstado(cliente.getEstado());
        clienteRepository.save(c);
    }
    @PutMapping("/{id}")
    public void alterarCliente(@PathVariable("id") Long id, @RequestBody ClienteRq cliente) throws Exception {
        var c = clienteRepository.findById(id);

        if (c.isPresent()){
            var clienteSalvar = c.get();
            clienteSalvar.setNome(cliente.getNome());
            clienteSalvar.setSobrenome(cliente.getSobrenome());
            clienteSalvar.setCpf(cliente.getCpf());
            clienteSalvar.setEmail(cliente.getEmail());
            clienteSalvar.setTelefone(cliente.getTelefone());
            clienteSalvar.setCep(cliente.getCep());
            clienteSalvar.setLogadouro(cliente.getLogadouro());
            clienteSalvar.setNumero(cliente.getNumero());
            clienteSalvar.setComplemento(cliente.getComplemento());
            clienteSalvar.setBairro(cliente.getBairro());
            clienteSalvar.setCidade(cliente.getCidade());
            clienteSalvar.setEstado(cliente.getEstado());
            clienteRepository.save(clienteSalvar);
        }else{
            throw new Exception("Cliente não encontrado");
        }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable Long id) {
        var cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        clienteRepository.delete(cliente.get());
    }
}
