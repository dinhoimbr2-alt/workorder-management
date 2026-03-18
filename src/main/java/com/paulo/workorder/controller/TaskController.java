package com.paulo.workorder.controller;

import com.paulo.workorder.entity.Task;
import com.paulo.workorder.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ======================
    // CRUD
    // ======================

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task
    ) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // ======================
    // 🔥 DOMAIN ENDPOINTS (v5)
    // ======================

    @PostMapping("/{taskId}/assign-worker/{workerId}")
    public ResponseEntity<Task> assignWorker(
            @PathVariable Long taskId,
            @PathVariable Long workerId
    ) {
        Task updated = taskService.assignWorkerToTask(taskId, workerId);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{taskId}/assign-workorder/{workOrderId}")
    public ResponseEntity<Task> assignWorkOrder(
            @PathVariable Long taskId,
            @PathVariable Long workOrderId
    ) {
        Task updated = taskService.assignWorkOrderToTask(taskId, workOrderId);
        return ResponseEntity.ok(updated);
    }
}