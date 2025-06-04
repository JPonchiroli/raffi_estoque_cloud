package com.raffi_estoque.repositories;

import com.raffi_estoque.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
