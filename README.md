# Blog App APIs

## 📌 Overview
This project is a **Spring Boot-based RESTful API** that provides endpoints for creating, reading, updating, and deleting (CRUD) blog posts, users, and categories.

## ✨ Features
- **User management**: create, update, delete, and retrieve users  
- **Category management**: create, update, delete, and retrieve categories  
- **Post management**: create, update, delete, and retrieve posts  
- **Post search**: search posts by title  
- **Pagination and sorting**: retrieve posts with pagination and sorting  

---

## 📚 API Endpoints

### 👤 User Endpoints
| Method | Endpoint              | Description             |
|--------|-----------------------|-------------------------|
| POST   | `/api/users/`         | Create a new user       |
| PUT    | `/api/users/{userId}` | Update an existing user |
| DELETE | `/api/users/{userId}` | Delete a user           |
| GET    | `/api/users/`         | Retrieve all users      |
| GET    | `/api/users/{userId}` | Retrieve a user by ID   |

---

### 🏷️ Category Endpoints
| Method | Endpoint                       | Description                  |
|--------|--------------------------------|------------------------------|
| POST   | `/api/categories/`             | Create a new category        |
| PUT    | `/api/categories/{categoryId}` | Update an existing category  |
| DELETE | `/api/categories/{categoryId}` | Delete a category            |
| GET    | `/api/categories/`             | Retrieve all categories      |
| GET    | `/api/categories/{categoryId}` | Retrieve a category by ID    |

---

### 📝 Post Endpoints
| Method | Endpoint                                              | Description                          |
|--------|-------------------------------------------------------|--------------------------------------|
| POST   | `/api/user/{userId}/category/{categoryId}/posts`      | Create a new post                    |
| PUT    | `/api/posts/{postId}`                                 | Update an existing post              |
| DELETE | `/api/posts/{postId}`                                 | Delete a post                        |
| GET    | `/api/posts/`                                         | Retrieve all posts (pagination/sort) |
| GET    | `/api/posts/{postId}`                                 | Retrieve a post by ID                |
| GET    | `/api/user/{userId}/posts`                            | Retrieve all posts by a user         |
| GET    | `/api/category/{categoryId}/posts`                    | Retrieve all posts by a category     |
| GET    | `/api/posts/search/{keywords}`                        | Search posts by title                |

---

## ⚙️ Technologies Used
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MySQL (or any relational database)  
- Java 17 (or later)  

---

## 🚀 Getting Started

### Prerequisites
- Java 17+  
- Maven or Gradle  
- MySQL (or configured DB)  

### Steps

#### Clone the repository:
```bash
git clone <repository-url>
cd blog-app-apis
```

#### Build the project:
mvn clean package
# or
gradle build

#### Run the application:
java -jar target/blog-app-apis.jar
# or
gradle bootRun

#### Access the API:
http://localhost:8080/api/

🤝 Contributing

Contributions are welcome!

Fork the repository

Create a new branch (feature/your-feature)

Commit your changes

Push to your branch

Submit a Pull Request
