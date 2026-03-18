package com.paulo.workorder.service;

import com.paulo.workorder.entity.Task;
import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.repository.TaskRepository;
import com.paulo.workorder.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final TaskRepository taskRepository;

    public WorkerService(WorkerRepository workerRepository,
                         TaskRepository taskRepository) {
        this.workerRepository = workerRepository;
        this.taskRepository = taskRepository;
    }

    // ======================
    // CRUD
    // ======================

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found"));
    }

    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(Long id, Worker workerData) {

        Worker worker = getWorkerById(id);

        worker.setName(workerData.getName());
        worker.setPhone(workerData.getPhone());
        worker.setShift(workerData.getShift());
        worker.setActive(workerData.isActive());

        return workerRepository.save(worker);
    }

    public void deleteWorker(Long id) {
        Worker worker = getWorkerById(id);
        workerRepository.delete(worker);
    }

    // ======================
    // 🔥 DOMAIN LOGIC
    // ======================

    public Worker assignTaskToWorker(Long workerId, Long taskId) {

        Worker worker = getWorkerById(workerId);

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // 🔥 lógica dominio
        worker.addTask(task);

        return workerRepository.save(worker);
    }
}