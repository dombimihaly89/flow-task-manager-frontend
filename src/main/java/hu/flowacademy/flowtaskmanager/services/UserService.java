package hu.flowacademy.flowtaskmanager.services;

import hu.flowacademy.flowtaskmanager.exceptions.ValidationException;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    public User saveUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        if (userRegisterDTO.getId() == null) {
            user.userFromUserDTO(userRegisterDTO);
            usernameValidator(user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } else {
            user = findUserById(userRegisterDTO.getId());
            user.setRole(userRegisterDTO.getRole());
        }
        return userRepository.save(user);
    }

    public void usernameValidator(User user) {
        if (findUserByName(user.getUsername()) != null) {
            throw new ValidationException("There is a registered user with this username.");
        }
    }

    public void usernameEqualityValidator(User user) {
        if (findUserById(user.getId()).getUsername() != user.getUsername()) {
            throw new ValidationException("You cannot change the username.");
        }
    }

    public void dateOfBirthEqualityValidator(User user) {
        if (findUserById(user.getId()).getDateOfBirth() != user.getDateOfBirth()) {
            throw new ValidationException("You cannot change your date of birth.");
        }
    }

    public void firstnameEqualityValidator(User user) {
        if (findUserById(user.getId()).getFirstName() != user.getFirstName()) {
            throw new ValidationException("You cannot change your firstname.");
        }
    }

    public void lastnameEqualityValidator(User user) {
        if (findUserById(user.getId()).getLastName() != user.getLastName()) {
            throw new ValidationException("You cannot change your lastname.");
        }
    }

    public void userDelete(Long id) {
        userRepository.deleteById(id);
    }

}