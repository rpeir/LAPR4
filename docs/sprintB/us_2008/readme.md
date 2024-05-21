# US 2008

*As a Teacher, I want to create/update automatic formative exams*

## 1. Context
*This task is to be completed in this sprint. It is the first time the task is assigned to be developed.*
## 2. Requirements

**US2008** As a Teacher, I want to create/update automatic formative exams

- **FRE01** - Create Exam A Teacher creates a new exam. This includes the specification
of the exam (i.e., its structure, in accordance with a grammar for exams that is used to
validate the specification of the exam)
- **NFR09** - Exam Language The support for exams (its design, feedback and grading)
  must follow specific technical requirements, specified in LPROG. The ANTLR tool should
  be used (https://www.antlr.org/).
## 2.1 Acceptance Criteria/ Comments
- The specification of formative exams is similar to regular exams, but the user specifies the type of questions to be inserted in the sections instead of the specific questions. When generating the automatic formative exam, the system should randomly create the questions (without repetition on a given exam). Also, formative exams do not have open and close dates. Feedback and grades are only provided at the end of the exam.
  The support for exams (its design, feedback and grading) must follow specific technical requirements, specified in LPROG.
  The ANTLR tool should be used (https://www.antlr.org/).

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

### 4.2. Class Diagram

![a class diagram](us_3004/class-diagram-01.svg "A Class Diagram")

### 4.3. Applied Patterns

### 4.4. Tests

**Test 1:** *Verifies that it is not possible to create an instance of the Example class with null values.*

```
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
	Example instance = new Example(null, null);
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*