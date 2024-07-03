package com.example.clientes.clientes.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clientes.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
