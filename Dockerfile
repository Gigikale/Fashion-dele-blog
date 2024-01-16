FROM openjdk:17-oracle
LABEL authors="decagon"
COPY target/fashion_Dele_Blog-0.0.1-SNAPSHOT.jar deleblog-image.jar
EXPOSE 2111
EXPOSE 5432
ENTRYPOINT ["java", "-jar", "deleblog-image.jar"]