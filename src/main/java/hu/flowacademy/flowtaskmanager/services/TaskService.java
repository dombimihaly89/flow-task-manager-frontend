package hu.flowacademy.flowtaskmanager.services;

import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskDTO;
import hu.flowacademy.flowtaskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(null);
    }

    public Task saveTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.taskFromTaskDTO(taskDTO);
        task.setCreatedAt(LocalDateTime.now());
        task.setUsers(taskDTO.getUserIds().stream().map(x -> userService.findUserById(x)).collect(Collectors.toList()));
        // this.posts = taskDTO.getPostIds().stream().map(x -> postService.findPostById(x)).collet(Collectors.toList());
        return taskRepository.save(task);
    }
}
