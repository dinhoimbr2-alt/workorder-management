package com.paulo.workorder.service;

import com.paulo.workorder.entity.Task;
import com.paulo.workorder.entity.WorkOrder;
import com.paulo.workorder.repository.TaskRepository;
import com.paulo.workorder.repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final TaskRepository taskRepository;

    public WorkOrderService(WorkOrderRepository workOrderRepository,
                            TaskRepository taskRepository) {
        this.workOrderRepository = workOrderRepository;
        this.taskRepository = taskRepository;
    }

    public List<WorkOrder> findAll() {
        return workOrderRepository.findAll();
    }

    public WorkOrder findById(Long id) {
        return workOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkOrder not found"));
    }

    public WorkOrder save(WorkOrder workOrder) {
        return workOrderRepository.save(workOrder);
    }

    public WorkOrder update(Long id, WorkOrder updated) {

        WorkOrder workOrder = findById(id);

        workOrder.setTitle(updated.getTitle());
        workOrder.setDescription(updated.getDescription());
        workOrder.setStatus(updated.getStatus());
        workOrder.setPriority(updated.getPriority());

        return workOrderRepository.save(workOrder);
    }

    public void delete(Long id) {
        WorkOrder workOrder = findById(id);
        workOrderRepository.delete(workOrder);
    }

    // 🔥 DOMINIO

    public Task addTaskToWorkOrder(Long workOrderId, Long taskId) {

        WorkOrder workOrder = findById(workOrderId);

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        workOrder.addTask(task);

        return taskRepository.save(task);
    }

    public List<Task> getTasksByWorkOrder(Long workOrderId) {
        return findById(workOrderId).getTasks();
    }
}