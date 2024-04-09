package com.adm.azs.shipping.presentation.dto.cliente;

import java.util.List;

import com.adm.azs.shipping.presentation.dto.frete.FreteResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ClienteResponse {
    
    private Long clienteId;
    
    private String nome;
    
    @JsonIgnoreProperties("FreteId") 
    private List<FreteResponse> fretes;
    
    
    public Long getClienteId() {
        return clienteId;
    }
    
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<FreteResponse> getFretes() {
        return fretes;
    }

    public void setFretes(List<FreteResponse> fretes) {
        this.fretes = fretes;
    }
 
}
