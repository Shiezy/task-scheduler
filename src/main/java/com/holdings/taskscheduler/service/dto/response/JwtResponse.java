package com.holdings.taskscheduler.service.dto.response;

import java.util.List;

public class JwtResponse {

    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String phone;
    private String email;
    private String expiry;
    private List<String> roles;

    public JwtResponse(String token, Long id, String phone, String email, List<String> roles) {
        this.accessToken = token;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.roles = roles;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
