package hu.flowacademy.flowtaskmanager.models.TaskDTO;

import hu.flowacademy.flowtaskmanager.models.Post;
import hu.flowacademy.flowtaskmanager.models.Rating;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskDTO {

    private Long id;

    private Task.Type type;

    private String title;

    private String content;

    private Task.Difficulty difficulty;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private List<Rating> ratings;

    private Long userId;

    private List<Post> posts;

}
