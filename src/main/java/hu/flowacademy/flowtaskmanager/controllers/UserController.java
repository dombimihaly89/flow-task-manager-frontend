package hu.flowacademy.flowtaskmanager.controllers;

import hu.flowacademy.flowtaskmanager.exceptions.ValidationException;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/ids")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long id) {
        User user =  userService.findUserById(id);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.userDTOFromUser(user);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{username}/names")
    public ResponseEntity<UserResponseDTO> findUserByName(@PathVariable String username) {
        User user = userService.findUserByName(username);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.userDTOFromUser(user);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        User user = userService.saveUser(userRegisterDTO);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.userDTOFromUser(user);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDTO> userUpdate(@RequestBody UserRegisterDTO userRegisterDTO) {
        User userInDb = userService.findUserByName(userRegisterDTO.getUsername());
        if (userInDb == null) throw new ValidationException("There is no user with this username: " + userRegisterDTO.getUsername());
        userRegisterDTO.setId(userInDb.getId());
        User user = userService.saveUser(userRegisterDTO);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.userDTOFromUser(user);
        return ResponseEntity.ok(userResponseDTO);
    }

}
