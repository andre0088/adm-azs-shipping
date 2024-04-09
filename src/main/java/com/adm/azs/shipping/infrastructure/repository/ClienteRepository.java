package com.adm.azs.shipping.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adm.azs.shipping.domain.model.cliente.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    public Page<Cliente> findAll(Pageable pageable);
    
    public Cliente findById(long id);

}
