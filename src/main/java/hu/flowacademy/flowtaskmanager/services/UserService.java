package hu.flowacademy.flowtaskmanager.services;

import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    public User addNewUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.userFromUserDTO(userRegisterDTO);
        userRepository.save(user);
        return user;
    }
}
