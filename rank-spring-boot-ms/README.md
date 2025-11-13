Spring Boot Microservice on Docker

This section explains how to Dockerize the Spring Boot application rank-spring-boot.jar as a microservice.
Step 1: Project Setup

    Create a directory for the Spring Boot microservice Docker project:

    mkdir rank-spring-boot-ms
    cd rank-spring-boot-ms

    Place rank-spring-boot.jar (from Q1.3) inside the rank-spring-boot-ms directory.

Step 2: Create the Dockerfile

Create a file named Dockerfile with the following content:

# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY rank-spring-boot.jar /app/rank-spring-boot.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the JAR file when the container launches
ENTRYPOINT ["java", "-jar", "rank-spring-boot.jar"]

Step 3: Build the Docker Image

    In the rank-spring-boot-ms directory, build the Docker image:

    docker build -t rank-spring-boot-ms .

    This command tags the image as rank-spring-boot-ms.

Step 4: Run the Docker Container

Run the Docker container using the built image:

docker run -d -p 8080:8080 --name rank-spring-boot rank-spring-boot-ms

    -d runs the container in detached mode.
    -p 8080:8080 maps port 8080 of the host to port 8080 of the container.
    --name rank-spring-boot assigns a name to the running container.

Step 5: Test the Microservice

To test, use the endpoints provided in Question 1.3. Here’s an example of testing with curl:

curl http://localhost:8080/index-ms.html


To stop and remove the container:

docker stop rank-spring-boot
docker rm rank-spring-boot
