package com.paulo.workorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    // 🔹 Relación con Worker
    @ManyToOne
    @JoinColumn(name = "worker_id")
    @JsonIgnoreProperties("tasks")
    private Worker worker;

    // 🔹 Relación con WorkOrder
    @ManyToOne
    @JoinColumn(name = "work_order_id")
    @JsonIgnoreProperties("tasks")
    private WorkOrder workOrder;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // ======================
    // 🔥 MÉTODOS DE DOMINIO
    // ======================

    public void assignWorker(Worker worker) {
        this.worker = worker;
    }

    public void assignWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    // ======================
    // GETTERS & SETTERS
    // ======================

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Worker getWorker() {
        return worker;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}