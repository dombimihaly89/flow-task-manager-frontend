package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private List<Task> tasks;

    private List<Comment> lists;

    private List<Solution> solutions;

    public enum Role {
        MENTOR,
        STUDENT
    }


}
