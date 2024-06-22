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

- **Student Entity**: Represents a student with attributes id, name, age, grade, and address.
- **Student Repository**: Interface extending JpaRepository to handle CRUD operations on Student entities.
- **Student Service**: Implements business logic methods for CRUD operations.
- **Student Controller**: Defines RESTful endpoints for handling HTTP requests related to students.

### Exception Handling
  * Student Not Found Exception
  * Exception Message

### MySQL Database Configuration

Configure your MySQL database connection in `application.properties`:

``properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=Narendra@2000
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

## MySQL Database Configuration
* To build and run the application, follow these steps:
* 1.Ensure you have Maven, Java, and MySQL installed on your system.
* 2.Clone the repository to your local machine: git clone 
  https://github.com/kuppalanarendra/Intern_Tasks.git
* 3.Navigate to the project directory: cd Student_Application.
* 4.Configure your MySQL database connection in the application.properties file.
* 5.Build the application using Maven: mvn clean package.
* 6.Run the application: java -jar crud-operations-0.0.1-SNAPSHOT.jar

## API Documentation
### API Endpoints
 * POST /students: Create a new student
 * GET /students: Retrieve all students
 * GET /students/{id}: Retrieve a student by ID
 * PUT /students/{id}: Update a student by ID
 * DELETE /students/{id}: Delete a student by ID
 * Access the API documentation using Swagger UI at: http://localhost:8080/swagger- 
   ui.html

## Testing the Application
  You can test the application using tools like Postman or cURL. Ensure you have valid 
  JSON payloads for POST and PUT requests.

## Contributing
Contributions to the project are welcome! If you have any ideas for improvements or new features, feel free to open an issue or submit a pull request.

## License
  This project is licensed under the MIT License.
  
## Author
Your Name:K.Narendra

## Acknowledgments
  * Special thanks to the Spring Boot community for their excellent documentation and 
  support.
  * Special thanks to Jeev Lifeworks for giving this project for me.
