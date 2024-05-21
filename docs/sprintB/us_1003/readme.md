# US 1003

FRC02 - **Open/Close Enrollments in Course** Only managers are able to execute this functionality

## 1. Context

*It is the first time the task is assigned to be developed.*

## 2. Requirements

**US 1003** As Manager, I want to open and close enrollements in courses.

**Regarding this requirement we understand that it relates to the following requirements:**

- [US 1002](../us_1002/readme.md) - As Manager, I want to create courses.
- [US 1004](../us_1004/readme.md) - As Manager, I want to open and close courses.

## 3. Analysis

*We understand that for the manager to be able to open or close enrollments in a course, the course needs to be created first. Therefore, we need to implement the functionality to create courses first.*
*We also understand that for the manager to be able to open or close enrollments in a course, the course needs to be open first. Therefore, we need to implement the functionality to open and close courses first.*

### 3.1. Domain Model Extract

na

### 3.2. System Sequence Diagram

![SSD](US1003_SSD.svg "System Sequence Diagram")

## 4. Design

### 4.1. Realization

![Sequence Diagram](us_1003_SetEnrollmentState_SD.svg "Open/Close Enrollments in Course Sequence Diagram")

### 4.2. Class Diagram

![a class diagram](us_1003_CD.svg "A Class Diagram")

### 4.3. Applied Patterns

### 4.4. Tests

To be implemented.

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

UI:

```
    @Override
    protected boolean doShow() {
        String accept = "accept";
        String reject = "reject";
        final Iterable<Course> courses = ctrl.openCourses();
        if (!courses.iterator().hasNext()) {
            System.out.println("There are no open Courses.");
        } else {
            // show the list of courses
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the courses:",courses,new CoursePrinter());
            selector.show();
            // get the selected course
            Course course = selector.selectedElement();
            // get the course enrollment of the selected course
            Optional<CourseEnrollment> option = ctrl.findByCourse(course);
            if (option.isEmpty()){throw new IllegalArgumentException("The course does not have an enrollment yet");};
            CourseEnrollment courseEnrollment = option.get();
            final Iterable<EnrollmentApplication> enrollmentApplications = ctrl.listPendingApprovals(courseEnrollment);
            // show the list of pending applications of the selected course
            final SelectWidget<EnrollmentApplication> applications = new SelectWidget<>("Select one of the pending applications:",enrollmentApplications,new EnrollmentApplicationPrinter());
            EnrollmentApplication application = applications.selectedElement();
            // show the list of states to select
            final SelectWidget<String> status = new SelectWidget<>("Select the action:", Set.of(accept,reject));
            status.show();
            try {
                if (application != null && accept.equals(status.selectedElement())){
                    // change the status of the selected application
                    ctrl.processApproval(courseEnrollment, application, true);
                }else if (application != null && reject.equals(status.selectedElement())){
                    // change the status of the selected application
                    ctrl.processApproval(courseEnrollment, application, false);
                }
            }catch (ConcurrencyException ex){
                System.out.println("WARNING: It is not possible to edit the course details because it was changed by another user");
            } catch (final IntegrityViolationException ex) {
                LOGGER.error("Error performing the operation", ex);
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
            }
        }
        return true;
    }

````

## 7. Observations
