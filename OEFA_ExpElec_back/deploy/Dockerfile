FROM maven:3-amazoncorretto-17 as builder

RUN mkdir /app
WORKDIR /app

COPY target/oefa-plusd-siee-backend.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# Se esta usando Amazon Coreto porque se necesita un JDK que no haya deprecado el TLS 1.0, ya que es el unico que acepta
# la base de datos del SIIA, para la conexion a la BD
FROM amazoncorretto:17

ENV TZ=America/Lima
ENV SPRING_PROFILES_ACTIVE=redis
RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/dependencies/ ./
COPY --from=builder /app/spring-boot-loader/ ./
COPY --from=builder /app/snapshot-dependencies/ ./
COPY --from=builder /app/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
