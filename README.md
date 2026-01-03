##Order Management REST API
Overview

This project is a backend Order Management REST API built using Java and Spring Boot.
It provides CRUD operations for clients, products, orders, and order items, demonstrating clean REST API design, layered architecture, and relational data modeling.

The application is designed to simulate a real-world order workflow where orders are associated with clients and multiple products, and data is persisted using PostgreSQL.

##Tech Stack

*Java 11

*Spring Boot

*Spring Data JPA (Hibernate)

*PostgreSQL

*Maven

*JUnit & Mockito

*Docker & Docker Compose

*Swagger / OpenAPI

*Lombok

##Features

*RESTful APIs for managing:

*Clients

*Products

*Orders

*Order Items

*Entity relationships using JPA (@OneToMany, @ManyToOne)

*DTO-based API responses for better abstraction

*API documentation using Swagger/OpenAPI

*PostgreSQL database with Dockerized setup

*Basic unit tests for service-layer validation

*Custom exception handling for invalid requests

##Project Structure

*The application follows a layered architecture:

*Controller layer – Handles HTTP requests and responses

*Service layer – Contains business logic

*Repository layer – Manages database access using Spring Data JPA

*DTOs – Used to decouple API responses from entity models

*This structure improves readability, testability, and maintainability.

##API Documentation (Swagger)

#After running the application, Swagger UI can be accessed at:

http://localhost:8080/swagger-ui.html


Swagger provides interactive documentation to explore and test all available endpoints.

##How to Run the Project
#Prerequisites

*Java 11

*Maven 3.8+

*Docker & Docker Compose

Step 1: Clone the repository
git clone <your-github-repo-url>
cd order-management-api

Step 2: Start PostgreSQL using Docker
docker compose up -d


This will:

*Build the PostgreSQL container

*Create the database

*Insert initial seed data

Step 3: Run the application
mvn spring-boot:run


The API will be available at:

http://localhost:8080

##Testing

Unit tests are implemented using JUnit and Mockito

Tests focus on validating service-layer logic and data handling

Run tests using:

mvn test

##What I Learned

*Designing RESTful APIs using Spring Boot best practices

*Structuring backend applications using controller–service–repository layers

*Modeling relational data using JPA and Hibernate

*Using DTOs to control API response structure

*Dockerizing database environments for local development

*Writing unit tests to improve reliability and maintainability