FROM maven:latest

WORKDIR /app

COPY . .

RUN mvn clean install -U

EXPOSE 8080

ENTRYPOINT ["mvn", "spring-boot:run"]
