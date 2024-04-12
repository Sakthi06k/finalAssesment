FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /Assesments/

COPY . .

# CMD ["mvn", "clean", "test", "-Dtest=Test5"]
RUN mvn clean install