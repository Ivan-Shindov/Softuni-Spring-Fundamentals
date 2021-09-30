package bg.softuni.Mobilelele;

import bg.softuni.Mobilelele.entity.User;
import bg.softuni.Mobilelele.repository.BrandRepository;
import bg.softuni.Mobilelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {

        initializeUsers();
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
