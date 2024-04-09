package com.adm.azs.shipping.domain.model.cliente;

import java.util.ArrayList;
import java.util.List;

import com.adm.azs.shipping.domain.model.frete.Frete;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    
    public Cliente(){};
    

    public Cliente(Long clienteId, String nome, List<Frete> fretes) {
        super();
        this.clienteId = clienteId;
        this.nome = nome;
        this.fretes = fretes;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;

    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Frete> fretes = new ArrayList<>();



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }
    
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    
    
}
