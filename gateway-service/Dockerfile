FROM amazoncorretto:17.0.9-al2023-headless as extractor
WORKDIR /project-gateway-service
COPY target/app.jar /project-gateway-service/
RUN java -Djarmode=layertools -jar app.jar extract

FROM amazoncorretto:17.0.9-al2023-headless
WORKDIR /app
COPY --from=extractor /project-gateway-service/dependencies/. /app/.
COPY --from=extractor /project-gateway-service/spring-boot-loader/. /app/.
COPY --from=extractor /project-gateway-service/snapshot-dependencies/. /app/.
COPY --from=extractor /project-gateway-service/application/. /app/.
CMD ["java", "org.springframework.boot.loader.launch.JarLauncher"]