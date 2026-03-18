# WorkOrder Management API Testing Guide (v5)

This document explains how to test the WorkOrder Management REST API using Postman.

Version 5 introduces relationships between entities and domain-level operations.

---

## Base URL

http://localhost:8080

All endpoints described below use this base URL.

---

## Postman Collection

A ready-to-use Postman collection is included in the project.

Location:

docs/v5/postman/workorder-api.postman_collection.json

Import this file into Postman to quickly test all API endpoints.

---

## Workers API

| Method | Endpoint      | Description               |
| ------ | ------------- | ------------------------- |
| GET    | /workers      | Retrieve all workers      |
| GET    | /workers/{id} | Retrieve a worker by id   |
| POST   | /workers      | Create a new worker       |
| PUT    | /workers/{id} | Update an existing worker |
| DELETE | /workers/{id} | Delete a worker           |

---

## Tasks API

| Method | Endpoint    | Description         |
| ------ | ----------- | ------------------- |
| GET    | /tasks      | Retrieve all tasks  |
| GET    | /tasks/{id} | Retrieve task by id |
| POST   | /tasks      | Create a new task   |
| PUT    | /tasks/{id} | Update a task       |
| DELETE | /tasks/{id} | Delete a task       |

---

## WorkOrders API

| Method | Endpoint         | Description             |
| ------ | ---------------- | ----------------------- |
| GET    | /workorders      | Retrieve all workorders |
| GET    | /workorders/{id} | Retrieve a workorder    |
| POST   | /workorders      | Create a workorder      |
| PUT    | /workorders/{id} | Update a workorder      |
| DELETE | /workorders/{id} | Delete a workorder      |

---

## Domain Operations (v5)

### Assign Worker to Task

POST /tasks/{taskId}/assign-worker/{workerId}

<p align="center">
  <img src="../images/postman/post-assign-worker.png" width="800"/>
</p>

### Assign Task to WorkOrder

POST /workorders/{workOrderId}/tasks/{taskId}

<p align="center">
  <img src="../images/postman/post-assign-tasks.png" width="800"/>
</p>

### Get Tasks of a WorkOrder

GET /workorders/{workOrderId}/tasks

<p align="center">
  <img src="../images/postman/get-assign-tasks.png" width="800"/>
</p>

---

## Recommended Testing Flow (v5)

1. Create Workers
2. Create Tasks
3. Create WorkOrders
4. Assign Worker to Task
5. Assign Task to WorkOrder
6. Retrieve WorkOrder with Tasks

---

## Database

- H2 in-memory database
- Auto-generated schema via JPA/Hibernate
- Preloaded data using Faker

---

## Summary

The WorkOrder Management API provides REST endpoints for managing:

- Workers
- Tasks
- WorkOrders

Version 5 evolves the system into a connected domain model.
