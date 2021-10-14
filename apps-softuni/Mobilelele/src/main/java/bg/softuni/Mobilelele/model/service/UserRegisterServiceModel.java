package bg.softuni.Mobilelele.model.service;

import bg.softuni.Mobilelele.model.binding.UserRegisterBindingModel;

public class UserRegisterServiceModel extends UserRegisterBindingModel {

    @Override
    public String getUsername() {
        return super.getUsername() != null ? super.getUsername().trim() : null;
    }
}
