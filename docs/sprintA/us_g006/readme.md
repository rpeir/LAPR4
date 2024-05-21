# US G006

**As a Project Managers, I want the system to support and apply authentication and authorization for all its users and functionalities**

## 1. Context

In this sprint, the team should implement the authentication and authorization mechanisms for the system, that will be used to control the access to the system's future functionalities.

## 2. Requirements

**US G006** As a Project Managers, I want the system to support and apply authentication and authorization for all its users and functionalities

- NFR08. The system must support and apply authentication and authorization for all its users and functionalities.

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*
*eapli.framework.infrastructure.authz was used to implement authentication. *

## 4. Design

*An analogous solution to the one implemented in ECafeteria was implemented. The authentication service was implemented using eapli.framework.infrastructure.authz*

![Sequence diagram for AddUser](AddUserECafeteria.png "AddUser functionality in eCafeteria")

Retrieved from https://bitbucket.org/pag_isep/ecafeteria-spring/src/master/documentation/AddUser/AddUser.png

### 4.1. Realization

*Authentication functionalities were implemented using the eapli.framework.infrastructure.authz framework.*

### 4.2. Class Diagram

*NA*

### 4.3. Applied Patterns

- Aggregate
- Entity
- Repository
- Factory

### 4.4. Tests

*NA, tested in the framework*

## 5. Implementation

*Major commits:*
- [e7f667a] Added bootstappers module
- [cc77bb8] Setting student login
- [3ca825d] added Teacher authentication methods
- [72595a1] Added Initial manager module; Added new database connection; Other small correction project-wide

## 6. Integration/Demonstration

*To integrate the authentication framework with the other components of the system, the team implemented authentication and authorization features within the application layer.*
The authentication framework was integrated with the RESTful API endpoints, so that only authenticated users with the appropriate permissions could access certain resources.*
Additionally, the framework was integrated with the database layer to store and manage user credentials and roles. Finally, the framework was integrated with the user interface layer*

*To test this functionality, you can run the run.sh script, and login into the app.*

## 7. Observations

*The eapli.framework.infrastructure.authz framework was used to implement authentication.*

