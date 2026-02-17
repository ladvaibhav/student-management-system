
# 🎓 Student Management System (Core Backend Repository)

This repository contains the **core backend source code** of the Student Management System built using Spring Boot.

It includes complete business logic, layered architecture implementation, security configuration, database integration, and REST API development.

> 🚀 The Dockerized cloud deployment version of this project is maintained separately.

---

## 🌍 Deployment Version

This repository contains only the core backend source code.

The production-ready, Dockerized deployment version (used for Render hosting) is maintained separately:

🔗 **Deployment Repository:**  
https://github.com/ladvaibhav/student-management-system-deployment


The deployment repository includes:
- Docker configuration
- Environment variable setup
- Cloud database configuration
- Render web service configuration

#### 📘 Swagger (Live Hosted Version)
https://student-management-temp.onrender.com/swagger-ui/index.html#/


#### 🌐 Live API (Render)
https://student-management-temp.onrender.com

⚠️ Note: The application is hosted on Render’s free tier. If the service has been idle, it may take 4-5 minutes to start on the first request.

---

## 🛠 Tech Stack

- Java 23+
- Spring Boot 4.0+
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- Maven
- Spring Security
- Swagger (Springdoc OpenAPI)
- Docker
- Render (Cloud Hosting)

---

## 🏗 Architecture (Layered Design)

The project follows a structured layered architecture:

Controller → Service → Repository → Database

---

### Layers

- **Entity** – JPA entities mapped to database tables
- **DTO** – Data Transfer Objects for request/response
- **Repository** – Spring Data JPA interfaces
- **Service** – Business logic abstraction
- **Service Implementation** – Concrete business logic
- **Controller** – REST API endpoints
- **Exception Handling** – Global exception handler

---

## 🚀 Features

### 📌 Core Functionalities

CRUD Operations for:

- Students
- Departments
- Courses
- Subjects
- Users

### 📄 Pagination & Sorting

- Offset-based Pagination
- Dynamic Sorting (ASC / DESC)
- Pageable implementation using Spring Data JPA

### 🏗 Architecture (Layered Design)

- Entity
- DTO (Data Transfer Object)
- Repository
- Service
- Service Implementation (ServiceImpl)
- Controller

### 🔐 Authentication & Security

- HTTP Basic Authentication
- Database-backed authentication
- Custom `UserDetailsService`
- Password encryption using `BCryptPasswordEncoder`
- Secured REST endpoints

### ⚙ Backend Best Practices

- Global Exception Handling
- Input Validation using Jakarta Validation
- Spring Security (HTTP Basic Authentication)
- Password Encryption using BCrypt
- Swagger API Documentation

---

## API Documentation (Swagger UI) (Local)
This project integrates Swagger UI to provide interactive and auto-generated API documentation.

### 🔗 Swagger UI URL
- After starting the application, open:
 http://localhost:8080/swagger-ui/index.html

You can:

- View all available REST APIs
- Test endpoints directly from the browser
- Inspect request and response schemas

---

# 📌 API Endpoints

## 👨‍🎓 Student Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/v1/students` | Create student |
| GET | `/v1/students/all` | Get all students |
| GET | `/v1/students/id/{id}` | Get student by ID |
| GET | `/v1/students/email/{email}` | Get student by email |
| GET | `/v1/students/name/{name}` | Get student by name |
| GET | `/v1/students/paged` | Pagination & sorting |
| PUT | `/v1/students/id/{id}` | Update student |
| DELETE | `/v1/students/id/{id}` | Delete by ID |
| DELETE | `/v1/students/email/{email}` | Delete by Email |

---

## 👤 User Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/v1/users` | Create user |
| GET | `/v1/users/all` | Get all users |
| GET | `/v1/users/id/{userId}` | Get user by ID |
| GET | `/v1/users/name/{username}` | Get user by username |
| PUT | `/v1/users/id/{userId}` | Update user |
| DELETE | `/v1/users/id/{userId}` | Delete user |

---

## 📚 Subject Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/v1/subject` | Create subject |
| GET | `/v1/subject/all` | Get all subjects |
| GET | `/v1/subject/subjectId/{subjectId}` | Get by ID |
| GET | `/v1/subject/subjectName/{subjectName}` | Get by name |
| PUT | `/v1/subject/subjectId/{subjectId}` | Update subject |
| DELETE | `/v1/subject/subjectId/{subjectId}` | Delete subject |

---

## 🏢 Department Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/v1/departments` | Create department |
| GET | `/v1/departments/all` | Get all departments |
| GET | `/v1/departments/deptId/{deptId}` | Get by ID |
| GET | `/v1/departments/deptName/{deptName}` | Get by name |
| PUT | `/v1/departments/deptId/{deptId}` | Update department |
| DELETE | `/v1/departments/deptId/{deptId}` | Delete department |

---

## 🎓 Course Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/v1/courses` | Create course |
| GET | `/v1/courses/all` | Get all courses |
| GET | `/v1/courses/id/{courseId}` | Get by ID |
| GET | `/v1/courses/name/{courseName}` | Get by name |
| GET | `/v1/courses/deptId/{deptId}` | Get by department |
| PUT | `/v1/courses/id/{courseId}` | Update course |
| DELETE | `/v1/courses/id/{courseId}` | Delete course |

---

## 📄 Pagination Example

`GET /v1/students/paged?page=0&size=4&sort=name,asc`

---

## 📄 Pagination & Sorting

### Example Endpoints
| Method | Endpoint             |
|------|----------------------|
| GET | /v1/students/paged   |

### Query Parameters
| Parameters | Description                 | Example       |
|------------|-----------------------------|---------------|
| Page       | Page number (0-based)       | page=0        |
| size       | Number of records per page  | size=4        |
| sort       | Sorting field and direction | sort=name.asc |

### Example Requests
| Method | Endpoint                                                    |
|------|-------------------------------------------------------------|
| GET | /v1/students/paged?page=0&size=4&sortBy=name&direction=desc |
| GET | /v1/students/paged?page=0&size=4&sort=name,asc              |



### Secured Endpoints
| Method         | Endpoint          | Access                     |
|----------------|-------------------|----------------------------|
| ALL            | `/v1/students/**` | Authenticated              |
| POST           | `/v1/users/`      | Public (User Registration) |
| GET/PUT/DELETE | `/v1/users/`      | Authenticated              |

---

## 📸 Swagger UI Preview

<table>
  <tr>
    <td><img src="docs/images/img_1.png" width="800"/></td>
    <td><img src="docs/images/img.png" width="800"/></td>
  </tr>
  <tr>
    <td><img src="docs/images/img_2.png" width="800"/></td>
    <td><img src="docs/images/img_3.png" width="800"/></td>
  </tr>
  <tr>
    <td><img src="docs/images/img_4.png" width="800"/></td>
    <td><img src="docs/images/img_5.png" width="800"/></td>
  </tr>
</table>


---

## 💡 Key Learning Outcomes

- REST API Design
- Clean Layered Architecture
- DTO Pattern Implementation
- Exception Handling Strategy
- Pagination & Sorting Implementation
- Spring Security Integration
- Docker Containerization
- Cloud Deployment on Render

---

## Status
🚧 **Work in Progress**



## 👨‍💻 Author

**Vaibhav Lad**  
Backend Developer | Spring Boot | PostgreSQL | Docker | Cloud Deployment

