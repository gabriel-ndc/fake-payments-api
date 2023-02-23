FROM amazoncorretto:17

WORKDIR /app

COPY ./target/fake-payments-api-0.0.1-SNAPSHOT.jar ./payment-api.jar

CMD ["java", "-jar", "/app/payment-api.jar"]