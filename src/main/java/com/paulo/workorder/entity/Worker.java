package com.paulo.workorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String shift;
    private boolean active;

    // 🔥 RELACIÓN INVERSA
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, String phone, String shift, boolean active) {
        this.name = name;
        this.phone = phone;
        this.shift = shift;
        this.active = active;
    }

    // ======================
    // 🔥 MÉTODOS DE DOMINIO
    // ======================

    public void addTask(Task task) {
        tasks.add(task);
        task.assignWorker(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.assignWorker(null);
    }

    // ======================
    // GETTERS & SETTERS
    // ======================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getShift() {
        return shift;
    }

    public boolean isActive() {
        return active;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}