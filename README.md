# Projet P2 - Fluffy

## Members

* Jonas Freiburghaus
* Romain Capocasale
* Vincent Moulin

## Matériel

camera ip (ONVIF)
camera usb to raspberry to ip
camera bluetooth to raspberry to ip

## Architecture réseau

* Sous réseau avec les caméras, serveur sur le réseau des caméras et ouvrir port 80
* Port forwarding (ip)

## Spécifications

### Phase 1 (MVP) :

#### Interfaces graphiques

* bouton pour ajouter une caméra
* ouverture de fenetre modale avec un formulaire pour la connexion de la caméra
* visualtisation de l'image de la caméra
* Afficher graphique sur l'image en cas de détection
* Afficher la date, et heures-minutes-secondes

#### Réseau

* Connection aux caméras IP en mode port forwarding (sans gateway)
* Envoie de notifaction mail lors de la detection

#### Detection image

* detection de visage
* Enregistrement de l'image en cas de détection

### Phase 2 :

#### Réseau

* Connexion sécurisé (via système de serveur -> SSL/TLS)

#### Caméra

* Contrôle des caméras  (ONVIF)
	* Démarer/Eteindre stream
	* Démarrer/Eteindre enregistrement
	* rotation image
	* zoom
	* capture écran
	* Récupérer information de la caméra (addr. mac., constructeur, ...)

#### UI

* information supplémentaire dans une fenetre modale pour lors du clic sur une caméra
* Afficher une aide sur le hover de la caméra

#### Détection

* Objet

#### Persistance

* Persistance des caméras(ip, nom, pièce) pour le client

### Phase 3 (Bonus) :

#### UI

* Bar de navigation
	* Onglets pour naviguer entre les diverses caméras
* Organisation hiérarchique des caméras (lieu, batiment, salle)
* Style in dark theme or white theme

#### Camera

* Sélectionner un bout de vidéo (interval)
* bouton start/stop pour enregistrement vidéo

#### Détection

* Detection visage familliers
* faux positifs (animaux, etc...)

#### Transformation d'images

* Zoom numérique
* Rotation de la vidéo
* Opacité
* exposition

#### Réseau

* Notifaction sur téléphone (via Telegram Bot API)
* Régler les fps
* Régler le nombre de connections
* Gérer le stockage de la vidéo
* Compresser les données
* mettre en place un VPN ?
* paramétrer un mot de passe sur les caméras



## Documentation

* [Bibliothèque ML pour JAVA](http://neuroph.sourceforge.net/index.html)
* [OpenCV](https://opencv-java-tutorials.readthedocs.io/en/latest/)
* [Bibliothèque caméra IP](http://webcam-capture.sarxos.pl/)
* [Envoie de mail Java](https://www.tutorialspoint.com/java/java_sending_email.htm)
* [ANT media server](https://github.com/ant-media/Ant-Media-Server)
* [Software existant](https://www.raymond.cc/blog/set-up-logitech-webcam-as-motion-detector-and-send-alert-via-sms-text-message/)
* [ONVIF](https://www.onvif.org/)
* [Telegram bot](https://telegram.org/blog/bot-revolution)
* [Doc OpenCv pour java](https://opencv-java-tutorials.readthedocs.io/en/latest/)
* [Capture image from webcam](https://stackoverflow.com/questions/276292/capturing-image-from-webcam-in-java)
* [Librairie webcam](https://github.com/sarxos/webcam-capture)
* [Exemple utilisation openCV avec java](http://answers.opencv.org/question/46638/java-how-capture-webcam-and-show-it-in-a-jpanel-like-imshow/)
* [exemple openCV java](http://rapidprogrammer.com/how-to-access-camera-with-opencv-and-java)
* [RSTP](https://reolink.com/rtsp-ip-camera-and-best-rtsp-camera-buying-guide/)
* [JMF]()
* [Install openCV for java](https://opencv-java-tutorials.readthedocs.io/en/stable/01%20-%20Installing%20OpenCV%20for%20Java.html)
