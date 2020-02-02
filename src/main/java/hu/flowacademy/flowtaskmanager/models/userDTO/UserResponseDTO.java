package hu.flowacademy.flowtaskmanager.models.userDTO;

import hu.flowacademy.flowtaskmanager.models.Post;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserResponseDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private User.Role role;

    private List<Long> taskIds;

    private List<Long> postIds;

    public void userDTOFromUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dateOfBirth = user.getDateOfBirth();
        this.role = user.getRole();
        if (user.getTasks() == null) this.taskIds = null;
        else this.taskIds = user.getTasks().stream().map(x -> x.getId()).collect(Collectors.toList());
        if (user.getPosts() == null) this.postIds = null;
        else this.postIds = user.getPosts().stream().map(x -> x.getId()).collect(Collectors.toList());
    }
}
