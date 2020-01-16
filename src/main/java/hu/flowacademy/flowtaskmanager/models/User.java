package hu.flowacademy.flowtaskmanager.models;

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


}
