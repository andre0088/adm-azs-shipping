package com.adm.azs.shipping.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.adm.azs.shipping.domain.model.cliente.Cliente;

@Service
public interface ClienteService {
    
    public Page<Cliente> buscarTodos(Pageable pageable);
    
    public Cliente buscarPorId(Long id);
    
    public Cliente criarCliente(Cliente cliente);
    
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado);
    
    public void deletarCliente(Long id);
    
}
