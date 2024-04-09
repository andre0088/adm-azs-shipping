package com.adm.azs.shipping.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.azs.shipping.domain.model.frete.Frete;
import com.adm.azs.shipping.domain.service.FreteService;
import com.adm.azs.shipping.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adm.azs.shipping.presentation.dto.frete.FreteRequest;
import com.adm.azs.shipping.presentation.dto.frete.FreteResponse;



@RestController
@RequestMapping("/fretes")
public class FreteController {
    
    @Autowired
    private FreteService freteServiceImp;

    @Autowired
    private ModelMapperService modelMapper;

    @GetMapping
    public ResponseEntity<Page<FreteResponse>> buscarTodosFretes(Pageable pageable) {
        Page<Frete> fretesPage = freteServiceImp.buscarTodos(pageable);
        return ResponseEntity.ok().body(fretesPage.map(frete -> modelMapper.convert(frete, FreteResponse.class)));
    }

    @GetMapping("/{freteId}")
    public ResponseEntity<FreteResponse> buscarFretePorId(@PathVariable(value="freteId") Long id) {
        Frete frete = freteServiceImp.buscarPorId(id);
        return ResponseEntity.ok().body(modelMapper.convert(frete, FreteResponse.class));
    }

    @PostMapping
    public ResponseEntity<FreteResponse> criarFrete(@RequestBody FreteRequest freteRequest) {
        Frete frete = freteServiceImp.criarFrete(modelMapper.convert(freteRequest, Frete.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convert(frete, FreteResponse.class));
    }

    @PutMapping("/{freteId}")
    public ResponseEntity<FreteResponse> atualizarFrete(@PathVariable(value="freteId") Long id, @RequestBody FreteRequest freteRequest) {
        Frete frete = freteServiceImp.atualizarFrete(id, modelMapper.convert(freteRequest, Frete.class));
        return ResponseEntity.ok().body(modelMapper.convert(frete, FreteResponse.class));
    }

    @DeleteMapping("/{freteId}")
    public ResponseEntity<Void> deletarFrete(@PathVariable(value="freteId") Long id) {
        freteServiceImp.deletarFrete(id);
        return ResponseEntity.noContent().build();
    }
    
}
