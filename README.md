# Book Management API 📚🚀

Welcome to the **Book Management API** – the most efficient and powerful way to manage books in your system. Whether you're an author, reader, or just a book enthusiast, this API has got you covered for all your book-related needs. Add, update, search, or delete books with ease and handle everything securely with JWT-based authentication. 💪

## 🚀 Key Features:
- **Add a Book**: Easily add a book by providing details like title, author, category, rating, and price.
- **Search & Filter**: Find the perfect book using search by title or filter by category, author, or rating.
- **Update Book**: Edit book details when you need to make changes. Admins can also delete books.
- **Secure Access**: All critical endpoints are secured with JWT authentication – only authorized users can perform admin actions.

## 🔑 Authentication:
To use the API securely, login with your credentials and get your **JWT token**. Use this token to access protected routes and manage your books. 🚀

**API Endpoints:**

### 📋 `POST /api/auth/signup`:
- Register a new user with email, password, and name.
- *Example Request Body*:
  ```json
  {
    "email": "testuser@example.com",
    "password": "password123",
    "name": "Test User"
  }
  ```

### 🔑 `POST /api/auth/login`:
- Login with your credentials to get a JWT token for further API calls.
- *Example Request Body*:
  ```json
  {
    "email": "testuser@example.com",
    "password": "password123"
  }
  ```

### 📚 `POST /api/books`:
- Add a new book to the library.
- *Example Request Body*:
  ```json
  {
    "title": "New Book Title",
    "author": "Author Name",
    "category": "Fiction",
    "rating": 5,
    "price": 19.99
  }
  ```

### 🔍 `GET /api/books`:
- Get a list of all books in the library.

### 📖 `GET /api/books/{id}`:
- Get details of a single book by its ID.

### ✏️ `PUT /api/books/{id}`:
- Update book details like title, author, or rating.

### 🗑️ `DELETE /api/books/{id}`:
- Delete a book from the library (Admin only).

### 🔎 `GET /api/books/search`:
- Search for a book by its title.

### 🧑‍🏫 `GET /api/books/filter`:
- Filter books by category, author, or rating.

## 🛠️ Tech Stack:
- **Spring Boot** for backend magic.
- **PostgreSQL** for robust database handling.
- **JWT** for secure token-based authentication.
- **RESTful API design** for a smooth, efficient interface.

## 🚨 Error Handling:
If something goes wrong, you'll get clear, easy-to-understand error messages to guide you to a solution. No headaches, just fast fixes.

## 📈 Analytics:
Track your API usage easily and always stay on top of your book data. Add, modify, or delete as you see fit – the power is in your hands.

## 🔒 Security:
Your data is safe with us! We use **JWT Authentication** to ensure that only authorized users can perform sensitive operations like adding, updating, or deleting books.

## 🚀 Ready to Get Started?
Clone the repo, run the app, and you’re good to go! Let's start building the next bestseller library. 📚🔥

---

### Stay curious. Stay secure. Stay awesome! 👏
