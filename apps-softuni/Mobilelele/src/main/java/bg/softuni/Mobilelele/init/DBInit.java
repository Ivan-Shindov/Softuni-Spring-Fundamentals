package bg.softuni.Mobilelele.init;

import bg.softuni.Mobilelele.entity.User;
import bg.softuni.Mobilelele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final UserService userService;

    public DBInit(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        userService.initializeUsersAndRoles();
    }

//    private void initializeUsers() {
//        if (userRepository.count() == 0) {
//            User admin = new User();
//
//            admin.setActive(true)
//                    .setUsername("admin")
//                    .setFirstName("Adminkata")
//                    .setLastName("Adminov")
//                    .setPassword(passwordEncoder.encode("1234"));
//
//            userRepository.save(admin);
//        }
//    }
}
