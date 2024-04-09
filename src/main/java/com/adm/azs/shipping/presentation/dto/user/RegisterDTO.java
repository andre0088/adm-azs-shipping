package com.adm.azs.shipping.presentation.dto.user;

import com.adm.azs.shipping.domain.model.user.UserRole;

public class RegisterDTO {
    
    private String login;
    
    private String password;
    
    private UserRole role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
}
