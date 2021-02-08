FROM openjdk:8
ADD build/libs/locationfinder-0.0.1-SNAPSHOT.jar locationfinder.jar
EXPOSE 8095
ENTRYPOINT ["java","-jar","locationfinder.jar"]