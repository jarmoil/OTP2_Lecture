FROM maven:latest
LABEL authors="Jarmo"

WORKDIR /app
COPY pom.xml /app
COPY . /app
RUN mvn package
CMD ["java", "-jar", "target/javashoppingcartapplication.jar"]