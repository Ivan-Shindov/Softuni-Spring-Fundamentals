package bg.softuni.Mobilelele.entity.service;

public class UserLoginServiceModel {

    private String username;
    private String rawPass;

    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRawPass() {
        return rawPass;
    }

    public UserLoginServiceModel setRawPass(String rawPass) {
        this.rawPass = rawPass;
        return this;
    }
}
