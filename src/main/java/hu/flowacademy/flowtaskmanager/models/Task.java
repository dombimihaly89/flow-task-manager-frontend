package hu.flowacademy.flowtaskmanager.models;

import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskDTO;
import hu.flowacademy.flowtaskmanager.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
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

    @ManyToOne
    private User mentor;

    @ManyToMany
    private List<User> users;

    @Column
    @OneToMany
    private List<Post> posts;

    public void taskFromTaskDTO(TaskDTO taskDTO) {
        this.id = taskDTO.getId();
        this.type = taskDTO.getType();
        this.title = taskDTO.getTitle();
        this.content = taskDTO.getContent();
        this.difficulty = taskDTO.getDifficulty();
        this.ratings = taskDTO.getRatings();
    }

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
