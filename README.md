### Spring Grade & Rank Services

Spring-grade-rank-services is a modular platform that demonstrates how grading and ranking logic can be built, reused, and deployed across multiple enterprise-level frameworks. The project progressively evolves the same business logic through classic Spring configuration, Spring Boot microservices, OSGi modular services, and finally Docker-based microservice containers. It shows how a simple domain problem like grade and rank computation can be implemented as an extensible and distributed set of services across modern backend technologies.

### 🧩 Project Overview

The platform begins with a traditional Spring bean configuration that encapsulates grading logic. A Grade bean converts numerical scores into letter grades by applying interval rules defined in XML configuration. The logic is intentionally designed to highlight inversion of control, dependency injection, and reusable Spring components.

Building on this, the ranking component introduces additional computation. The Rank bean accepts a list of scores, sorts them in descending order, and determines the ranking position of a target value. This demonstrates how multiple Spring beans can collaborate and how XML configuration wires reusable components together. The outcome is a working grade and rank system that operates as a standalone Spring application.

The same logic is then migrated into a Spring Boot microservice. Instead of running from the command line, the grading and ranking functions are exposed as REST endpoints such as /grade/{score} and /rank/{score}. This transforms the earlier Spring components into a lightweight HTTP service that can be consumed by external applications or frontend clients. It reflects the modern shift from monolithic Spring XML applications to self-contained REST microservices.

The platform is expanded further through OSGi, where the grading and ranking logic is separated into deployable service bundles. One bundle provides the statistical service interface, another consumes it, and a third exposes the results via a web layer. This demonstrates modularity, dynamic service registration, and runtime component replacement, all key features of OSGi-based enterprise systems. It shows how the same computation can be decomposed into interchangeable service units.

Finally, the system is containerized into Docker-based microservices. The Spring Boot service is packaged as a Docker image, allowing it to run in an isolated and reproducible environment. The assignment also includes a separate Python microservice that performs predictions based on models from earlier work, further validating the interoperability of microservices written in different languages. These Docker services reflect real-world deployment pipelines where independent components are orchestrated and scaled in container environments.

Across all stages, the business logic remains the same, but the architecture evolves. This highlights how enterprise developers reuse and migrate logic as systems move from classic Spring to modern microservices, OSGi modularity, and containerized deployment.

### 📁 Project Structure
```bash
Spring-grade-rank-services/
├── images/                      # Proof of outputs and UI snapshots
│   ├── grade-spring-bean.PNG
│   ├── rank-spring-bean.PNG
│   ├── rank-spring-boot-microservice.PNG
├── rank-spring/                 # Classic Spring configuration
│   └── src/main/java/ec/spring/
│       ├── Grade.java
│       ├── GradeImpl.java
│       ├── GradeApp.java
│       ├── Rank.java
│       ├── RankImpl.java
│       └── RankApp.java
├── rank-spring-boot/            # Spring Boot microservice
│   └── src/main/java/ec/springboot/
│       ├── config/
│       ├── controller/
│       └── service/
└── rank-spring-boot-ms/         # Docker-enabled microservice

```
---

### ⚙️ 1. Classic Spring Bean Application

🧠 Core Concepts

    Dependency Injection (IoC): GradeBeans.xml defines all grade and rank beans.

    Loose Coupling: Grade logic can be modified externally without touching Java code.

    Console Output Validation: Automatically prints letter grades and rank predictions.

▶️ Run Instructions
```           
    cd rank-spring
    mvn clean package
    java -cp target/rank-spring.jar ec.spring.GradeApp
```
📸 Output Proof

  ![Grade (Spring Bean)](./images/grade-spring-bean.PNG) 

   - Grade Boundary & Update Demo:

   - Rank Calculation Output:

The console output confirms both grade computation and dynamic reconfiguration of grade boundaries through Spring’s bean container.


### 🌐 2. Spring Boot REST Microservice

🧠 Core Features
   - Exposes endpoints to compute grades and ranks in real time.
   - Uses the same service logic (RankImpl, GradeImpl) now wired with Spring Boot’s annotation-based configuration.
   - Includes an interactive HTML page for API testing.

📡 REST Endpoints
    Endpoint	Description	Example Output
    /grade/{score}	Returns letter grade	{ "grade": "B" }
    /rank/{score}	Returns student rank	{ "rank": 22 }
    /grade-rank/{score}	Combined result	{ "grade": "B", "rank": 22 }
    /index-ms.html	HTML testing page	Links to all API endpoints

▶️ Run Instructions
   - cd rank-spring-boot
   - mvn clean package
   - java -jar target/rank-spring-boot.jar


Access the service at:
👉 http://localhost:8080/index-ms.html

📸 Output Proof

![Rank (Spring Bean)](./images/rank-spring-bean.PNG) 

The screenshot shows successful REST API responses for grade and rank retrievals, confirming JSON serialization and endpoint routing.


### 🐳 3. Dockerized Microservice (rank-spring-boot-ms)

🧱 Overview

    This stage containerizes the Spring Boot microservice for consistent deployment across environments.

🧰 Docker Setup

    Create Dockerfile in rank-spring-boot-ms/:
    FROM openjdk:17-jdk-slim
    WORKDIR /app
    COPY target/rank-spring-boot.jar app.jar
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","app.jar"]


Build and Run Container

    cd rank-spring-boot-ms
    docker build -t spring-grade-rank-ms .
    docker run -d -p 8080:8080 spring-grade-rank-ms


Verify

    curl http://localhost:8080/grade/76
    curl http://localhost:8080/rank/76

![Rank Spring Boot Microservice](./images/rank-spring-boot-microservice.PNG)

The containerized build ensures identical performance and behavior across developer machines, CI/CD pipelines, and production environments.


### 🔧 Configuration & Setup Notes
System Variables

Ensure the following environment variables are set for seamless builds:

    JAVA_HOME     = C:\Program Files\Java\jdk-17
    MAVEN_HOME    = C:\apache-maven-3.9.9
    DOCKER_HOME   = C:\Program Files\Docker


Add their /bin directories to your PATH, then verify:

    java -version
    mvn -v
    docker --version

Directory Consistency

### ⚠️ Important: Keep the project structure as-is 

(C:\enterprise\workspace\Spring-grade-rank-services) to prevent classpath and build reference issues.



### 🧪 Future Enhancements

Add unit tests using JUnit 5.

Integrate Swagger/OpenAPI documentation.

Enable CI/CD build via GitHub Actions.

Extend microservice to handle bulk score uploads via JSON.

### 📘 Summary

Spring Grade & Rank Services bridges foundational Spring learning with production-ready microservice deployment.
It demonstrates a professional, layered approach to Java development — from beans to REST to Docker.
