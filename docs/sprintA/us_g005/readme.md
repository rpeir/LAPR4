# US G005

**As Project Manager, I want the team to configure the project structure to facilitate / accelerate the development of upcoming user stories**

## 1. Context

The project structure should be configured with the necessary packages, libraries, frameworks and configurations to facilitate the development of the upcoming user stories.

## 2. Requirements

**USG005** As Project Manager, I want the team to configure the project structure to facilitate / accelerate the development of upcoming user stories

- NFR07. By configuration, the system must support that data persistence is done either "in memory" or in a relational database (RDB). Although in-memory database solutions can be used during development and testing, the solution must include a final deployment where a persistent relational database is used. The system should have the ability to initialize some default data.

## 3. Analysis

*The eCafeteria project was analyzed to understand how to best implement the database/persistence.*

## 4. Design

*NA*

### 4.1. Realization

*The database was implemented by jointly analyzing class instructions and the eCafeteria project and going through the necessary steps in this project. Analogous packages were created to accommodate bootstrappers, core, infrastructure, persistence and the apps.*

### 4.2. Class Diagram

*NA*

### 4.3. Applied Patterns

- Aggregate
- Entity
- Repository

### 4.4. Tests

*NA*

## 5. Implementation

*All necessary dependencies were added in pom.xml*

*Major commits:*
- [e81f9e6] Added eapli.framework dependency on pom.xml
- [ede1c08] Added persistence, core and infrastructure modules of the project

## 6. Integration/Demonstration

*The team used an Object-Relational Mapping (ORM) framework called Java Persistence API – JPA. The ORM was used to define Java classes that mapped to the tables in the database. The team also implemented a repository layer which abstracts away the underlying SQL code and will allow the rest of the application to interact with the database using simple method calls.*

*To test this functionality, you can deploy, create a new system user using run-manager and login with those credentials in either run-student or run-teacher.*

## 7. Observations

*NA*