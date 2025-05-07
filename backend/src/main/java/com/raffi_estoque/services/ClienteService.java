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
    private ClienteRepository eventRepository;

    @Autowired
    private ViaCepClient viaCepclient;

    @Transactional
    public Cliente save(Cliente event){
        return eventRepository.save(event);
    }

    @Transactional
    public Cliente findById(Integer id){
        Optional<Cliente> event = eventRepository.findById(id);
        return event.orElseThrow(() -> new ObjectNotFoundException("Cliente Não Encontrado"));
    }

    @Transactional
    public List<Cliente> findAll(){
        return eventRepository.findAll();
    }

    @Transactional
    public Cliente update(Integer id, Cliente event){
        Cliente eventUpd = findById(id);
        eventUpd.setNomeCliente(event.getNomeCliente());
        eventUpd.setComplemento(event.getComplemento());
        return eventRepository.save(eventUpd);
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Cliente> event = eventRepository.findById(id);

        eventRepository.deleteById(id);
    }

    public ViaCepResponse getAddress(String cep) {
        return viaCepclient.getAddress(cep);
    }


}
