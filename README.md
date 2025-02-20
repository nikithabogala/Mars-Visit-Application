# (Mars Visit Application)

The Mars Visit Application is a multi-stage web application built using Spring Boot, Thymeleaf, Spring Data JPA, and Bean Validation. The application collects personal information, travel preferences, and health & safety details from applicants interested in visiting Mars.

# Overview

This project demonstrates how to create a multi-stage form where data is collected across several pages and finally persisted to a database. It uses:

Spring Boot for rapid application development and deployment.
Spring MVC and Thymeleaf for building dynamic web pages.
Spring Data JPA for data persistence.
Bean Validation (Hibernate Validator) to enforce input constraints.
Lombok to reduce boilerplate code.
H2 Database for an in-memory data store during development.
Prerequisites
Ensure you have the following software installed on your system:

Java Development Kit (JDK) 17

Apache Maven

An IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

Project Setup

Clone the Repository:

git clone https://github.com/nikithabogala/Mars-Visit-Application

cd mars-visit-application

Build the Project:

Use Maven to compile and package the application:

mvn clean package

This will generate an executable JAR file in the target directory.

Running the Application Locally
Start the Application:

Run the application by executing:

java -jar target/mars-visit-application-0.0.1-SNAPSHOT.jar


Live Application

https://mars-visit-application-ffl0.onrender.com/apply/personal
