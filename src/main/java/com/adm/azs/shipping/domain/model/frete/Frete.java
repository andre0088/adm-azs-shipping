package com.adm.azs.shipping.domain.model.frete;

import java.util.HashMap;
import java.util.Map;

import com.adm.azs.shipping.domain.model.cliente.Cliente;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;

@Entity
public class Frete {
    
    public Frete() {};
    
    public Frete(Long freteId, Cliente cliente, Map<String, String> propriedades) {
        super();
        this.freteId = freteId;
        this.cliente = cliente;
        this.propriedades = propriedades;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long freteId;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ElementCollection
    @CollectionTable(name = "frete_propriedades")
    @MapKeyJoinColumn(name = "frete_id")
    @Column(name = "valor")
    private Map<String, String> propriedades = new HashMap<>();

    public Long getFreteId() {
        return freteId;
    }

    public void setFreteId(Long freteId) {
        this.freteId = freteId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<String, String> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(Map<String, String> propriedades) {
        this.propriedades = propriedades;
    }
    
    

}
