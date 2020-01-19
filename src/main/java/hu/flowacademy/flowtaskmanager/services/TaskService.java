package hu.flowacademy.flowtaskmanager.services;

import hu.flowacademy.flowtaskmanager.exceptions.ValidationException;
import hu.flowacademy.flowtaskmanager.models.Rating;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskDTO;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.repositories.RatingRepository;
import hu.flowacademy.flowtaskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RatingRepository ratingRepository;

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(null);
    }

    public Task saveTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.taskFromTaskDTO(taskDTO);
        if (userService.findUserById(taskDTO.getMentorId()).getRole() == User.Role.MENTOR) {
            task.setMentor(userService.findUserById(taskDTO.getMentorId()));
        }
        task.setCreatedAt(LocalDateTime.now());
        task.setUsers(taskDTO.getUserIds().stream().map(x -> userService.findUserById(x)).collect(Collectors.toList()));
        // this.posts = taskDTO.getPostIds().stream().map(x -> postService.findPostById(x)).collet(Collectors.toList());
        return taskRepository.save(task);
    }

    public Task addRating(Long id, Integer rating) {
        Task task =  findTaskById(id);
        if (task == null) throw new ValidationException("There is no user with this ID.");
        Rating newRating = new Rating(rating);
        task.getRatings().add(ratingRepository.save(newRating));
        return task;
    }


    public Task updateTask(TaskDTO taskDTO) {
        Task task = findTaskById(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);
        return task;
    }
}
