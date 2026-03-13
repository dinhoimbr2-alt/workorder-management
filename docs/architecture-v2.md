# Work Order Management – Architecture (V2)

## Overview

Version 2 introduces a layered architecture using Spring Boot.

The application now exposes REST endpoints and follows a typical
Controller → Service → Repository structure.

---

## Architecture Layers

Client (Postman)
↓
Controller
↓
Service
↓
Repository
↓
Database (H2)

---

# Architecture V2

This version introduces the layered architecture with Controller, Service and Repository.

## Architecture Diagram

![Architecture V2](images/architecture-v2.png)

## Responsibilities

### Controller

Handles HTTP requests and exposes REST endpoints.

Example endpoints:

GET /workers  
GET /workers/{id}  
POST /workers  
PUT /workers/{id}  
DELETE /workers/{id}

---

### Service

Contains business logic and coordinates operations between controllers and repositories.

---

### Repository

Spring Data JPA repository responsible for persistence.

---

### Database

H2 in-memory database used for development and testing.
