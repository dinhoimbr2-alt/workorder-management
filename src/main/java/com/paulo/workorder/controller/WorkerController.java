package com.paulo.workorder.controller;


import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/workers")
public class WorkerController {

    private WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public List<Worker> getAllWorkers(){
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public Optional<Worker> getWorkerById(@PathVariable long id){
        return workerService.getWorkerById(id);
    }

    @PostMapping
    public Worker createWorker (@RequestBody Worker worker){
        return workerService.createWorker(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id){
        workerService.deleteWorker(id);
    }
 }
