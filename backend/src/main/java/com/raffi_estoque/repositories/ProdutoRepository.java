package com.raffi_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raffi_estoque.entities.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);

    List<Produto> findByCodigoBarrasContaining(String codigoBarras);

}
