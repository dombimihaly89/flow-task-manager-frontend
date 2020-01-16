package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private User user;

    private Task task;

    private Solution solution;
}
