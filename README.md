# Social Media App (Spring Boot + JPA)

A basic social media backend built with **Spring Boot** and **JPA/Hibernate**. It allows creation and management of user profiles along with their posts.

## Features

* Create, edit, and manage users
* Associate multiple posts with a user
* One-to-many relationship: User → Posts
* RESTful APIs for all operations
* Database support with JPA (H2/MySQL)

## Tech Stack

* Java 17+
* Spring Boot 3.x
* Spring Data JPA (Hibernate)
* Maven

## API Endpoints

| Method | Endpoint          | Description       |
| ------ | ----------------- | ----------------- |
| POST   | /user/api/v1      | Create a new user |
| PUT    | /user/api/v1/{id} | Edit user by ID   |
| GET    | /user/api/v1/{id} | Get user by ID    |
| GET    | /user/api/v1      | Get all users     |
| DELETE | /user/api/v1/{id} | Delete user by ID |

## Getting Started

1. Clone the repo:

```bash
git clone https://github.com/yourusername/social-media-app.git
```

2. Navigate to the project directory and run:

```bash
mvn spring-boot:run
```

3. Access the API at `http://localhost:8080/user/api/v1`

## Notes

* Use Postman or similar tools to test API endpoints.
* Update application.properties for custom DB configuration.

## License

This project is open source and available under the [MIT License](LICENSE).
