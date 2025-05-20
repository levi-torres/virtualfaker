FROM openjdk:17
EXPOSE 8080
ADD target/virtualfake.jar virtualfake.jar
ENTRYPOINT ["java","-jar","/virtualfake.jar"]