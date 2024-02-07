# Documentation du projet CSA Backend

## Description
Le projet **csa-backend** est une application backend développée pour gérer les données des étudiants, des formations, des promotions, etc., dans le système de gestion des étudiants (CSA). Il fournit des API RESTful pour interagir avec la base de données et répondre aux demandes provenant du frontend.

## Installation
Pour installer et exécuter l'application localement, suivez ces étapes :

1. Cloner le dépôt GitHub :
git clone <lien-du-dépôt>

3. Accéder au répertoire du projet :
cd csa-backend

4. Configurer la base de données :
- Créer une base de données MySQL.
- Modifier les informations de connexion dans le fichier `config/db.config.js`.

4. Installer les dépendances :
npm install

5. Lancer l'application :
npm start

L'application sera accessible à l'adresse `http://localhost:8081`.

## Fonctionnalités
- Gestion des étudiants : CRUD (Create, Read, Update, Delete) des informations des étudiants.
- Gestion des formations : CRUD des informations sur les formations disponibles.
- Gestion des promotions : CRUD des informations sur les promotions en cours.
- Authentification des utilisateurs avec JWT (JSON Web Tokens).
- Autorisation des utilisateurs basée sur les rôles (administrateur, étudiant, etc.).
- Validation des données entrantes avec Joi.

## Endpoints API
Les principaux endpoints de l'API sont les suivants :

- **GET /api/etudiant/read** : Récupère la liste des étudiants.
- **POST /api/etudiant/create** : Crée un nouvel étudiant.
- **PUT /api/etudiant/update/:id** : Met à jour les informations d'un étudiant.
- **DELETE /api/etudiant/delete/:id** : Supprime un étudiant.
- **GET /api/formation/read** : Récupère la liste des formations.
- **POST /api/formation/create** : Crée une nouvelle formation.
- **PUT /api/formation/update/:id** : Met à jour les informations d'une formation.
- **DELETE /api/formation/delete/:id** : Supprime une formation.
- **GET /api/promotion/read** : Récupère la liste des promotions.
- **POST /api/promotion/create** : Crée une nouvelle promotion.
- **PUT /api/promotion/update/:id** : Met à jour les informations d'une promotion.
- **DELETE /api/promotion/delete/:id** : Supprime une promotion.
- **POST /api/user/login** : Authentifie un utilisateur et renvoie un token JWT.

## Technologies utilisées
- Node.js : Environnement d'exécution JavaScript côté serveur
- Express.js : Framework Web pour Node.js
- MySQL : Système de gestion de base de données relationnelle
- JWT (JSON Web Tokens) : Méthode d'authentification sécurisée
- Joi : Bibliothèque de validation de données pour Node.js
- Sequelize : ORM (Object-Relational Mapping) pour Node.js

## Structure du projet
```
csa-backend/
+---build
|   +---classes
|   |   \---java
|   |       +---main
|   |       |   \---csaback
|   |       |       \---csabackend
|   |       |           |   CsaBackendApplication.class
|   |       |           |
|   |       |           +---config
|   |       |           |       CorsConfig$1.class
|   |       |           |       CorsConfig.class
|   |       |           |
|   |       |           +---controller
|   |       |           |       EtudiantController.class
|   |       |           |       FormationController.class
|   |       |           |       PormotionController.class
|   |       |           |       UserController.class
|   |       |           |
|   |       |           +---modele
|   |       |           |       Enseignant.class
|   |       |           |       Etudiant.class
|   |       |           |       Formation.class
|   |       |           |       Promotion.class
|   |       |           |       User.class
|   |       |           |
|   |       |           +---repository
|   |       |           |       EtudiantRepository.class
|   |       |           |       FormationRepository.class
|   |       |           |       PromotionRepository.class
|   |       |           |       UserRepository.class
|   |       |           |
|   |       |           \---service
|   |       |               +---etudiant
|   |       |               |       EtudiantService.class
|   |       |               |       EtudiantServiceImpl.class
|   |       |               |
|   |       |               +---formation
|   |       |               |       FormationService.class
|   |       |               |       FormationServiceImpl.class
|   |       |               |
|   |       |               +---promotion
|   |       |               |       PromotionService.class
|   |       |               |       PromotionServiceImpl.class
|   |       |               |
|   |       |               \---user
|   |       |                       UserService.class
|   |       |                       UserServiceImpl.class
|   |       |
|   |       \---test
|   |           \---csaback
|   |               \---csabackend
|   |                   |   EtudiantServiceImplTest.class
|   |                   |
|   |                   \---service
|   |                       \---etudiant
|   |                               EtudiantServiceImplTest.class

```
