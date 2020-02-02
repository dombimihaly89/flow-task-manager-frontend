package hu.flowacademy.flowtaskmanager.controllers;

import hu.flowacademy.flowtaskmanager.exceptions.ValidationException;
import hu.flowacademy.flowtaskmanager.models.Task;
import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskDTO;
import hu.flowacademy.flowtaskmanager.models.TaskDTO.TaskResponseDTO;
import hu.flowacademy.flowtaskmanager.models.User;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserRegisterDTO;
import hu.flowacademy.flowtaskmanager.models.userDTO.UserResponseDTO;
import hu.flowacademy.flowtaskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/findall")
    public ResponseEntity<List<TaskResponseDTO>> findAllTasks() {
        List<Task> listOfTasks = taskService.findAllTasks();
        List<TaskResponseDTO> listOfDTOs = listOfTasks.stream().map(t -> {
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
            taskResponseDTO.taskResponseDTOFromTask(t);
            return taskResponseDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);
    }

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

    @PostMapping("/rate{id}{rating}")
    public ResponseEntity<TaskDTO> rateTask(@RequestParam Long id, @RequestParam Integer rating, @RequestParam Long userId) {
        Task task = taskService.addRating(id, rating, userId);
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.taskDTOFromTask(task);
        return ResponseEntity.ok(taskDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskService.updateTask(taskDTO);
        taskDTO.taskDTOFromTask(task);
        return ResponseEntity.ok(taskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }


}
