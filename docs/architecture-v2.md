# WorkOrder Management – Architecture V3

Version 3 introduces:

- Automatic database population
- Postman API testing collection
- Full CRUD verification

---

## Database Population

A `DataInitializer` component was introduced to populate the database when the application starts.

Location:

src/main/java/com/paulo/workorder/config/DataInitializer.java

Purpose:

- Create sample Workers automatically
- Allow API testing without manual data creation

Example generated workers:

Worker 1  
Worker 2  
Worker 3  

---

## API Testing

The API can be tested using the provided Postman collection.

Location:

docs/postman/workorder-api.postman_collection.json

Endpoints available:

| Method | Endpoint | Description |
|------|------|------|
GET | /workers | Get all workers |
GET | /workers/{id} | Get worker by id |
POST | /workers | Create worker |
PUT | /workers/{id} | Update worker |
DELETE | /workers/{id} | Delete worker |

---

## Application Flow

Client (Postman)
↓
WorkerController
↓
WorkerService
↓
WorkerRepository
↓
H2 Database

---

## Purpose of V3

This version prepares the backend for future features such as:

- WorkOrder entity
- Worker–WorkOrder relationships
- Advanced queries