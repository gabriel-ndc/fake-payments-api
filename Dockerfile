FROM amazoncorretto:17

WORKDIR /opt/app

COPY ./AppServerAgent /opt/appdynamics

COPY ./target/fake-payments-api-0.0.1-SNAPSHOT.jar fake-payment-api.jar

ENV APPDYNAMICS_AGENT_APPLICATION_NAME=fake-payment-api
ENV APPDYNAMICS_AGENT_TIER_NAME=ecommerce
ENV APPDYNAMICS_AGENT_ACCOUNT_NAME=ndc-nfr
ENV APPDYNAMICS_CONTROLLER_HOST_NAME=ndc-nfr.saas.appdynamics.com
ENV APPDYNAMICS_CONTROLLER_PORT=443
ENV APPDYNAMICS_CONTROLLER_SSL_ENABLED=true
ENV APPDYNAMICS_JAVA_AGENT_REUSE_NODE_NAME=true
ENV APPDYNAMICS_JAVA_AGENT_REUSE_NODE_NAME_PREFIX=fake-payment-api

EXPOSE 8081

CMD ["java", "-javaagent:/opt/appdynamics/javaagent.jar", "-jar", "/opt/app/fake-payment-api.jar"]