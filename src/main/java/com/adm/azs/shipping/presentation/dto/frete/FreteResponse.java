package com.adm.azs.shipping.presentation.dto.frete;

import java.util.Map;

public class FreteResponse {
    
    private Long freteId;
    
    private Long clienteId;
    
    private Map<String, String> propriedades;
    
    public Long getFreteId() {
        return freteId;
    }
    public void setFreteId(Long freteId) {
        this.freteId = freteId;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Map<String, String> getPropriedades() {
        return propriedades;
    }
    public void setPropriedades(Map<String, String> propriedades) {
        this.propriedades = propriedades;
    }
    
}
