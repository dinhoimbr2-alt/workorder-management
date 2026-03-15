# API Testing

The REST API can be tested using the included Postman collection.

Location:

docs/postman/workorder-api.postman_collection.json

---

# Available Endpoints

| Method | Endpoint      | Description      |
| ------ | ------------- |------------------|
| GET    | /workers      | Get all workers  |
| GET    | /workers/{id} | Get worker by id |
| POST   | /workers      | Create worker    |
| PUT    | /workers/{id} | Update worker    |
| DELETE | /workers/{id} | Delete worker    |

---

# GET All Workers

<p align="center">
  <img src="images/postman/get-all-workers.png" width="800"/>
</p>

---

# GET Worker by ID

<p align="center">
  <img src="images/postman/get-worker-by-id.png" width="800"/>
</p>

---

# POST Create Worker

<p align="center">
  <img src="images/postman/post-workers.png" width="600"/>
</p>

---

# PUT Update Worker

<p align="center">
  <img src="images/postman/put-worker.png" width="600"/>
</p>

---

# DELETE Worker

<p align="center">
  <img src="images/postman/delete-worker.png" width="600"/>
</p>

# API Testing Guide

This document explains how to test the WorkOrder Management API
using Postman.

Base URL

http://localhost:8080

---

# Workers Endpoints

## Get All Workers

GET /workers

Returns the list of workers stored in the database.

---

## Get Worker By Id

GET /workers/{id}

Example:

GET /workers/1

---

## Create Worker

POST /workers

Body:

{
"name": "Paulo",
"phone": "600123456",
"shift": "MORNING",
"active": true
}

---

## Update Worker

PUT /workers/{id}

---

## Delete Worker

DELETE /workers/{id}

---

# Tasks Endpoints


| Method | Endpoint    | Description   |
| GET    | /Task       | Get all Task  |
| GET    | /Tasks/{id} | Get Task by id|
| POST   | /Tasks      | Create Task   |
| PUT    | /Tasks/{id} | Update Task   |
| DELETE | /Tasks/{id} | Delete Task   |


## Get All Tasks

<p align="center">
  <img src="images/postman/get-all-task.png" width="800"/>
</p>

---

## Get Task By Id

<p align="center">
  <img src="images/postman/get-task-by-id.png" width="800"/>
</p>

Example:

GET /tasks/1

---

## Create Task

<p align="center">
  <img src="images/postman/post-crate-task.png" width="800"/>
</p>

Body:

{
"title": "Cleaning",
"description": "Clean building"
}

---

## Update Task

<p align="center">
  <img src="images/postman/put-update-task.png" width="800"/>
</p>

---

## Delete Task

<p align="center">
  <img src="images/postman/delete-task.png" width="800"/>
</p>

---

# Postman Collection

The project includes a Postman collection located in:

docs/postman/

Import this collection into Postman to test the API endpoints.

---

# Test Flow

Recommended order for testing endpoints:

1 Create resource (POST)
2 Retrieve list (GET)
3 Retrieve by id (GET)
4 Update resource (PUT)
5 Delete resource (DELETE)
