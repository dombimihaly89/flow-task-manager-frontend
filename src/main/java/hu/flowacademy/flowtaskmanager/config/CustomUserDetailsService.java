package hu.flowacademy.flowtaskmanager.config;

import hu.flowacademy.flowtaskmanager.controllers.UserController;
import hu.flowacademy.flowtaskmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

@Configuration
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(userService.findUserById(userController.findUserByName(s).getBody().getId()));

        if (userController.findUserByName(s) == null) throw new UsernameNotFoundException(s);
        return userService.findUserById(userController.findUserByName(s).getBody().getId());
    }

}
