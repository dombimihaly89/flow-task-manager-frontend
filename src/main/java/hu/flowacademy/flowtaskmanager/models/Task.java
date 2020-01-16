package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Type type;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Difficulty difficulty;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    @Column
    @OneToMany
    private List<Rating> ratings;

    @Column
    @ManyToMany
    private List<User> users;

    @Column
    @OneToMany
    private List<Post> posts;

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
