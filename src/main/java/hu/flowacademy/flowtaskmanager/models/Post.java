package hu.flowacademy.flowtaskmanager.models;

import hu.flowacademy.flowtaskmanager.models.postDTO.PostDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void postFromPostDTO(PostDTO postDTO) {
        this.id = postDTO.getId();
        this.content = postDTO.getContent();
        this.type = postDTO.getType();
    }

    public enum Type {
        COMMENT,
        SOLUTION
    }
}
