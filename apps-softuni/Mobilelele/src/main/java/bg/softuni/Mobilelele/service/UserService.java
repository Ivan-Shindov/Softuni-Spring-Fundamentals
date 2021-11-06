package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.entity.User;
import bg.softuni.Mobilelele.model.service.UserRegisterServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLogin(UserRegisterServiceModel userServiceModel);

    boolean isUserNameFree(String username);

//    boolean isLogin();

    User findByUsername(String name);

//    String getCurrentUserUsername();
}
