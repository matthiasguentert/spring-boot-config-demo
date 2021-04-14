FROM mcr.microsoft.com/java/jdk:11-zulu-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# https://spring.io/guides/gs/spring-boot-docker/
# https://spring.io/guides/topicals/spring-boot-docker/#:~:text=%20Spring%20Boot%20Docker%20%201%20A%20Basic,there%20are%20some%20tweaks%20you%20might...%20More%20

# Build image
# docker build -t myorg/myapp:dev .

# Peek into image
# docker run -ti --entrypoint /bin/sh myorg/myapp:dev

# Run image
# docker run -p 8080:8080 myorg/myapp

# Peek into running container
# docker exec -ti container_name /bin/sh