# Quiz Game

A simple quiz game built using Spring Boot and Maven.

## Technology Stack

- **Spring Boot**: Application framework
- **Spring Data JPA**: For database operations
- **Spring Web**: For RESTful APIs
- **MySQL**: Database
- **Lombok**: To reduce boilerplate code
- **MapStruct**: For object mapping between beans

## Endpoints

- __GET: /api/question/:id__: Returns the question that is specified in the path variable
- __POST: /api/question__: Creates new question, request body: QuestionDto
