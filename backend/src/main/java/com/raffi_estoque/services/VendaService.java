package com.raffi_estoque.services;

import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.entities.Venda;
import com.raffi_estoque.repositories.VendaRepository;
import com.raffi_estoque.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public Venda save(Venda venda){ return vendaRepository.save(venda); }

    @Transactional
    public Venda findById(Integer id){
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.orElseThrow(() -> new ObjectNotFoundException("Venda Não Encontrada"));
    }

    @Transactional
    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    @Transactional
    public Venda update(Integer id, Venda venda){
        Venda produtoUpd = findById(id);
        produtoUpd.setCliente(venda.getCliente());
        produtoUpd.setProdutos(venda.getProdutos());
        return vendaRepository.save(produtoUpd);
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Venda> event = Optional.ofNullable(vendaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Venda Não Encontrada")));

        vendaRepository.deleteById(id);
    }
}
