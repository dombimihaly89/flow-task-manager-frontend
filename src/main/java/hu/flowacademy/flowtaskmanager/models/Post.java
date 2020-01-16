package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {

    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private User user;

    private Task task;

    private Type type;

    private List<Post> comments;

    public enum Type {
        COMMENT,
        SOLUTION
    }
}
