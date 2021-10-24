package com.example.battleshipsexam.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginUserBindingModel {

    private String username;
    private String password;

    public LoginUserBindingModel(){

    }

    @Size(min=3,max = 10)
    @NotBlank
    public String getUsername() {
        return username;
    }

    public LoginUserBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min=3)
    @NotNull
    public String getPassword() {
        return password;
    }

    public LoginUserBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
