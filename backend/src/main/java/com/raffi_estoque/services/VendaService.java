package com.raffi_estoque.services;

import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.entities.ItemVenda;
import com.raffi_estoque.entities.Venda;
import com.raffi_estoque.repositories.ClienteRepository;
import com.raffi_estoque.repositories.ItemVendaRepository;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Transactional
    public Venda save(Venda venda){
        return vendaRepository.save(venda);
    }

    @Transactional
    public Venda findById(Integer id){
        Optional<Venda> event = vendaRepository.findById(id);
        return event.orElseThrow(() -> new ObjectNotFoundException("Venda Não Encontrada"));
    }

    @Transactional
    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }
    
    @Transactional
    public void update(Integer id, Venda venda){}

    @Transactional
    public void deleteById(Integer id) {
        Optional<Venda> venda = Optional.ofNullable(vendaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Venda Não Encontrada")));

        vendaRepository.deleteById(id);
    }

    public List<ItemVenda> findItensVendaByVendaId(int codVenda) {
        List<ItemVenda> itens = itemVendaRepository.findByVendaCodVenda(codVenda);
        if (itens.isEmpty()) {
            throw new ObjectNotFoundException("Nenhum item encontrado para a venda " + codVenda);
        }
        return itens;
    }
}
