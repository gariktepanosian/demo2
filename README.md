# Spring Application with Trainee and Trainer ETC. Entities

This Spring application demonstrates the implementation of Trainee and Trainer entities with associated functionalities. The application uses in-memory storage, Spring Data, and Spring Bean Post-Processing features. Here's an overview of the key functionalities and components:

## Components and Functionality

### Entities

1. **Trainee**: Represents trainee information, including a User object. The username and password for the User are generated based on first name, last name, and specific rules.

2. **Trainer**: Represents trainer information, including a User object. The username and password for the User are generated based on first name, last name, and specific rules.

3. **Training**: Represents training information, including Trainee, Trainer, and TrainingType associations.

4. **TrainingType**: Represents training types with a type name.

5. **User**: Represents user information with ID, name, last name, username, password, and an isActive flag.

### Storage

- The application uses a Java Map to store entities in memory.
- Each entity is stored under a separate namespace for easy management.

### Data Access Object (DAO) Layer

- The application implements DAO objects for each entity to interact with the in-memory storage.

### Services Layer

- Services are implemented for each entity, including CRUD operations and specific functionalities like username and password calculation.

### Facade

- A Facade class is used to provide a unified interface for the services.

### Property Placeholder and External Property File

- The application uses property placeholders and external property files to configure the application and specify the path to the data file.

## User and Password Calculation

- Usernames for Trainee and Trainer entities are calculated based on first name and last name, with a serial number added if necessary.
- Passwords are generated as random 10-character strings.

- ## Unit Tests for Trainee and Related Services

- This section outlines the unit tests specifically designed for the Trainee domain model and its associated classes.

## Logging

- Proper logging is implemented throughout the application to provide visibility into various actions and operations.

## File-Based Data Loading and Saving

- The application supports initializing storage with prepared data from a file during startup.
- Data is saved to a CSV file, and the application can read and write this data.

## Serial Number for Trainee

- Serial numbers for Trainee entities are managed in the TraineeStorage class, which assigns unique serial numbers to each Trainee.

## Usage

- To run the application, make sure you have a Spring environment set up and configured.
- You can use Spring Boot to start the application.
- The application demonstrates CRUD operations, data loading, and saving using in-memory storage.

## Author

[Garik Tepanosyan]
