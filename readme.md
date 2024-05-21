[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10489080&assignment_repo_type=AssignmentRepo)
# Project eCourse

## 1. Description of the Project

This project is a simple eCourse application developed for Learning Systems (LS). It is a simple application that supports activities associated with teachers, students, and administrators.
It supports automated exams, shared boards, classes, meetings, and other activities.

## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

Make sure Maven is installed and on the PATH.

The java source is Java 1.8+ so any JDK 1.8 or later will work. However, in order to generate the javadoc and UML diagrams the JDK version must be *strictly 1.8*.

If using an Oracle database, you will need to change your maven settings for
downloading the Oracle drivers. see <https://blogs.oracle.com/dev2dev/entry/how_to_get_oracle_jdbc#settings> for more information.

run

    mvnw.cmd clean install
    rebuild-all.bat

or 

    mvnw clean install
    rebuild-all.sh

## 4. How to Execute Tests

Tests are executed automatically when building the project.

## 5. How to Run

make sure a JRE is installed and on the PATH

run script according to the application you want to run

    run-manager.bat
    run-teacher.bat
    run-student.bat

or

    run-manager.sh
    run-teacher.sh
    run-student.sh

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

run script

    deploy.bat

or

    deploy.sh
    

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    generate-plantuml-diagrams.sh


