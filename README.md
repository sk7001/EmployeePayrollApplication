# Spring Boot Employee Payroll System with MySQL

This is an extended version of the Employee Payroll project using **MySQL** as the backend database. It supports full CRUD operations through REST APIs with persistent data storage.

## Table of Contents
- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Database Configuration](#database-configuration)

## Overview
The system manages employee data including name, salary, and department.  
This version uses **MySQL** (not H2), allowing real-world scalability and integration with persistent storage.

## Technologies Used
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Features
- Full CRUD operations with persistent MySQL database storage
- Separation of DTOs and entity models
- Input validation and exception handling
- Well-organized service and repository layers following best practices

## Project Structure
- **model** – Entity classes representing database tables  
- **dto** – Data Transfer Objects with validation rules  
- **repository** – Spring Data JPA repositories for MySQL  
- **controller** – REST API endpoints  
- **service** – Business logic and operations layer

## API Endpoints
- `POST /employee` – Add a new employee  
  Request body: `EmployeeDTO` JSON

- `GET /employee` – Retrieve list of all employees

- `GET /employee/{id}` – Retrieve employee by ID

- `PUT /employee/{id}` – Update employee details by ID  
  Request body: `EmployeeDTO` JSON

- `DELETE /employee/{id}` – Delete employee by ID

## Database Configuration

Update your `application.properties` file with your MySQL connection details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
