FROM amazoncorretto:17.0.9-al2023-headless as extractor
WORKDIR /project-discovery-service
COPY target/app.jar /project-discovery-service/
RUN java -Djarmode=layertools -jar app.jar extract

FROM amazoncorretto:17.0.9-al2023-headless
WORKDIR /app
COPY --from=extractor /project-discovery-service/dependencies/. /app/.
COPY --from=extractor /project-discovery-service/spring-boot-loader/. /app/.
COPY --from=extractor /project-discovery-service/snapshot-dependencies/. /app/.
COPY --from=extractor /project-discovery-service/application/. /app/.
CMD ["java", "org.springframework.boot.loader.launch.JarLauncher"]