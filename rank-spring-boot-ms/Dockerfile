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
