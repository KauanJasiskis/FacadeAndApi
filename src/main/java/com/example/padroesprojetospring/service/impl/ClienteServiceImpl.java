package com.example.padroesprojetospring.service.impl;

import com.example.padroesprojetospring.model.Cliente;
import com.example.padroesprojetospring.model.ClienteRepository;
import com.example.padroesprojetospring.model.Endereco;
import com.example.padroesprojetospring.model.EnderecoRepository;
import com.example.padroesprojetospring.service.ClienteService;
import com.example.padroesprojetospring.service.ViaCepService;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente inexistente"));
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);

    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = repository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco =  viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        repository.save(cliente);
    }

}
