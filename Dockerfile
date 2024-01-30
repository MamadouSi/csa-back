# Utilisez l'image OpenJDK avec Java 17 comme base pour la phase de construction
FROM openjdk:17 AS builder

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie des fichiers Gradle et des sources de l'application
COPY build.gradle settings.gradle ./
COPY src ./src

# Construction de l'application
RUN ./gradlew build

# Utilisation d'une image OpenJDK plus légère pour l'exécution
FROM openjdk:17

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie du JAR construit depuis la phase précédente
COPY --from=builder /app/build/libs/csa-backend-0.0.1-SNAPSHOT.jar .

# Exposition du port utilisé par votre application Spring Boot
EXPOSE 8080

# Commande de démarrage de l'application
CMD ["java", "-jar", "csa-backend-0.0.1-SNAPSHOT.jar"]
