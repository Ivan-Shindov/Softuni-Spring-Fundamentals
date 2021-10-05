package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.entity.User;
import bg.softuni.Mobilelele.entity.service.UserLoginServiceModel;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.service.UserService;
import bg.softuni.Mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
                           CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }





    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<User> userEntityOpt = userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(
                    loginServiceModel.getRawPass(),
                    userEntityOpt.get().getPassword());

            if (success) {
                User loggedUser = userEntityOpt.get();
                currentUser.setLoggedIn(true)
                        .setUsername(loggedUser.getUsername())
                        .setFirstName(loggedUser.getFirstName())
                        .setLastName(loggedUser.getLastName());
            }

            return success;
        }


    }

    @Override
    public void initializeUsersAndRoles() {
        initializeUsers();

    }

    @Override
    public void logout() {
        currentUser.clear();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {
            User admin = new User();

            admin.setActive(true)
                    .setUsername("admin")
                    .setFirstName("Adminkata")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("1234"));

            userRepository.save(admin);
        }
    }
}
