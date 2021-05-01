# Prank SMTP

## Description

Ce projet à pour but d'envoyer des mails pour prank des gens. Une application client TCP est développé en java pour utiliser une socket API pour communiquer avec un serveur SMTP. Le prank fonctionne ainsi : Le client prend une liste d'adresse mail et des messages et formes des groupes de personnes qui seront soit envoyeur soit receveur et transmet les messages entre eux. Un fichier de configuration est mis à disposition pour la formation des groupes des envoyerus/receveurs et pour choisir l'adresse IP et le port du serveur SMTP.



## Mockmock

https://github.com/tweakers/MockMock

Télécharger le MockMock.jar et exécuter la commande suivante : `java -jar MockMock.jar`

par défaut, MockMock run sur le port 25 pour le serveur SMTP et sur le port 8282 pour l'interface web [http://localhost:8282/]. Si on veut le faire run sur d'autre numéro de port, il faut exécuter cette commande : `java -jar MockMock.jar -p 25000 -h 8080` et on aura le SMTP sur le port 25000 et le http sur le port 8080.



