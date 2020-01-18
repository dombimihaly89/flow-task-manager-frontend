package hu.flowacademy.flowtaskmanager.models.userDTO;

import hu.flowacademy.flowtaskmanager.models.Post;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserLoginDTO {

    private String username;

    private String password;

}
