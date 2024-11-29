# Note Manager

A Spring Boot application designed to help with **notes management**. This project is a setup for a fully-featured notes management application, offering core functionalities like creating, reading, updating, and deleting notes.
The purpose of this application is to provide a backend service for managing notes, which can be further developed into a comprehensive note management system with persistence, authentication, and additional features.

This project is an enhanced version of the [Note Manager](https://github.com/ruslanaprus/goit-academy-dev-hw15), and it has an improved architecture for better maintainability and scalability. The `INoteService` interface is used to make the service layer more testable and extendable.
Similarly, the introduction of the `INoteRepository` interface ensures flexibility in switching between different data storage solutions, such as in-memory or database options.

---

## Main Features

- **Database-Backed Note Management**: Notes are stored in a database managed by Flyway migrations.
- **CRUD Operations**:
    - **List All Notes**: Retrieve all existing notes with pagination support.
    - **Get Note by ID**: Fetch a specific note using its unique ID.
    - **Create Note**: Add a new note with an auto-generated ID.
    - **Update Note**: Modify an existing note.
    - **Delete Note**: Remove a note by ID.
- **User Input Validation**: Validates note data such as title and content using Jakarta Bean Validation.
- **Global Exception Handling**: Provides error messages via a global exception handler.
- **Pagination**: Allows efficient display of notes, in case of large datasets.
- **Web layer**: Manages HTTP requests for the note management functionality. Supports endpoints for listing, creating, updating, and deleting notes.
- **Thymeleaf integration**: Added Thymeleaf templates to render data on web pages directly from the backend:
    - **List All Notes**: Displays all notes.
    - **Create a Note**: Form to create a new note.
    - **Edit Note**: Form to update a note.
    - **Error page**: Displays user-friendly error messages for invalid inputs or missing resources.

---

## Technologies Used

- **Java 21**: Core programming language for the application.
- **Spring Boot 3.3.5**: Simplifies application development with embedded server and configuration support.
- **Spring Data JPA**: Provides powerful instruments for database access.
- **PostgreSQL**: Database for storing note data.
- **Flyway**: Manages database schema migrations and populates initial data.
- **Jakarta Bean Validation**: Ensures data integrity with annotations `@NotNull` and `@NotEmpty`.
- **Lombok**: Reduces boilerplate code with annotations like `@Builder`, `@Getter`, and `@RequiredArgsConstructor`.
- **JUnit 5 & Mockito**: Provides a robust framework for writing unit and integration tests.
- **ConcurrentHashMap**: Offers thread-safe storage for managing notes in memory.
- **Thymeleaf**: Template engine for rendering dynamic HTML pages with embedded backend data.

---

## Getting Started

### Prerequisites

- **Java 21**: Ensure Java 21 is installed on your system.
- **Gradle**: This project uses Gradle for dependency management and build tasks.

### Installation

1. Clone the repository:
```shell
git clone git@github.com:ruslanaprus/goit-academy-dev-hw16.git
cd goit-academy-dev-hw16
```
2. Database Configuration: Copy the .env.example file into .env, and populate it with your DB details (you might need to change the GOIT_DB2_URL if yours is different).


3. You will also need to copy your database credentials into either:
   - Your environment variables on your computer (keys: [GOIT_DB2_URL, GOIT_DB_USER, GOIT_DB_PASS])
   - The build.gradle file in the flyway section


4. Run Flyway Migration: To apply database migrations, run:
```shell
gradle flywayMigrate
```
5. Build the project:
```shell
./gradlew clean build
```
6. Run the application:
```shell
./gradlew bootRun
```

---

## Project Structure

- **`com.example.notemanager`**: Main entry point for the application.
- **`model`**: Defines the `Note` class, the core entity of the application.
- **`repository`**: Defines repository operations, allows easy integration with various data sources.
- **`service`**: Contains `NoteService` for managing CRUD operations.
- **`controller`**: Handles web requests for note operations.
- **`exception`**: Includes custom exceptions, the `ExceptionMessages` enum, and a global exception handler.

---

## Future Enhancements

- **REST API**: Add controllers to expose note management functionalities via HTTP. Expand endpoints to support pagination, search, and filtering.
- **Authentication and Authorization**: Implement user authentication and authorization.
- **Advanced Search and Filtering**: Add capabilities for searching and filtering notes by criteria such as keywords or creation date.
- **Scalability Improvements**: Optimise the application for large-scale deployment.