# Use an official Java runtime as a base image
#FROM openjdk:11-jre-slim
FROM openjdk:17-ea-17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Java application JAR file to the container
COPY target/TeamManagerApi-0.0.1-SNAPSHOT.jar /app/

# Expose the port that the application will run on
EXPOSE 8080

# Start the Java application
CMD ["java", "-jar", "TeamManagerApi-0.0.1-SNAPSHOT.jar"]