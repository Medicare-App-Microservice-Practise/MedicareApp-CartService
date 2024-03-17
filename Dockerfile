FROM openjdk:8
EXPOSE 8092
ADD target/MedicareApp-CartService-0.0.1-SNAPSHOT.war MedicareApp-CartService-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/MedicareApp-CartService-0.0.1-SNAPSHOT.war" ]