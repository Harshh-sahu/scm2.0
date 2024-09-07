# Spring Boot Application with Tailwind CSS Frontend

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
