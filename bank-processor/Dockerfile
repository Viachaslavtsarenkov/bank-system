FROM amazoncorretto:17.0.9-al2023-headless as extractor
WORKDIR /project-bank-processor
COPY target/app.jar /project-bank-processor/
RUN java -Djarmode=layertools -jar app.jar extract

FROM amazoncorretto:17.0.9-al2023-headless
WORKDIR /app
COPY --from=extractor /project-bank-processor/dependencies/. /app/.
COPY --from=extractor /project-bank-processor/spring-boot-loader/. /app/.
COPY --from=extractor /project-bank-processor/snapshot-dependencies/. /app/.
COPY --from=extractor /project-bank-processor/application/. /app/.
CMD ["java", "org.springframework.boot.loader.launch.JarLauncher"]