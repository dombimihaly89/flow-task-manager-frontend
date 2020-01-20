package hu.flowacademy.flowtaskmanager.models.postDTO;

import hu.flowacademy.flowtaskmanager.models.Post;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDTO {

    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Post.Type type;

    private Long taskId;

    private Long userId;

    private List<Long> commentIds;

    public void postDTOfromPost(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.deletedAt = post.getDeletedAt();
        this.type = post.getType();
        if (post.getTask() != null) {
            this.taskId = post.getTask().getId();
        }
        this.userId = post.getUser().getId();
        //this.commentIds = post.getComments().stream().map(p -> p.getId()).collect(Collectors.toList());
    }

}
