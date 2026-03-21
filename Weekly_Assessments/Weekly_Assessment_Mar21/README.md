# LMS User Management System

A full-stack Learning Management System (LMS) authentication module built with **Spring Boot** for the backend and **JavaScript/CSS3** for the frontend. This project implements strict sequential validation and a modern, compact Glassmorphism UI.

---

## Project Requirements & Logic

This application follows a specific sequential order for all validation checks. Checks are triggered only when the user clicks the "Sign Up" or "Login" button.

### 1. Registration Flow (Sign Up)
1.  **Mandatory Fields:** Checks if Username, Full Name, Email, Password, and Confirm Password are empty. Displays "Field is mandatory" under the specific empty field.
2.  **Email Duplicate Check:** If the email exists in the DB, the user is redirected to the login page with a message: "User with that email already exists."
3.  **Username Duplicate Check:** If the username is already taken, the user stays on the registration page, and a message appears below the Username field.
4.  **Password Strength Check:** Validates a minimum of 6 characters containing at least 1 uppercase, 1 lowercase, 1 digit, and 1 symbol.
5.  **Password Match Check:** Ensures Password and Confirm Password are identical.

### 2. Login Flow
1.  **Input Selection:** A radio button allows the user to choose between entering an **Email** or a **Username**.
2.  **Mandatory Fields:** Checks if both input fields have values.
3.  **Credential Discovery:** If the entered Email/Username is not found in the DB, an error is shown below the credential field.
4.  **Password Verification:** If the user is found, it verifies the password. If incorrect, an error appears under the password field.

---

## Project Structure

```text
src/
 └── main/
      ├── java/com/lms/app/
      │    ├── controller/      # UserController (REST Endpoints)
      │    ├── model/           # User Entity (JPA)
      │    ├── service/         # UserService (Sequential Business Logic)
      │    ├── repository/      # UserRepo (Data Access)
      │    └── exceptions/      # GlobalException & Custom Exception classes
      └── resources/
           ├── static/          # Frontend Web Root
           │    ├── css/        # style.css (Compact Design)
           │    ├── js/         # script.js (Fetch API & Logic)
           │    ├── login.html
           │    ├── registration.html
           │    └── dashboard.html
           └── application.properties # Server & DB Config
