# Utilisez l'image adoptopenjdk avec Java 17 comme base
FROM adoptopenjdk:17-jdk-hotspot AS builder

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie des fichiers Gradle et des sources de l'application
COPY build.gradle settings.gradle ./
COPY src ./src

# Construction de l'application
RUN ./gradlew build

# Utilisation d'une image plus légère pour l'exécution
FROM adoptopenjdk:17-jre-hotspot

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie du jar construit depuis la phase précédente
COPY --from=builder /app/build/libs/csa-backend-0.0.1-SNAPSHOT.jar .

# Exposition du port utilisé par votre application Spring Boot
EXPOSE 8080

# Commande de démarrage de l'application
CMD ["java", "-jar", "csa-backend-0.0.1-SNAPSHOT.jar"]
