FROM openjdk:17
EXPOSE 8080
ADD target/spring-app-development.war spring-app-development.war
ENTRYPOINT ["java","-war","/spring-app-development.war"]