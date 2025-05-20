FROM openjdk:17
EXPOSE 8080
ADD target/virtualfaker.jar virtualfake.jar
ENTRYPOINT ["java","-jar","/virtualfake.jar"]