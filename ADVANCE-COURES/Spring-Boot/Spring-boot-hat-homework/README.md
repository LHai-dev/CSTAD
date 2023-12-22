# Spring Framework Homework - Mobile Banking RESTful APIs

This repository contains the homework assignment for the Spring Framework course, focusing on creating RESTful APIs for a mobile banking application using Spring Data JPA and Spring HATEOAS.

## Table of Contents

- [Instructor Information](#instructor-information)
- [Assignment Details](#assignment-details)
  - [Requirements](#requirements)
  - [Resources](#resources)
- [Endpoints and Methods](#endpoints-and-methods)
- [Getting Started](#getting-started)
- [Deadline](#deadline)

## Instructor Information

- **Name:** CHAN CHHAYA
- **Email:** it.chhaya@gmail.com
- **Telegram & Phone:** 077/098 45-99-47

## Assignment Details

### Requirements

1. Use Spring Data JPA to create a database with the specified structure.
2. Develop RESTful APIs that support the functionalities of the mobile banking application using Spring HATEOAS.

### Resources

The application will manage the following resources:

- User
- Account Type
- Account
- Transaction

## Endpoints and Methods

The following endpoints are available for the respective resources:

### User

- `POST /users`: Create a new user.
- `GET /users`: Retrieve all users with active status.
- `GET /users/{uuid}`: Retrieve a user by UUID.
- `PUT /users/{uuid}`: Update an existing user by UUID.
- `PUT /users/{uuid}/disable`: Disable a user by UUID.
- `DELETE /users/{uuid}`: Remove a user by UUID permanently.
- `GET /users/{uuid}/accounts`: Retrieve all accounts of a user by UUID.
- `GET /users/{uuid}/accounts/{uuid}`: Retrieve an account by UUID of a user.

### Account Type

- `GET /account-types`: Retrieve all account types.
- `GET /account-types/{id}`: Retrieve an account type by ID.

### Account

- `POST /accounts`: Create a new account in the client app.
- `POST /accounts/{uuid}/rename`: Rename an existing account by UUID.
- `POST /accounts/{uuid}/limit-transfer`: Change transaction limit by UUID.
- `GET /accounts`: Retrieve information for all accounts.
- `GET /accounts/{uuid}`: Retrieve an account detail by UUID.
- `PUT /accounts/{uuid}/close`: Close an existing account by UUID.

### Transaction

- `POST /transactions`: Perform a transaction.

## Getting Started

1. Clone this repository.
2. Set up your Spring Boot environment and database configurations.
3. Implement the required controllers, services, repositories, and models for each resource.
4. Run the application and test the API endpoints.

## Deadline

The deadline for this assignment is **31st August 2023**, by **11:59 AM**.

Please make sure to follow the API specifications and requirements provided in this README. If you have any questions or need clarifications, don't hesitate to contact the instructor, CHAN CHHAYA, via the provided email or phone number. Good luck with your assignment!

