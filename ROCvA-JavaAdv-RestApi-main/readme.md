# Recipe Management Application

This is a simple Recipe Management Application built with Spring Boot, JPA, and Hibernate.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- [Java Development Kit (JDK) 21 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

## Getting Started

Follow these steps to get the project up and running on your local machine.

### 1. Clone the Repository

Open your terminal and run the following command to clone the repository:

```bash
git clone https://github.com/your-username/recipe-management-app.git
```

### 2. Navigate to the Project Directory
```bash
cd recipe-management-app
```

### 3. Build the Project
Use Maven to build the project:
```bash
mvn clean install
```

### 4. Run the application
After the build is successful, run the application using the following command:
```bash
mvn spring-boot:run
```
Or use the run and debug-options in VS Code


### 5. Access the Application
Once the application is running, you can access it at:
```bash
http://localhost:8080/swagger-ui/index.html
```


## Project Structure
**demo** - Contains the main application code
**resources** - Contains application configuration files
**demo** - Contains test cases
### Key Classes
**Recipe** - The entity class representing a recipe
**RecipeRepository** - The repository interface for CRUD operations on recipes
**RecipeService** - The service class containing business logic for managing recipes

### Troubleshooting
If you encounter any issues, please check the following:
- Ensure you have the correct versions of JDK and Maven installed
- Ensure your database is running and accessible
- Check the application logs for any error messages