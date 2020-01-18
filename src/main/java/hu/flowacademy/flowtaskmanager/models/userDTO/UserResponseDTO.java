package hu.flowacademy.flowtaskmanager.models.userDTO;

import hu.flowacademy.flowtaskmanager.models.Post;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponseDTO {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private User.Role role;

    private List<Task> tasks;

    private List<Post> posts;

    public void userDTOFromUser(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dateOfBirth = user.getDateOfBirth();
        this.role = user.getRole();
        this.tasks = user.getTasks();
        this.posts = user.getPosts();
    }
}
