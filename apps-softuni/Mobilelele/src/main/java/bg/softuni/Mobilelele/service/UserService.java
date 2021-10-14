package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.Mobilelele.model.service.UserRegisterServiceModel;

public interface UserService {

    boolean login(UserLoginServiceModel loginServiceModel);

    void initializeUsersAndRoles();

    void logout();

    void registerAndLogin(UserRegisterServiceModel userServiceModel);

    boolean isUserNameFree(String username);
}
