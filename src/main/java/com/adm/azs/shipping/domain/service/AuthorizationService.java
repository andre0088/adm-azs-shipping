package com.adm.azs.shipping.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AuthorizationService {
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
