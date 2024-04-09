package com.adm.azs.shipping.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.adm.azs.shipping.application.exception.ResourceNotFoundException;
import com.adm.azs.shipping.domain.model.frete.Frete;
import com.adm.azs.shipping.domain.service.FreteService;
import com.adm.azs.shipping.infrastructure.repository.FreteRepository;

@Service
public class FreteServiceImp implements FreteService{
    

    
    private final FreteRepository freteRepository;

    @Autowired
    public FreteServiceImp(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    @Override
    public Page<Frete> buscarTodos(Pageable pageable) {
        return freteRepository.findAll(pageable);
    }

    @Override
    public Frete buscarPorId(Long id) {
        return freteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Frete criarFrete(Frete frete) {
        return freteRepository.save(frete);
    }

    @Override
    public Frete atualizarFrete(Long id, Frete freteAtualizado) {
        Frete freteExistente = buscarPorId(id);
        freteAtualizado.setFreteId(freteExistente.getFreteId());
        return freteRepository.save(freteAtualizado);
    }

    @Override
    public void deletarFrete(Long id) {
        Frete frete = buscarPorId(id);
        freteRepository.delete(frete);
    }

}
