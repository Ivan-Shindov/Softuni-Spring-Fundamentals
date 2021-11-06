package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.User;
import bg.softuni.Mobilelele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileleUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public MobileleUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name" + username + "not found !"));


        return mapToUserDetails(userEntity);
    }

    private static UserDetails mapToUserDetails(User userEntity) {
        List<GrantedAuthority> authorities = userEntity
                .getRoles().stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());

        return new MobileleUser(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );
    }
}
