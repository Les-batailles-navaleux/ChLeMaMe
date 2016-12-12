# BatailleNavale
Repo pour le TP en groupe

## Index
- [Utiliser git](#git-use)

<a name="git-use"></a>
## Utilisation de git

Si vous souhaitez contribuer a la repo (changer le code pour le mettre a jour ou corriger une erreur ou rajouter un commentaire ou quoi que ce soit) et que vous ne connaissez pqs GitHub voici la procedure a suivre.

### Creer un compte

Je pense que jusque la vous n'avez pas besoin de moi :)

### Copier la repo sur votre machine

Dans votre terminal (placer vous dans le dossier ou vous souhaitez copier la repo :P)  tapez la commande suivante :  
`git clone https://github.com/c-c-l/MIASHS-TP-Java.git`  
Ensuite placez vous dans la repo avec  
`cd MIASHS-TP-Java/`  
et créez votre branche, **ne modifiez surtout pas les fichiers via la branche master** :  
`git checkout -b ma-super-branche`  
Par convention on ecrit generalement un nom de branche en rapport avec la modification effectuee mais je sais que certains preferent utiliser une branche avec leur nom. C'est un peu comme vous voulez car on est entre nous :)

Vous pouvez verifier dans quelle branche vous vous trouvez a tout moment en tapant  
`git branch`  
Le nom de la branche sur laquelle vous travaillez s'affichera avec une petite asterisque avant son nom.

### Faire des modifications 

Vous pouvez ensuite modifier les fichiers de la repo tranquillou (pas besoin d'etre sur le terminal pour les modifier) :)  
Une fois vos modifications effectuees et sauvegardees retournez sur le terminal et tapez `git status` afin d'observer les modifications.  
Les fichiers modifies apparaissent sous la forme suivante :   
`modified:       my.file`  
Comme indique dans le commentaire vous pouvez ajouter la modification en tapant  
`git add nomdufichier`  
ou annuler les changement en tapant  
`git checkout nomdufichier`  
Une fois les fichiers modifiees ajoutes vous devez envoyer vos changements avec la commande suivante :  
`git commit -m "Message contenant une indiquation sur la modification effectuee"`  
**Attention** votre message doit etre en anglais (bon ok en vrai je m'en fiche mais c'est la convention) et commencer par un des verbes suivants de preference : add, delete, change, fix, on utilise la forme imperative pour les messages, *je ne sais pas pourquoi ...*  
Une fois votre commit fait vous devez envoyer les changements.  
Tapez la commande suivante :  
`git push origin nomdevotrebranch`  
Si jamais il vous dit qu'origin n'est pas defini tapez la commande suivante :  
`git remote add origin https://github.com/c-c-l/MIASHS-TP-Java`  
et reessayez.  
Votre terminal va normalement vous demander votre nom d'utilisateur et ensuite votre mot de passe, une fois entres il enverra vos changements.

Peut etre qu'il explique mieux : [Git pour les debutants](http://christopheducamp.com/2013/12/16/gitHub-pour-nuls-partie-2/)

Il manque encore des infos mais je n'arrive plus a penser a quoi ajouter la tout de suite. 
Vous pouvez deja contribuer avec ceci :)
