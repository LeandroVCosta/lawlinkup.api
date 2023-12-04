FROM openjdk:17-jdk

WORKDIR /app

COPY lawlinkup-402320-04bc7fb65ea3.json /app/lawlinkup-402320-04bc7fb65ea3.json
COPY target/projeto-lawlinkup.jar /app/projeto-lawlinkup.jar

EXPOSE 8080

CMD ["java", "-jar", "projeto-lawlinkup.jar"]