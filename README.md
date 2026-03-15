# Student Management API

Simple REST API built with **Spring Boot** to manage students, their subjects, and grades.

This project was developed using **Java, Spring Boot, JPA, and an H2 in-memory database**.

---

# Technologies

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (in-memory)
- Maven
- Lombok

---

# Database Model

The system is based on two relational tables.

### REGISTRO_ALUNO
Stores student information.

| Column | Description |
|------|------|
| matricula | Primary key |
| nome | Student name |
| sexo | Gender |
| nascimento | Birth date |

### ALUNO_MATERIAS
Stores subjects and grades for each student.

| Column | Description |
|------|------|
| id | Primary key |
| materia | Subject name |
| nota_final | Final grade |
| matricula | Foreign key referencing REGISTRO_ALUNO |

Relationship:

```
REGISTRO_ALUNO (1) ---- (N) ALUNO_MATERIAS
```

---

# API Endpoints

## Create Student

Creates a new student with subjects and grades.

**POST**

```
/students
```

Example request body:

```json
{
  "matricula": 1,
  "name": "Erik Oliver",
  "gender": "M",
  "birthDate": "1987-10-10",
  "subjects": [
    {
      "subject": "Matemática",
      "grade": 10
    },
    {
      "subject": "Física",
      "grade": 9
    }
  ]
}
```

---

## Get All Students

Returns all students with their subjects.

**GET**

```
/students
```

---

## Get Students With Grades Above 8

Returns only students that have subjects with grades greater than **8**.

**GET**

```
/students/high-grades
```

---

## Update Student

Updates student information and replaces the list of subjects.

**PUT**

```
/students/{matricula}
```

Example:

```
/students/1
```

Example request body:

```json
{
  "matricula": 1,
  "name": "Erik Oliver Updated",
  "gender": "M",
  "birthDate": "1987-10-10",
  "subjects": [
    {
      "subject": "Matemática",
      "grade": 10
    },
    {
      "subject": "História",
      "grade": 9
    }
  ]
}
```

---

# Running the Project

Clone the repository:

```
git clone https://github.com/vicmazzola/student-management-api.git
```

Run the application:

```
mvn spring-boot:run
```

The API will start at:

```
http://localhost:8080
```

---

# H2 Database Console

The in-memory database console can be accessed at:

```
http://localhost:8080/h2-console
```

Configuration:

```
JDBC URL: jdbc:h2:mem:studentdb
User: sa
Password: (empty)
```

---

# Notes

This API was implemented following a layered architecture:

```
Controller
Service
Repository
Database
```

DTOs are used for request input and entities represent the database model.

