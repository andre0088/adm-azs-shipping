package com.adm.azs.shipping.application.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.adm.azs.shipping.application.exception.ResourceNotFoundException;
import com.adm.azs.shipping.domain.model.cliente.Cliente;
import com.adm.azs.shipping.infrastructure.repository.ClienteRepository;

public class ClienteServiceImpTest {

    private ClienteServiceImp clienteService;
    private ClienteRepository clienteRepositoryMock;

    @BeforeEach
    public void setup() {
        clienteRepositoryMock = mock(ClienteRepository.class);
        clienteService = new ClienteServiceImp(clienteRepositoryMock);
    }

    @Test
    public void testBuscarTodosClientes() {
        Pageable pageable = mock(Pageable.class);
        Page<Cliente> pageClientes = mock(Page.class);
        when(clienteRepositoryMock.findAll(pageable)).thenReturn(pageClientes);

        Page<Cliente> result = clienteService.buscarTodos(pageable);

        assertEquals(pageClientes, result);
    }
    
    @Test
    public void testBuscarClientePorId() {
        Long clienteId = 1L;
        Cliente cliente = new Cliente();
        when(clienteRepositoryMock.findById(clienteId)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.buscarPorId(clienteId);

        assertEquals(cliente, result);
    }

    @Test
    public void testBuscarClientePorIdNotFound() {
        Long clienteId = 1L;
        when(clienteRepositoryMock.findById(clienteId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            clienteService.buscarPorId(clienteId);
        });
    }

    @Test
    public void testCriarCliente() {
        Cliente cliente = new Cliente();
        when(clienteRepositoryMock.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.criarCliente(cliente);

        assertEquals(cliente, result);
    }

    @Test
    public void testAtualizarCliente() {
        Long clienteId = 1L;
        Cliente clienteExistente = new Cliente();
        when(clienteRepositoryMock.findById(clienteId)).thenReturn(Optional.of(clienteExistente));

        Cliente clienteAtualizado = new Cliente();
        clienteAtualizado.setClienteId(clienteId);

        Cliente result = clienteService.atualizarCliente(clienteId, clienteAtualizado);

        assertEquals(clienteAtualizado, result);
    }
    
    @Test
    public void testAtualizarClienteNotFound() {
        Long clienteId = 1L;
        when(clienteRepositoryMock.findById(clienteId)).thenReturn(Optional.empty());
        Cliente clienteAtualizado = new Cliente();
        clienteAtualizado.setClienteId(clienteId);

        assertThrows(ResourceNotFoundException.class, () -> {
            clienteService.atualizarCliente(clienteId, clienteAtualizado);
        });
    }

    @Test
    public void testDeletarCliente() {
        Long clienteId = 1L;
        Cliente cliente = new Cliente();
        when(clienteRepositoryMock.findById(clienteId)).thenReturn(Optional.of(cliente));

        clienteService.deletarCliente(clienteId);

        verify(clienteRepositoryMock, times(1)).delete(cliente);
    }

    @Test
    public void testDeletarClienteNotFound() {
        Long clienteId = 1L;
        when(clienteRepositoryMock.findById(clienteId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            clienteService.deletarCliente(clienteId);
        });
    }
}
