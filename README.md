🚀 Microservices Lab - IT22251664

📘 Module: Current Trends in Software Engineering (SE4010) – 2026

🧩 Spring Boot + 🌐 API Gateway + 🐳 Docker

📖 Project Overview

This project demonstrates a Microservices Architecture built using:

    ☕ Spring Boot
    🌐 Spring Cloud Gateway
    🐳 Docker
    📦 Docker Compose
    🧪 Postman

The system consists of 3 independent microservices, all accessed through a single API Gateway.


🏗️ System Architecture
    
    Client (Postman / Browser)
            │
            ▼
    🌐 API Gateway (8080)
            │
    ┌────────┼────────┐
    ▼        ▼        ▼
    📦 Item   🧾 Order  💳 Payment
    (8081)   (8082)     (8083)


📌 Services & Ports

    | Service Name       | Port | Description         |
    | ------------------ | ---- | ------------------- |
    | 🌐 API Gateway     | 8080 | Routes all requests |
    | 📦 Item Service    | 8081 | Manages products    |
    | 🧾 Order Service   | 8082 | Manages orders      |
    | 💳 Payment Service | 8083 | Manages payments    |


🔁 Gateway Routing Rules

    | Request Path   | Routed To       |
    | -------------- | --------------- |
    | `/items/**`    | Item Service    |
    | `/orders/**`   | Order Service   |
    | `/payments/**` | Payment Service |


All client requests must go through:
    http://localhost:8080


🛠️ Technologies Used

    ☕ Java 17
    🌱 Spring Boot 3.x
    🌐 Spring Cloud Gateway
    📦 Maven
    🐳 Docker
    🐳 Docker Compose
    🧪 Postman


📂 Project Structure
    
    microservices-lab/
    │
    ├── 📦 item-service/
    ├── 🧾 order-service/
    ├── 💳 payment-service/
    ├── 🌐 api-gateway/
    ├── 🐳 docker-compose.yml
    └── 📘 README.md

    Each service contains:
        Spring Boot Application
        REST Controller
        Dockerfile
        Maven Configuration


🐳 Running the Project

    🔹 Step 1: Build All Services
        From the root folder:
            docker-compose build
    
    🔹 Step 2: Start All Containers
        docker-compose up
    
    🔹 Step 3: Check Running Containers
        docker ps

We should see 4 running containers:
    item-service
    order-service
    payment-service
    api-gateway


🧪 API Testing (Postman) <br> </t>
⚠️ All requests must go through API Gateway (Port 8080)

    📦 Item Service
        🔹 Get All Items
            GET http://localhost:8080/items
![Item GET Screenshot](./api-testing-evidence/items-getall.png)

        🔹 Add New Item
            POST http://localhost:8080/items
![Item POST Screenshot](./api-testing-evidence/items-post.png)

        🔹 Get Item By ID
            GET http://localhost:8080/items/3
![Item GET id Screenshot](./api-testing-evidence/items-getid.png)

    
    🧾 Order Service
        🔹 Get All Orders
            GET http://localhost:8080/orders
![Item GET id Screenshot](./api-testing-evidence/orders-getall.png)

        🔹 Place Order
            POST http://localhost:8080/orders
![Item GET id Screenshot](./api-testing-evidence/orders-place.png)

        🔹 Get Order By ID
            GET http://localhost:8080/orders/1
![Item GET id Screenshot](./api-testing-evidence/orders-getid.png)


    💳 Payment Service
        🔹 Get All Paymentsapi-testing-evidenc
            GET http://localhost:8080/payments
![Item GET id Screenshot](./api-testing-evidence/payments-getall.png)

        🔹 Process Payment
            POST http://localhost:8080/payments/process
![Item GET id Screenshot](./api-testing-evidence/payments-process.png)

        🔹 Get Payment By ID
            GET http://localhost:8080/payments/1
![Item GET id Screenshot](./api-testing-evidence/payments-getid.png)


👩‍💻 Student Information <br>

👩 Name: Nipuni Bandara <br>
🆔 IT Number: IT22251664 <br>
🎓 Specialization: Software Engineering <br>
📘 Module: Current Trends in Software Engineering (SE4010) <br>
🏫 Institute: SLIIT – Faculty of Computing 