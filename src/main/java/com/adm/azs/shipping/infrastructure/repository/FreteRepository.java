package com.adm.azs.shipping.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adm.azs.shipping.domain.model.frete.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{
    
    public Frete findById(long id);
    public Page<Frete> findAll(Pageable pageable);

}
