# Use an official Java runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Java application JAR file to the container
COPY src/main/java/com/example/teammanagerapi/ /app/src/main/java/com/example/teammanagerapi/

# Expose the port that the application will run on
EXPOSE 8090

# Install MySQL client dependencies
RUN apt-get update && apt-get install -y --no-install-recommends \
    default-mysql-client \
    && rm -rf /var/lib/apt/lists/*

# Set the environment variables for the MySQL connection
ENV MYSQL_HOST=my-mysql-container
ENV MYSQL_PORT=3306
ENV MYSQL_DB=my-database
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=my-password

# Start the Java application
CMD ["java", "-jar"]