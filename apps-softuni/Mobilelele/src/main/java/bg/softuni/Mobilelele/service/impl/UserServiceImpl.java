package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.entity.User;
import bg.softuni.Mobilelele.entity.service.UserLoginServiceModel;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<User> userEntityOpt = userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(loginServiceModel.getRawPass(),
                    userEntityOpt.get().getPassword());
        }
    }
}
