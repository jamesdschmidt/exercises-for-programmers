FROM openjdk:11.0.2-jre-slim
WORKDIR /
COPY target/todo-list*-fat.jar /app.jar
EXPOSE 8080
CMD java ${JVM_ARGS} -jar app.jar
