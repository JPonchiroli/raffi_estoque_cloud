package com.raffi_estoque.repositories;

import com.raffi_estoque.entities.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
    List<ItemVenda> findByVendaCodVenda(int codVenda);
}
