package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.entity.service.UserLoginServiceModel;
import bg.softuni.Mobilelele.entity.service.UserRegisterServiceModel;

public interface UserService {

    boolean login(UserLoginServiceModel loginServiceModel);

    void initializeUsersAndRoles();

    void logout();

    void registerAndLogin(UserRegisterServiceModel userServiceModel);
}
