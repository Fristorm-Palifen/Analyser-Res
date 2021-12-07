# Preambule
### Pourquois ce Projet:
> Ce projet à été créé afin de realisé le projet de l'UE LU3IN033 de Sorbonne Universite: Faire un analyseur de trame hexadecimal réseau avec encapsulation Ethernet en traitant la couche Ethernet, IP, UDP, DHCP et DNS.

### Qui sont les auteurs?
> Nous avons choisi de garder notre anonyma puisque ce repository est visible publiquement et est partager a des fin d'aide sur une communauté. Nous avons sur ce compte github le repository privé ayant les commits specifique Sorbonne avec nos vrais nom pour si le besoin vient à se faire, prouver notre appartenance IRL au projet.

### Que puis-je faire de ce projet?
> Vous pouvez l'utilisé pour comprendre le fonctionnement d'une trame réseau mais aussi vous pouvez regarder comment est coder ce dernier et l'amilioré si vous le souhaitez en creant un "fork" du projet.


# Instruction de mise en place:
## Instruction de lancement:
### Faire attention:
> le logiciel doit etre placer avec au minimum dans le meme repertoire le dossier data (le logiciel dans ./ et le data dans ./data)

> Le logiciel ne doit pas avoir besoin de sudo ou des droit administrateur pour fonctionner. si c'est le cas, bouger simplement le repertoire dans un endroit libre de permission.

### Lancement:
> Pour lancer le logiciel vous devez lancer le reseau.jar comme un executable de votre machine. Si votre machinne n'a pas cette fonction: faite dans un terminal: java -jar ./Reseau.jar  (avec l'hypothese que vous avez la jre java https://www.java.com/fr/download/manual.jsp)
 
## Fichier a charger:
### Format:
> Le fichier doit commencer imperativement par un offset de 0000 suivie d'espace. chaque nouvelle tramme devrons avoir cet offset

> le fichier doit avoir sa partie en hexadecimal composer de block, de 2 chiffre hexa, espacer de minimum 1 espace (0A 0B 18 ff | par exemple) 

### Nommage du fichier:
> Le fichier doit imperativement avoir l'extention en .txt

> le fichier doit etre dans un repertoire accessible sans sudo ou droit administrateur!

> le path renseigner dans l'application doit etre absolue si le fichier est pas directement dans un sous repertoire du projet sinon relatif (en commenÃ§ant par ./) si dans un sous repertoire.
    
### Fichier de sortie:
> Le path du fichier de sortie est conseillez en path absolue meme si le .txt n'est pas renseignÃ© il sera enregistrer en txt (si vous voulez enregistrer dans votre bureau windows: renseignez C:\User\votrenom\Desktop\nomdufichier.txt)

> Le repertoire doit etre dans un repertoire accessible sans sudo ou droit administrateur et la permission d'ecrire doit etre obtenue sans sudo ou droit administrateur!


### Conseil en vrac:
> Nous vous conseillons de prendre une trame capturer a l'aide du logiciel Wireshark avec l'option "copy byte as Hex + ASCII Dump" (le logiciel est flexible mais une plus forte probabilité de reussite est garantie avec cette methode)
<img width="267" alt="image" src="https://user-images.githubusercontent.com/15380435/144995700-6fd1d3c9-d6d9-41f8-ad73-52f24e23fb50.png">

> Avant de commencer a analysÃ© vos fichier, nous vous conseillons de regarder si le logiciel arrive a decoder la trame: "./data/exemple7.txt" et "./data/exemple8.txt"

## Lancement depuis les sources:
> Vous devez avoir la jdk 16 ou plus.

> Avec le logiciel eclipse ou idea, lancez la class "Gui"
