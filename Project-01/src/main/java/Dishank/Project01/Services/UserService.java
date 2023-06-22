package Dishank.Project01.Services;

import Dishank.Project01.DTO.UserDto;
import Dishank.Project01.Entity.User;
import Dishank.Project01.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepository userRepository;
    public void saveNewUser(UserDto userdto) {
        User user= User.builder()
                .firstName(userdto.getFirstName())
                .lastName(userdto.getLastName())
                .email(userdto.getEmail())
                .password(passwordEncoder.encode(userdto.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);
    }
}
