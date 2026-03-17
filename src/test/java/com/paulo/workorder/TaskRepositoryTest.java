package com.paulo.workorder;


import com.paulo.workorder.entity.Task;
import com.paulo.workorder.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldSaveTask(){

        Task task = new Task(
                "Electrical Repair",
                "Fix electrical problems"
        );

        Task saved = taskRepository.save(task);
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void shouldFindTasks() {

        Task task1 = new Task(
                "Plumbing",
                "Fix water pipes"
        );

        Task task2 = new Task(
                "Cleaning",
                "General maintenance cleaning"
        );
        Task task3 = new Task(
                "Plumbing",
                "Fix water pipes"
        );
        Task task4 = new Task(
                "Cleaning",
                "General maintenance cleaning"
        );

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);

        //List<Task> tasks = taskRepository.findAll();
        var tasks = taskRepository.findAll();
        System.out.println("Tasks in DB: " + tasks.size());

        assertThat(tasks).hasSize(4);

    }

}
