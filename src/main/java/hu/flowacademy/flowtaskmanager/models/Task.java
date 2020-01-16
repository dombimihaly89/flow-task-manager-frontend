package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Task {

    private Long id;

    private Type type;

    private String title;

    private String content;

    private Difficulty difficulty;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private List<Rating> ratings;

    private List<User> users;

    private List<Comment> comments;

    private List<Solution> solution;

    public enum Type {
        JAVA,
        JAVASCRIPT,
        SPRING,
        ANGULAR,
        LINUX,
        DATABASE
    }

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }
}
