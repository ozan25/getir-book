FROM openjdk:17

COPY book-app/build/libs/book-app.jar book-app.jar

EXPOSE 8080
ENV ENABLE_JSON_LOGGER=TRUE
ENTRYPOINT ["java","-jar","/book-app.jar"]
