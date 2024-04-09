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

import com.adm.azs.shipping.domain.model.cliente.Cliente;
import com.adm.azs.shipping.domain.service.ClienteService;
import com.adm.azs.shipping.infrastructure.converter.modelmapper.service.ModelMapperService;
import com.adm.azs.shipping.presentation.dto.cliente.ClienteRequest;
import com.adm.azs.shipping.presentation.dto.cliente.ClienteResponse;



@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteServiceImp;
    
    @Autowired
    private ModelMapperService modelMapper;
    
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteServiceImp.criarCliente(modelMapper.convert(clienteRequest, Cliente.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.convert(cliente, ClienteResponse.class));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponse>> buscarTodosClientes(Pageable pageable) {
        Page<Cliente> clientesPage = clienteServiceImp.buscarTodos(pageable);
        return ResponseEntity.ok().body(clientesPage.map(cliente -> modelMapper.convert(cliente, ClienteResponse.class)));
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> buscarClientePorId(@PathVariable(value="clienteId") Long id) {
        Cliente cliente = clienteServiceImp.buscarPorId(id);
        return ResponseEntity.ok().body(modelMapper.convert(cliente, ClienteResponse.class));
    }
    
    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> atualizarCliente(@PathVariable(value="clienteId") Long id, @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteServiceImp.atualizarCliente(id, modelMapper.convert(clienteRequest, Cliente.class));
        return ResponseEntity.ok().body(modelMapper.convert(cliente, ClienteResponse.class));
    }
    
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> removerCliente(@PathVariable(value="clienteId") Long id) {
        clienteServiceImp.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
    
}
