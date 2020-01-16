package hu.flowacademy.flowtaskmanager.utils;

import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.repositories.PostRepository;
import hu.flowacademy.flowtaskmanager.repositories.RatingRepository;
import hu.flowacademy.flowtaskmanager.repositories.TaskRepository;
import hu.flowacademy.flowtaskmanager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class InitDataLoader {

    private PostRepository postRepository;
    private RatingRepository ratingRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;


}
