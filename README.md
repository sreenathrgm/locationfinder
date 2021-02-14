# Restful Webservices
Spring boot used for Restful API's for CRUD operations.
Swagger integration used for Rest ApI documentation to test the end points.It can also be disabled in higher environments with below property
```
spring.resources.add-mappings=false
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
For data storage and retrieval mongoDB cloud service used.
Vincenty’s formula used for Calculating the geographical distance (in kilometers or miles) between 2 points with extreme accuracy.
This formula is widely used in geographic information systems (GIS) and is much more accurate than methods for computing the great-circle distance (which assume a spherical Earth).
Embedded tomcat container runs on port 8090, changed to default due to some other resource is using the same port.

## Prerequisites
What things you need to install the software.

```
JDK1.8
Gradle5.X/ above
Cloud-hosted MongoDB service/MongoDB Community Edition 4.4
Docker Container
###Note: MongoDB Atlas is a hosted MongoDB service option in the cloud which requires no installation overhead and offers a free tier to get started.

```

## Usage
Build and Run the project locally with below command
```
gradle build && java -jar build/libs/locationfinder-0.0.1-SNAPSHOT.jar
```


## Run docker:
```
1.docker pull sreenathp/locationfinder

2.docker run sreenathp/locationfinder
```


## Swagger(OpenApi) UI to test end points
```
http://localhost:8095/swagger-ui.html
```
