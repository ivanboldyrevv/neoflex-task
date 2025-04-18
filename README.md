### Intro

This project-task for admission on course Neoflex-study Java Developer.

Task:
- Create a REST API app.
    1. Minimum requirements: The application accepts your average salary for 12 months and the number of vacation days - it responds with the amount of vacation pay that the employee will receive.
    2. Extra: When making a request, you can also specify the exact days of going on vacation, then the vacation pay should be calculated taking into account holidays and weekends.

- Endpoints:
        `/calculate?averageSalary={required}&vacationDays={required}&startVacation={non-required}`

### Installation & Run

To run the app, follow these steps:

Clone the repository:
```bash
git clone <repository-url>
```

Navigate to the project directory:
```bash
cd <project-directory>
```

Make sure you have Maven installed. If not, you can download it from Maven's official website.

Build and run the application using Maven:
```bash
mvn spring-boot:run
```

This will start the application on the default port 8080. You can then test the endpoints by sending requests to `http://localhost:8080`.

### API Documentation

The application comes with built-in OpenAPI documentation.

Once the app is running, you can access the API documentation by visiting:
- Swagger UI - a user-friendly interface to explore and test the API endpoints.
    1. goto `http://localhost:8080/swagger_ui/index.html`
- OpenAPI Spec - raw OpenAPI specification for the API.
    1. goto `http://localhost:8080/v3/api-docs`

### Requirements
- Java 11 or higher
- Maven 3.6 or higher