package com.paulo.workorder.service;

import com.paulo.workorder.entity.Task;
import com.paulo.workorder.entity.WorkOrder;
import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.repository.TaskRepository;
import com.paulo.workorder.repository.WorkOrderRepository;
import com.paulo.workorder.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;
    private final WorkOrderRepository workOrderRepository;

    public TaskService(TaskRepository taskRepository,
                       WorkerRepository workerRepository,
                       WorkOrderRepository workOrderRepository) {
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
        this.workOrderRepository = workOrderRepository;
    }

    // ======================
    // CRUD
    // ======================

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskData) {

        Task task = getTaskById(id);

        task.setTitle(taskData.getTitle());
        task.setDescription(taskData.getDescription());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    // ======================
    // 🔥 DOMAIN LOGIC
    // ======================

    public Task assignWorkerToTask(Long taskId, Long workerId) {

        Task task = getTaskById(taskId);

        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        task.assignWorker(worker);

        return taskRepository.save(task);
    }

    public Task assignWorkOrderToTask(Long taskId, Long workOrderId) {

        Task task = getTaskById(taskId);

        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() -> new RuntimeException("WorkOrder not found"));

        task.assignWorkOrder(workOrder);

        return taskRepository.save(task);
    }
}