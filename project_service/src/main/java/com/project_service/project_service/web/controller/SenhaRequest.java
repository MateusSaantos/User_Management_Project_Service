package com.project_service.project_service.web.controller;

public class SenhaRequest {
    private String password;

    public SenhaRequest() {
    }

    public SenhaRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
