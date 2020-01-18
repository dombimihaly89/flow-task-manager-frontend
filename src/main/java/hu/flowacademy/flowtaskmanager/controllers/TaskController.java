package hu.flowacademy.flowtaskmanager.controllers;

import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskDTO;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}/ids")
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable Long id) {
        Task task =  taskService.findTaskById(id);
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.taskDTOFromTask(task);
        return ResponseEntity.ok(taskDTO);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskService.saveTask(taskDTO);
        taskDTO.taskDTOFromTask(task);
        return ResponseEntity.ok(taskDTO);
    }
}
