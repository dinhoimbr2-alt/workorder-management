package com.paulo.workorder;

import com.paulo.workorder.entity.Worker;
import com.paulo.workorder.repository.WorkerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WorkerRepositoryTest {

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    void shouldSaveWorker() {

        Worker worker = new Worker("Paulo", "600123456", "Tarda", true);

        Worker saved = workerRepository.save(worker);

        assertThat(saved.getId()).isNotNull();
    }
    @Test
    void shouldFindWorkers() {

        Worker worker1 = new Worker("Paulo", "600123456", "Tardar", true);
        Worker worker2 = new Worker("David", "600987654", "Mañana", true);

        workerRepository.save(worker1);
        workerRepository.save(worker2);

        var workers = workerRepository.findAll();

        assertThat(workers).hasSize(2);
    }
}