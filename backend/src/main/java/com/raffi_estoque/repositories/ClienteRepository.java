package com.raffi_estoque.repositories;

import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);
}
