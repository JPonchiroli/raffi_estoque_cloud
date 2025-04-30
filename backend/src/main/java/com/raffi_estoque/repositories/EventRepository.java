package com.raffi_estoque.repositories;

import com.raffi_estoque.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Cliente, Long> {
}
