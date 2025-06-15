package com.raffi_estoque.repositories;

import com.raffi_estoque.dto.FornecedorNomeDto;
import com.raffi_estoque.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    List<Fornecedor> findByNomeFornecedorContainingIgnoreCase(String nomeFornecedor);
}
