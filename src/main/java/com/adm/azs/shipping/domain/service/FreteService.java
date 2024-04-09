package com.adm.azs.shipping.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.adm.azs.shipping.domain.model.frete.Frete;

@Service
public interface FreteService {

    public Page<Frete> buscarTodos(Pageable pageable);
    
    public Frete buscarPorId(Long id);
    
    public Frete criarFrete(Frete frete);
    
    public Frete atualizarFrete(Long id, Frete freteAtualizado);
    
    public void deletarFrete(Long id);
    
}
