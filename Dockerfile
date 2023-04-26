# Use an official Java runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Java application JAR file to the container
COPY src/main/java/com/example/teammanagerapi/ /app/src/main/java/com/example/teammanagerapi/

# Expose the port that the application will run on
EXPOSE 8080

# Start the Java application
CMD ["java", "-jar"]