package com.paulo.workorder.config;

import com.paulo.workorder.entity.Task;
import com.paulo.workorder.entity.WorkOrder;
import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.repository.TaskRepository;
import com.paulo.workorder.repository.WorkOrderRepository;
import com.paulo.workorder.repository.WorkerRepository;

import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final WorkerRepository workerRepository;
    private final TaskRepository taskRepository;
    private final WorkOrderRepository workOrderRepository;

    public DataInitializer(WorkerRepository workerRepository,
                           TaskRepository taskRepository,
                           WorkOrderRepository workOrderRepository) {
        this.workerRepository = workerRepository;
        this.taskRepository = taskRepository;
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public void run(String... args) {

        Faker faker = new Faker();

        // ============================
        // 1️⃣ WORKERS
        // ============================
        if (workerRepository.count() == 0) {

            for (int i = 0; i < 10; i++) {

                Worker worker = new Worker(
                        faker.name().firstName(),
                        faker.phoneNumber().cellPhone(),
                        faker.options().option("Morning", "Afternoon"),
                        true
                );

                workerRepository.save(worker);
            }

            System.out.println("Workers populated successfully");
        }

        // ============================
        // 2️⃣ WORK ORDERS
        // ============================
        if (workOrderRepository.count() == 0) {

            for (int i = 0; i < 5; i++) {

                WorkOrder workOrder = new WorkOrder(
                        faker.job().title(),
                        faker.lorem().sentence(),
                        faker.options().option("OPEN", "IN_PROGRESS", "DONE"),
                        faker.options().option("LOW", "MEDIUM", "HIGH")
                );

                workOrderRepository.save(workOrder);
            }

            System.out.println("WorkOrders populated successfully");
        }

        // ============================
        // 3️⃣ LOAD DATA (CLAVE)
        // ============================
        List<Worker> workers = workerRepository.findAll();
        List<WorkOrder> workOrders = workOrderRepository.findAll();

        if (workers.isEmpty() || workOrders.isEmpty()) {
            throw new RuntimeException("Workers or WorkOrders not initialized");
        }

        // ============================
        // 4️⃣ TASKS (con relaciones 🔥)
        // ============================
        if (taskRepository.count() == 0) {

            for (int i = 0; i < 10; i++) {

                Task task = new Task(
                        faker.job().title(),
                        faker.lorem().sentence()
                );

                // 👉 Worker aleatorio
                Worker randomWorker = workers.get(
                        faker.random().nextInt(workers.size())
                );

                // 👉 WorkOrder aleatorio
                WorkOrder randomWorkOrder = workOrders.get(
                        faker.random().nextInt(workOrders.size())
                );

                // 🔥 RELACIONES
                task.assignWorker(randomWorker);
                task.assignWorkOrder(randomWorkOrder);

                taskRepository.save(task);
            }

            System.out.println("Tasks populated successfully");
        }
    }
}