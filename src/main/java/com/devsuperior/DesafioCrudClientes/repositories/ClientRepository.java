package com.devsuperior.DesafioCrudClientes.repositories;

import com.devsuperior.DesafioCrudClientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
