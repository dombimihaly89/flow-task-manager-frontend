package hu.flowacademy.flowtaskmanager.controllers;

import hu.flowacademy.flowtaskmanager.exceptions.ValidationException;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskDTO;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
        List<User> listOfUsers = userService.findAllUsers();
        List<UserResponseDTO> listOfDTOs = listOfUsers.stream().map(user -> {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.userDTOFromUser(user);
            return userResponseDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);
    }

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
        User user = userService.updateUser(userRegisterDTO);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.userDTOFromUser(user);
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> userDelete(@PathVariable Long id) {
        userService.userDelete(id);
        return ResponseEntity.ok().build();
    }

}
