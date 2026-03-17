package com.paulo.workorder.repository;

import com.paulo.workorder.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long > {
}
