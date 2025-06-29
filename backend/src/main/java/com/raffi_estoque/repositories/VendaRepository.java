package com.raffi_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raffi_estoque.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
