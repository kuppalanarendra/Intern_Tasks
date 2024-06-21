# Spring Boot Student Application System

# Overview

This project is a Spring Boot-based Student Management System that provides functionalities for managing student records through RESTful APIs. It includes operations for creating, reading, updating, and deleting student information from a MySQL database.

## Features

### Crud Operations
* Create
* Read
* Update
* Delete student records.

## Components
### Student Module

**Student Entity**: Represents a student with attributes id, name, age, grade, and address.
- **Student Repository**: Interface extending JpaRepository to handle CRUD operations on Student entities.
- **Student Service**: Implements business logic methods for CRUD operations.
- **Student Controller**: Defines RESTful endpoints for handling HTTP requests related to students.

### MySQL Database Configuration

Configure your MySQL database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
