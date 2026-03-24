
# 🚀 System Scope: Distributed Order Management System

### 🧩 Services:

1. Order Service
2. Payment Service
3. Inventory Service
4. User Service
5. Notification Service

---

# 🧾 1. Order Service (Core Orchestrator)

This is the **central brain of the system**.

## 🎯 Functionalities

* Create Order
* Get Order by ID
* Get All Orders (User-specific)
* Update Order Status
* Cancel Order
* Validate Order Request

---

## 🔁 Order Lifecycle Management

* CREATED
* PAYMENT_PENDING
* COMPLETED
* FAILED
* CANCELLED

---

## 🔗 Integrations

* Calls Payment Service
* Calls Inventory Service
* Triggers Notification Service

---

# 💳 2. Payment Service (Transaction Handler)

Handles **financial simulation layer**

## 🎯 Functionalities

* Process Payment
* Validate Payment Request
* Return Payment Status
* Simulate Payment Failure
* Maintain Payment Records (optional later)

---

## 🔁 Payment Status

* INITIATED
* SUCCESS
* FAILED

---

# 📦 3. Inventory Service (Stock Controller)

Ensures **product availability and consistency**

## 🎯 Functionalities

* Check Product Availability
* Reserve Stock
* Deduct Stock
* Release Stock (on failure/cancel)
* Update Inventory

---

## 🔁 Inventory States (Conceptual)

* AVAILABLE
* RESERVED
* OUT_OF_STOCK

---

# 👤 4. User Service (Identity Layer)

Handles **user management and authentication**

## 🎯 Functionalities

* Register User
* Login User
* Generate Token (JWT – later phase)
* Get User Details
* Validate User

---

## 🔐 Security Scope (Later Phase)

* Authentication
* Authorization (roles)

---

# 🔔 5. Notification Service (Communication Layer)

Handles **user communication asynchronously**

## 🎯 Functionalities

* Send Order Confirmation
* Send Payment Status Notification
* Send Failure Alerts
* Send Order Cancellation Notification

---

## 📢 Channels (Future Scope)

* Email (mock)
* SMS (mock)

---

# 🔁 End-to-End Business Flow

```plaintext
User places order
   ↓
Order Service
   ↓
Inventory Service (check & reserve)
   ↓
Payment Service (process payment)
   ↓
Order Service updates status
   ↓
Notification Service informs user
```

---

# ⚠️ Real Engineering Insight

You are designing:

* A **distributed workflow system**
* With **multiple failure points**
* And **state transitions**

👉 This is exactly where:

* Kafka
* Saga Pattern
* Retry mechanisms

will later become essential—not theoretical.

---

# 🧠 Functional Boundaries (Critical Understanding)

| Service      | Responsibility | Should NOT Do   |
| ------------ | -------------- | --------------- |
| Order        | Orchestration  | Payment logic   |
| Payment      | Transactions   | Order decisions |
| Inventory    | Stock          | Payment logic   |
| User         | Identity       | Order flow      |
| Notification | Communication  | Business logic  |

---