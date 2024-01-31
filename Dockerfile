# Utilisez l'image OpenJDK avec Java 17 comme base
FROM openjdk:17

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie de l'ensemble du contenu du répertoire de travail
COPY . .

# Ajout des permissions d'exécution au wrapper Gradle
RUN chmod +x gradlew

# Construction de l'application (en excluant l'exécution des tests)
RUN ./gradlew build -x test

# Copie du JAR construit
COPY build/libs/csa-backend-0.0.1-SNAPSHOT.jar .

# Exposition du port utilisé par votre application Spring Boot
EXPOSE 8080

# Commande de démarrage de l'application
CMD ["java", "-jar", "csa-backend-0.0.1-SNAPSHOT.jar"]
