FROM maven:3.9.6-amazoncorretto-17 as builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


FROM openjdk:17-alpine

COPY --from=builder /app/target/gestion-bibliotheque.jar /opt/

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/opt/gestion-bibliotheque.jar"]