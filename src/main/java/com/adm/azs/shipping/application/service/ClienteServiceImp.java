package com.adm.azs.shipping.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.adm.azs.shipping.application.exception.ResourceNotFoundException;
import com.adm.azs.shipping.domain.model.cliente.Cliente;
import com.adm.azs.shipping.domain.service.ClienteService;
import com.adm.azs.shipping.infrastructure.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService{
    
    
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public Page<Cliente> buscarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }
    

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarPorId(id);
        clienteAtualizado.setClienteId(clienteExistente.getClienteId());
        return clienteRepository.save(clienteAtualizado);
    }

    @Override
    public void deletarCliente(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }

}
