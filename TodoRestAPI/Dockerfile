


FROM openjdk:17
LABEL maintainer="Todo List Project"
VOLUME /tmp
ARG JAR_FILE= target/TodoRestAPI-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} todoList.jar
ENTRYPOINT ["java", "-jar", "/todoList.jar"]
CMD ["cmd 1"]
