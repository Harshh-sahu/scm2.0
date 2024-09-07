# Spring Boot Application with Tailwind CSS Frontend



Here is a description for the Smart Contact Manager project:

Smart Contact Manager
Smart Contact Manager is a web-based application built using Spring Boot for the backend and HTML, CSS, JavaScript for the frontend. It allows users to securely store, manage, and access their personal contacts in a centralized platform. Each user can create an account and maintain their own set of contacts with a user-friendly interface. The application is designed to handle multiple users, ensuring that each user’s contact information is private and accessible only to them.

Key Features:
User Authentication: Users can register, log in, and securely manage their accounts.
Contact Management: Add, edit, delete, and view contacts. Each contact includes fields such as name, email, phone number, and additional notes.
Image Upload: Users can upload profile pictures for each contact, with image files stored uniquely using a UUID filename for better organization and security.
Responsive Design: A clean and intuitive interface optimized for different screen sizes, enhancing the user experience.
Database Integration: Contacts are stored in a MySQL database with proper data integrity and security.
The project serves as a complete personal contact management solution, leveraging Spring Boot for backend processing and Thymeleaf for dynamic HTML rendering.



This is a Spring Boot application with a frontend designed using Tailwind CSS. The application handles backend operations and frontend styling with Tailwind CSS, which is processed using the command `npx tailwindcss`.

## Prerequisites

Before running this application, make sure you have the following installed:

- Java 17 or later
- Maven 3.8+
- Node.js (for frontend and Tailwind CSS)
- MySQL (or any database configured in the `application.properties` file)

## Setup Instructions

### 1. Clone the Repository

git clone https://github.com/harshh-sahu/scm20.git
cd your-repository
2. Configure the Database
Ensure the application.properties file contains the correct configuration for your MySQL (or other) database:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/your-database?serverTimezone=UTC
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
3. Install Backend Dependencies
Run the following command to install all the required backend dependencies:


mvn clean install
4. Run the Spring Boot Application
You can start the Spring Boot application by running:



mvn spring-boot:run
This will start the backend server on http://localhost:8080.


5. Install Frontend Dependencies
Navigate to the frontend directory and install the required npm packages:




npm install
6. Start Tailwind CSS in Watch Mode
Run the following command to process Tailwind CSS and watch for any changes:


    npx tailwindcss -i .\src\main\resources\static\css\input.css -o src/main/resources/static/css/output.css --watch
    
    
This will generate the output.css file from the input.css file and keep updating it with any changes.

7. Access the Application
Once both the backend and frontend are running, you can access the application at http://localhost:8080.

Project Structure
src/main/java: Backend code (Spring Boot controllers, services, repositories)

src/main/resources/static: Frontend code (HTML, CSS, JS)

src/main/resources/templates: Thymeleaf templates for the web pages

src/main/resources/application.properties: Configuration file for database and other settings

License
This project is licensed under the MIT License - see the LICENSE.md file for details.
