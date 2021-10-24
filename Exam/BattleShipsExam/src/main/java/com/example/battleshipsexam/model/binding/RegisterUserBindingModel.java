package com.example.battleshipsexam.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserBindingModel {

    private String username;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterUserBindingModel(){

    }

    @Size(min=3,max = 10)
    @NotBlank
    public String getUsername() {
        return username;
    }

    public RegisterUserBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min=5,max = 20)
    @NotNull
    public String getFullName() {
        return fullName;
    }

    public RegisterUserBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Email
    @NotNull
    public String getEmail() {
        return email;
    }

    public RegisterUserBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Size(min=3)
    @NotNull
    public String getPassword() {
        return password;
    }

    public RegisterUserBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Size(min=3)
    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
