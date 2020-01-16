package hu.flowacademy.flowtaskmanager.models;

import hu.flowacademy.flowtaskmanager.models.userDTO.UserLoginDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userName;

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
    @ManyToMany
    private List<Task> tasks;

    @Column
    @OneToMany
    private List<Post> posts;

    public enum Role {
        MENTOR,
        STUDENT
    }

    public void userFromUserDTO(UserRegisterDTO userRegisterDTO) {
        this.userName = userRegisterDTO.getUserName();
        this.password = userRegisterDTO.getPassword();
        this.firstName = userRegisterDTO.getFirstName();
        this.lastName = userRegisterDTO.getLastName();
        this.dateOfBirth = userRegisterDTO.getDateOfBirth();
        this.role = userRegisterDTO.getRole();
    }

    public void userFromUserDTO(UserLoginDTO userLoginDTO) {
        this.userName = userLoginDTO.getUserName();
        this.password = userLoginDTO.getPassword();
    }


}
