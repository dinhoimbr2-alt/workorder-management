package com.paulo.workorder.controller;

import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    // ======================
    // CRUD
    // ======================

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(workerService.getAllWorkers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        return ResponseEntity.ok(workerService.getWorkerById(id));
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        Worker created = workerService.createWorker(worker);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(
            @PathVariable Long id,
            @RequestBody Worker worker
    ) {
        return ResponseEntity.ok(workerService.updateWorker(id, worker));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }

    // ======================
    // 🔥 DOMAIN ENDPOINT (v5)
    // ======================

    @PostMapping("/{workerId}/assign-task/{taskId}")
    public ResponseEntity<Worker> assignTask(
            @PathVariable Long workerId,
            @PathVariable Long taskId
    ) {
        Worker updated = workerService.assignTaskToWorker(workerId, taskId);
        return ResponseEntity.ok(updated);
    }
}