# WorkOrder Management API

Spring Boot REST API for managing workers and tasks in a work order system.

This project is part of a backend learning exercise focused on:

- Spring Boot
- REST API design
- JPA / Hibernate
- H2 in-memory database
- API testing with Postman

---

# Architecture

The application follows a layered architecture:

Controller → Service → Repository → Database

Controller  
Handles HTTP requests and responses.

Service  
Contains the business logic.

Repository  
Uses Spring Data JPA to access the database.

Database  
H2 in-memory database used during development.

---

# Data Model

## Worker

Worker
id
name
phone
shift
active

## Task

Task
id
title
description

---

# API Endpoints

## Workers

GET /workers  
GET /workers/{id}  
POST /workers  
PUT /workers/{id}  
DELETE /workers/{id}

## Tasks

GET /tasks  
GET /tasks/{id}  
POST /tasks  
PUT /tasks/{id}  
DELETE /tasks/{id}

---

# Data Population

The database is automatically populated at startup using **DataFaker**.

This generates sample Workers and Tasks so the API can be tested immediately with Postman.

---

# Testing

The API was tested using:

- JUnit tests for repositories
- Postman collection for REST endpoints

---

# Future Improvements

- Introduce WorkOrder entity
- Add relationships between Worker and Task
- Implement validation
- Add Swagger API documentation
