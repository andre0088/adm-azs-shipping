package com.adm.azs.shipping.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.azs.shipping.domain.model.user.User;
import com.adm.azs.shipping.infrastructure.repository.UserRepository;
import com.adm.azs.shipping.infrastructure.security.TokenService;
import com.adm.azs.shipping.presentation.dto.user.AuthenticationDTO;
import com.adm.azs.shipping.presentation.dto.user.LoginResponse;
import com.adm.azs.shipping.presentation.dto.user.RegisterDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        
        var token = tokenService.generateToken((User)auth.getPrincipal());
        
        return ResponseEntity.ok(new LoginResponse(token));
    }
    
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User newUser = new User(data.getLogin(), encryptedPassword, data.getRole());
        
        this.repository.save(newUser);
        
        return ResponseEntity.ok().build();
    }
    
}
