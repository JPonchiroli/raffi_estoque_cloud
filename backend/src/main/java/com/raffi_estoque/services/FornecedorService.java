package com.raffi_estoque.services;

import com.raffi_estoque.dto.viacep.ViaCepResponse;
import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.feign.ViaCepClient;
import com.raffi_estoque.repositories.FornecedorRepository;
import com.raffi_estoque.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ViaCepClient viaCepclient;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    @Transactional
    public Fornecedor findById(Integer id){
        Optional<Fornecedor> event = fornecedorRepository.findById(id);
        return event.orElseThrow(() -> new ObjectNotFoundException("Fornecedor Não Encontrado"));
    }

    @Transactional
    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    @Transactional
    public Fornecedor update(Integer id, Fornecedor fornecedor){
        Fornecedor fornecedorUpd = findById(id);
        fornecedorUpd.setNomeFornecedor(fornecedor.getNomeFornecedor());
        fornecedorUpd.setEmail(fornecedor.getEmail());
        fornecedorUpd.setTelefone(fornecedor.getTelefone());
        return fornecedorRepository.save(fornecedorUpd);
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Fornecedor> fornecedor = Optional.ofNullable(fornecedorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Fornecedor Não Encontrado")));

        fornecedorRepository.deleteById(id);
    }

    public ViaCepResponse getAddress(String cep) {
        return viaCepclient.getAddress(cep);
    }

    public List<Fornecedor> findFornecedorPorNome (String nomeFornecedor) {
        return fornecedorRepository.findByNomeFornecedorContainingIgnoreCase(nomeFornecedor);
    }
}
