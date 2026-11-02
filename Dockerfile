# Image Java 21
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copie le JAR généré par le pipeline
COPY target/atelier-tests-unitaires.jar app.jar

# Indique que le conteneur contient le JAR
CMD ["sh", "-c", "echo 'Artefact atelier-tests-unitaires.jar disponible dans /app' && sleep infinity"]