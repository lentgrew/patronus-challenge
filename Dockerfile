FROM openjdk:17
WORKDIR /usr/app
COPY build/libs/*.jar spring-boot-application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/spring-boot-application.jar"]