package hu.flowacademy.flowtaskmanager.controllers;

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

    @GetMapping("/findbyid{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@RequestParam Long id) {
        User user =  userService.findUserById(id);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.userDTOFromUser(user);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/findbyname{userName}")
    public ResponseEntity<UserResponseDTO> findUserByName(@RequestParam String userName) {
        User user = userService.findUserByName(userName);
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

}
