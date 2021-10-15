package bg.softuni.Mobilelele.model.binding;


import bg.softuni.Mobilelele.model.validator.UniqueUserName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 2,max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2,max = 20)
    private String lastName;

    @NotNull
    @Size(min = 1,max = 30)
    @UniqueUserName
    private String username;

    @NotNull
    @Length(min = 5)
    private String password;

    @NotNull
    @Length(min = 5)
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
