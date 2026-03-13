
# Work Order Management – Domain Model (V1)

## Overview

This project models a simple maintenance **Work Order system**.

Goals of V1:

- Create a **domain model**
- Persist data using **Spring Data JPA**
- Store data in **H2 database**
- Verify persistence with **JUnit tests**

---

# Domain Concepts

## Worker

Represents a technician who performs maintenance work.

Fields:

- id (Long)
- name (String)
- phone (String)
- shift (MORNING / AFTERNOON)
- active (boolean)

---

## WorkOrder

Represents a maintenance order generated from an incident.

Example: *Electrical outlet not working*

Fields:

- id (Long)
- description (String)
- location (String)
- priority (LOW / MEDIUM / HIGH)
- status (OPEN / IN_PROGRESS / CLOSED)
- createdAt (DateTime)

---

# Cardinality

Relationship:

Worker (1) ---- (0..*) WorkOrder

Meaning:

• One worker can execute many work orders  
• A work order may initially have **no worker assigned**  
• Later it can be assigned to **one worker**

---

# UML Representation

![Domain Model](images/domain-model.SVG)

Worker
------
id
name
phone
shift
active

WorkOrder
---------
id
description
location
priority
status
createdAt

Relationship:

Worker 1 → many WorkOrders
