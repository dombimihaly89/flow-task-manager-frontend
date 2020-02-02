package hu.flowacademy.flowtaskmanager.models;

import hu.flowacademy.flowtaskmanager.models.userDTO.UserLoginDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate dateOfBirth;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    @ManyToMany(targetEntity = Task.class, mappedBy = "users", fetch = FetchType.EAGER)
    private List<Task> tasks;

    @Column
    @OneToMany
    private List<Post> posts;

    public enum Role {
        MENTOR,
        STUDENT
    }

    public void userFromUserDTO(UserRegisterDTO userRegisterDTO) {
        this.id = userRegisterDTO.getId();
        this.username = userRegisterDTO.getUsername();
        this.password = userRegisterDTO.getPassword();
        this.firstName = userRegisterDTO.getFirstName();
        this.lastName = userRegisterDTO.getLastName();
        this.dateOfBirth = userRegisterDTO.getDateOfBirth();
        this.role = userRegisterDTO.getRole();
    }

    public void userFromUserDTO(UserLoginDTO userLoginDTO) {
        this.username = userLoginDTO.getUsername();
        this.password = userLoginDTO.getPassword();
    }


}
