package com.paulo.workorder.repository;

import com.paulo.workorder.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
