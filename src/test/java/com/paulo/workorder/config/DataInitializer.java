package com.paulo.workorder.config;


import com.paulo.workorder.entity.Task;
import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.repository.TaskRepository;
import com.paulo.workorder.repository.WorkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final WorkerRepository workerRepository;
    private final TaskRepository taskRepository;

    public DataInitializer(WorkerRepository workerRepository, TaskRepository taskRepository) {
        this.workerRepository = workerRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(workerRepository.count() == 0){
            for (int i = 0; i < 10; i++) {
                Worker worker = new Worker("Worker " + i, "600000" + i,
                        i % 2 == 0? "Morning" : "Afternoon", true );
                workerRepository.save(worker);
            }
            System.out.println("Workers populated successfully");
        }
        if (taskRepository.count() == 0) {

            for (int i = 0; i < 8; i++) {

                Task task = new Task(
                        "Task " + i,
                        "Description for task " + i
                );

                taskRepository.save(task);
            }

            System.out.println("Tasks populated successfully");
        }
    }
}
