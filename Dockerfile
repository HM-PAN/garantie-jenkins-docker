FROM java:8-jdk-alpine
COPY ./target/back-end-GarantieProject-0.0.1-SNAPSHOT.war /usr/app/
WORKDIR /usr/app
EXPOSE 8181
ENTRYPOINT ["java","-jar","back-end-GarantieProject-0.0.1-SNAPSHOT.war"]
