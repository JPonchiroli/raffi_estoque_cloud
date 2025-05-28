package com.raffi_estoque.services;

import com.raffi_estoque.dto.ViaCepResponse;
import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.feign.ViaCepClient;
import com.raffi_estoque.repositories.ClienteRepository;
import com.raffi_estoque.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViaCepClient viaCepclient;

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente findById(Integer id){
        Optional<Cliente> event = clienteRepository.findById(id);
        return event.orElseThrow(() -> new ObjectNotFoundException("Cliente Não Encontrado"));
    }

    @Transactional
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente update(Integer id, Cliente cliente){
        Cliente clienteUpd = findById(id);
        clienteUpd.setNomeCliente(cliente.getNomeCliente());
        clienteUpd.setComplemento(cliente.getComplemento());
        return clienteRepository.save(clienteUpd);
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Cliente> event = clienteRepository.findById(id);

        clienteRepository.deleteById(id);
    }

    public ViaCepResponse getAddress(String cep) {
        return viaCepclient.getAddress(cep);
    }

}
