FROM openjdk:8
EXPOSE 8181
COPY target/back-end-GarantieProject-0.0.1-SNAPSHOT.jar assuranceprojectbackend
ENTRYPOINT ["java","-jar","back-end-GarantieProject-0.0.1-SNAPSHOT.jar"]
