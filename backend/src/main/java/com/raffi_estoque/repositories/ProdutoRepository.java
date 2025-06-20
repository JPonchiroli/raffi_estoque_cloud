package com.raffi_estoque.repositories;

import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);
}
