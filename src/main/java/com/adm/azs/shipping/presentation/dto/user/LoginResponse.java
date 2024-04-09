package com.adm.azs.shipping.presentation.dto.user;

public class LoginResponse {

    public LoginResponse(String token) {
        this.token = token;
    }
    
    public LoginResponse() {};
    
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
