package com.paulo.workorder.service;

import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }
    public Optional<Worker> getWorkerById(Long id){
        return workerRepository.findById(id);
    }
    public Worker createWorker(Worker worker){
        return workerRepository.save(worker);
    }
    public Worker updateWorker(Long id, Worker worker){
        worker.setId(id);
        return workerRepository.save(worker);
    }
    public void deleteWorker(Long id){
        workerRepository.deleteById(id);
    }
}
