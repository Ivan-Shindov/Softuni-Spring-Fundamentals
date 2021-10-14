package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.entity.User;
import bg.softuni.Mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.Mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.Mobilelele.user.CurrentUser;

public interface UserService {

    boolean login(UserLoginServiceModel loginServiceModel);

    void initializeUsersAndRoles();

    void logout();

    void registerAndLogin(UserRegisterServiceModel userServiceModel);

    boolean isUserNameFree(String username);

    boolean isLogin();

    User findByUsername(String name);

    String getCurrentUserUsername();
}
