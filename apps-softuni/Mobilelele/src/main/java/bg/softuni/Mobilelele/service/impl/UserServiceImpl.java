package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.Role;
import bg.softuni.Mobilelele.model.entity.User;
import bg.softuni.Mobilelele.model.enums.RoleEnum;
import bg.softuni.Mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.repository.UserRoleRepository;
import bg.softuni.Mobilelele.service.UserService;
import bg.softuni.Mobilelele.web.exception.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void registerAndLogin(UserRegisterServiceModel userServiceModel) {

        Role role = userRoleRepository.findByRole(RoleEnum.USER);

        User user = new User();

        user
                .setUsername(userServiceModel.getUsername())
                .setFirstName(userServiceModel.getFirstName())
                .setLastName(userServiceModel.getLastName())
                .setActive(true)
                .setRoles(Set.of(role))
                .setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        userRepository.save(user);
            //TODO
       // login(user);
    }

    @Override
    public boolean isUserNameFree(String username) {

       return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }



    @Override
    public User findByUsername(String name) {

       return userRepository.findByUsername(name)
               .orElseThrow(() -> new ObjectNotFoundException("Not found user with username: " + name));
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();

        initializeUsers();

    }

    private void initializeRoles() {
        if( userRoleRepository.count() ==0) {
            Role adminRole = new Role();
            adminRole.setRole(RoleEnum.ADMIN);

            Role userRole = new Role();
            userRole.setRole(RoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole,userRole));

        }
    }


    private void initializeUsers() {
        if (userRepository.count() == 0) {

            Role adminRole = userRoleRepository.findByRole(RoleEnum.ADMIN);
            Role userRole = userRoleRepository.findByRole(RoleEnum.USER);

            User admin = new User();

            admin.setActive(true)
                    .setUsername("admin")
                    .setFirstName("Adminkata")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("1234"));

            admin.setRoles(Set.of(adminRole,userRole));
            userRepository.save(admin);

            User ordinaryUser = new User();

            ordinaryUser.setActive(true)
                    .setUsername("pesho")
                    .setFirstName("Peter")
                    .setLastName("Petrov")
                    .setPassword(passwordEncoder.encode("1234"));

            ordinaryUser.setRoles(Set.of(userRole));
            userRepository.save(ordinaryUser);
        }
    }
}
