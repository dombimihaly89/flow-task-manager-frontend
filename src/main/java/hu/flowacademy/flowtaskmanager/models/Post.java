package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    @Column
    private Type type;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinColumn
    private List<Post> comments;

    public enum Type {
        COMMENT,
        SOLUTION
    }
}
