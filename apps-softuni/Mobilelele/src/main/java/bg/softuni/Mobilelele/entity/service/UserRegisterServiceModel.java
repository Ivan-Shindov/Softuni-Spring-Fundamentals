package bg.softuni.Mobilelele.entity.service;

import bg.softuni.Mobilelele.entity.binding.UserRegisterBindingModel;

public class UserRegisterServiceModel extends UserRegisterBindingModel {

    @Override
    public String getUsername() {
        return super.getUsername() != null ?super.getUsername().trim() : null;
    }
}
