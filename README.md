# ✨ Mon pendu à moi ✨

Nous allons créer une application web permettant de créer et jouer à des parties de pendu. 🔥

Le pendu est un jeu consistant à trouver un mot en devinant quelles sont les lettres qui le composent.

Notre application sera basée sur une stack technique :

- Angular / Typescript (client)
- Spring / Java (serveur)
- PostgresSQL (base de données).

## 🦺 Comment démarrer 🦺

### Server / API

Créez un nouveau projet Spring à partir de Spring initializr, ce projet doit:

- utiliser le système de build maven
- être sur la dernière version stable de Spring
- avoir un name de groupe : com.zenika.zacademy
- avoir un nom d'artefact + nom de projet : pendu-api
- type de packaging: jar
- version de java : 21

A vous de décider quoi ajouter comme dépendances 🧐.
Le code généré doit être placé dans le dossier server.

### Client / Front

Créez un nouveau projet avec la CLI Angular, ce projet doit:

- utiliser la dernière version d'Angular
- avoir comme nom (package.json): pendu-front
- ne pas gérer de SSR (server-side-rendering)

Pas de contrainte sur l'usage de composant standalone, SCSS ou autre.
A vous de décider quoi ajouter comme fonctionnalités / dépendances 🧐.

Pour faciliter la création d'IHM, vous pouvez vous aider d'une librairie de composants graphiques, exemple:

- Angular Material
- NgBootstrap
- PrimeNG

### Base de données

A vous, d'ajouter la configuration nécessaire pour démarrer une base de données PostgresSQL.

## 💬 Glossaire 💬

Administrateur : personne qui, connectée, peut créer des parties
Joueur : personne qui va jouer les parties des autres
Jeu : entité qui contient le mot à deviner et un nombre de parties
Partie : déclinaison du jeux pour chaque joueur

## 📝 Listes des fonctionnalités 📝

### Côté admin

- Un administrateur peut s'inscrire et se connecter avec, par exemple, un email & mot de passe
  - Tout le monde peut créer un compte administrateur
- Un administrateur peut créer un nouveau jeu en choisissant le mot qu'il veut faire deviner et la description du jeu
  - Chaque administrateur a ses propres jeux
- Un administrateur ne peut pas supprimer un jeu créé
- Un administrateur peut partager un code permettant de jouer à un jeu créé (un code unique, ça peut être un [uuid](https://www.baeldung.com/java-hibernate-uuid-primary-key) par exemple)
- Un administrateur peut voir les jeux qu'il a déjà créé

🚨 Les mécaniques d'authentification ne sont pas obligatoires. 🚨
Vous pouvez commencer par créer l'application sans authentification et l'ajouter par la suite.

#### Bonus

- Un administrateur peut choisir des indices pour son jeu lors de la création
- Un administrateur peut modifier les indices du jeu
- Un administrateur peut voir sur sa liste de jeux les informations associées à ceux-ci:
  - combien de personnes ont terminé une partie du jeu ?
  - combien de personnes ont réussi une partie du jeu ?

### Côté joueur

Pour les fonctionnalités non bonus il faudra que les endpoints de jeu côté API soient publiques et non-authentifiés.

- Un joueur peut jouer à un jeu précis en rentrant le code associé : il joue une partie d'un jeu
- Pendant la partie, le joueur pourra via un input tester des lettres pour cette partie
  - Si la lettre est dans le mot, elle s'affiche dans le résultat
  - Si elle n'est pas dans le mot, le compteur d'essai s'incrémente
- Un joueur visualise pendant sa partie la description du jeu
- Un joueur peut visualiser le nombre d'essai qu'il lui reste
- Un joueur peut voir les lettres qu'il a trouvées dans le résultat
- Un joueur doit savoir quand il a gagné ou perdu la partie

#### Bonus

- Un joueur peut jouer à un jeu random tiré au hasard dans la base
- Dessiner un pendu en SVG sur le front en fonction du nombre dans le compteur d'essais d'une partie

## Modèles des données

### Admin

Un administrateur doit avoir:

- un identifiant unique
- un username unique
- un password
- une liste de jeux associés (vide par défaut)

### Jeu

Un jeu doit:

- avoir un identifiant unique (uuid ?)
- avoir un mot à faire deviner
- stocker une phrase de description courte, qui servira de nom de jeu
- permettre de stocker des indices, 3 au maximum (optionnel)

### Partie

Une partie doit :

- avoir un identifiant unique (uuid ?)
- être rattaché à un jeu
- stocker le nombre d'essai en cours
- stocker les lettres déjà essayées
- avoir un état (WON, LOST, ONGOING)

## Attendus

Vous devrez développer l'intégralité de la stack nécessaire au fonctionnement de l'application à savoir :

- L'API pour accéder aux données
- La base de données
- Le front pour pouvoir jouer au jeu
  - Une section admin pour l'administration
  - Une section public pour les parties de jeu

Vous pouvez tout mettre dans le même dépôt pour une gestion simplifiée du code (monorepo) en ayant deux répertoires :

- server: comprend le code lié à notre API Rest Java + Spring
- client: comprend le code lié à notre client Angular + Typescript

## Notation

Comme d'habitude, on privilégie une application avec un peu moins de fonctionnalités mais qui fonctionne correctement plutôt qu'une application avec beaucoup de fonctionnalités non terminées.

Pensez à créer des requêtes de test via Postman ou Insomnia lors du développement de votre API.

🙏 SVP quelques tests 🙏

La répartition de la notation est grossièrement de :

- 50% pour la partie back
- 40% pour la partie front
- 10% pour l'intégration continue, les livrables, la documentation et les tests

Il n'y a pas de barème précis pour chaque tâche. Le cahier des charges est volontairement trop long pour la durée de l'évaluation, ce qui vous permet (en partie) de choisir sur quelles fonctionnalités travailler.
