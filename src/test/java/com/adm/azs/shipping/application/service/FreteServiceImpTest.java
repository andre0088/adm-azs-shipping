package com.adm.azs.shipping.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.adm.azs.shipping.application.exception.ResourceNotFoundException;
import com.adm.azs.shipping.domain.model.frete.Frete;
import com.adm.azs.shipping.infrastructure.repository.FreteRepository;

public class FreteServiceImpTest {

    private FreteServiceImp freteService;
    private FreteRepository freteRepositoryMock;

    @BeforeEach
    public void setup() {
        freteRepositoryMock = mock(FreteRepository.class);
        freteService = new FreteServiceImp(freteRepositoryMock);
    }

    @Test
    public void testBuscarTodosFretes() {
        Pageable pageable = mock(Pageable.class);
        Page<Frete> pageFretes = mock(Page.class);
        when(freteRepositoryMock.findAll(pageable)).thenReturn(pageFretes);

        Page<Frete> result = freteService.buscarTodos(pageable);

        assertEquals(pageFretes, result);
    }
    
    @Test
    public void testBuscarFretePorId() {
        Long freteId = 1L;
        Frete frete = new Frete();
        when(freteRepositoryMock.findById(freteId)).thenReturn(Optional.of(frete));

        Frete result = freteService.buscarPorId(freteId);

        assertEquals(frete, result);
    }

    @Test
    public void testBuscarFretePorIdNotFound() {
        Long freteId = 1L;
        when(freteRepositoryMock.findById(freteId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            freteService.buscarPorId(freteId);
        });
    }

    @Test
    public void testCriarFrete() {
        Frete frete = new Frete();
        when(freteRepositoryMock.save(frete)).thenReturn(frete);

        Frete result = freteService.criarFrete(frete);

        assertEquals(frete, result);
    }
    
    @Test
    public void testAtualizarFreteNotFound() {
        Long freteId = 1L;
        when(freteRepositoryMock.findById(freteId)).thenReturn(Optional.empty());
        Frete freteAtualizado = new Frete();
        freteAtualizado.setFreteId(freteId);

        assertThrows(ResourceNotFoundException.class, () -> {
            freteService.atualizarFrete(freteId, freteAtualizado);
        });
    }

    @Test
    public void testDeletarFrete() {
        Long freteId = 1L;
        Frete frete = new Frete();
        when(freteRepositoryMock.findById(freteId)).thenReturn(Optional.of(frete));

        freteService.deletarFrete(freteId);

        verify(freteRepositoryMock, times(1)).delete(frete);
    }

    @Test
    public void testDeletarFreteNotFound() {
        Long freteId = 1L;
        when(freteRepositoryMock.findById(freteId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            freteService.deletarFrete(freteId);
        });
    }
}
