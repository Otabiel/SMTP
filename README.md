# Laboratoire - SMTP

Auteurs : Basset Nils et Da Rocha Carvalho Bruno
Date : 02.05.2021

## Description

Ce projet à pour but d'envoyer des mails pour prank des gens. Une application client TCP est développé en java pour utiliser une socket API pour communiquer avec un serveur SMTP. Le prank fonctionne ainsi : Le client prend une liste d'adresse mail et des messages et formes des groupes de personnes qui seront soit envoyeur soit receveur et transmet les messages entre eux. Un fichier de configuration est mis à disposition pour la formation des groupes des envoyeurs/receveurs et pour choisir l'adresse IP et le port du serveur SMTP.



## Mode d'emploi de l'application

- Cloner le projet courant : https://github.com/Otabiel/SMTP.

- Lancer le serveur SMTP MockMock si besoin, comme expliqué ci-dessous, ou utiliser un serveur SMTP existant.

- Modifier `MailRobot/config/config.properties` pour enregistrer les infos du serveur SMTP (par défaut configurer pour le serveur MockMock) et le nombre de groupe de personne victime du prank (3 personne minimum par groupe).

- Modifier `MailRobot/config/messages.utf8` en utilisant la structure suivante :  Commencer par "Subject:" et séparer les messages par 3 underscore.

  ```txt
  Subject: Salut
  
  pranked
  ___
  Subject: Bonjour
  
  lel
  ___
  Subject: Tu sais pas quoi ?
  
  Nils va bien !
  ___
  ```

- Modifier `MailRobot/config/victimes.utf8` en listant toutes les adresses mails qu'on souhaite prank.

- Lancer la commande suivant : `java -cp target/MailRobot-1.0-SNAPSHOT.jar MailRobot` pour exécuter le prank.

## Lancement du serveur MockMock Dockerisé

Lancez le script `build.sh` situé dans le dossier `Docker`. 
Ensuite lancez le script `run.sh` et attendre que ceci appraisse dans votre terminal : 
```
Starting http server on port 8282
[main] INFO org.eclipse.jetty.server.Server - jetty-8.1.8.v20121106
[main] INFO org.eclipse.jetty.server.AbstractConnector - Started SelectChannelConnector@0.0.0.0:8282
```
> Si vous recontrez un conflit sur le port 8282, éditez le script `run.sh` afin de le changer.

Ensuite lancer le programme comme illustrer au point précédent.

## Mise en place d'un serveur MockMock SMTP

https://github.com/tweakers/MockMock

Télécharger le MockMock.jar et exécuter la commande suivante : `java -jar MockMock.jar`

par défaut, MockMock run sur le port 25 pour le serveur SMTP et sur le port 8282 pour l'interface web [http://localhost:8282/]. 

Si on veut le faire run sur d'autre numéro de port, il faut exécuter cette commande : `java -jar MockMock.jar -p 25000 -h 8080` et on aura le SMTP sur le port 25000 et le http sur le port 8080.



## Implémentation

Nous nous sommes inspiré des vidéos d'Olivier Liechti afin de parvenir a ce résultat. (https://www.youtube.com/watch?v=OrSdRCt_6YQ)

Donc nous avons implémenté les trois packages suivants :

- config - qui contient la classe permettant la lectures des fichiers de configuration
- model - qui contient tout ce qui gère la cération et la distribution des emails.
- smtp - contient le client SMTP
