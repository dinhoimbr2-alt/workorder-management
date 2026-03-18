package com.paulo.workorder.controller;

import com.paulo.workorder.entity.Task;
import com.paulo.workorder.entity.WorkOrder;
import com.paulo.workorder.service.WorkOrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workorders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    // ======================
    // CRUD
    // ======================

    @GetMapping
    public ResponseEntity<List<WorkOrder>> getAll() {
        return ResponseEntity.ok(workOrderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> getById(@PathVariable Long id) {
        return ResponseEntity.ok(workOrderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<WorkOrder> create(@RequestBody WorkOrder workOrder) {
        WorkOrder created = workOrderService.save(workOrder);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrder> update(
            @PathVariable Long id,
            @RequestBody WorkOrder updated
    ) {
        return ResponseEntity.ok(workOrderService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ======================
    // 🔥 RELACIONES
    // ======================

    @PostMapping("/{workOrderId}/tasks/{taskId}")
    public ResponseEntity<Task> addTaskToWorkOrder(
            @PathVariable Long workOrderId,
            @PathVariable Long taskId
    ) {
        return ResponseEntity.ok(
                workOrderService.addTaskToWorkOrder(workOrderId, taskId)
        );
    }

    @GetMapping("/{workOrderId}/tasks")
    public ResponseEntity<List<Task>> getTasksByWorkOrder(
            @PathVariable Long workOrderId
    ) {
        return ResponseEntity.ok(
                workOrderService.getTasksByWorkOrder(workOrderId)
        );
    }
}