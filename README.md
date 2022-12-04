#**Projet Programmation et Conception**
***
#### **Membres du Groupe :** SANCHEZ Nicolas et FATEH Nacer
***
Pour modifier quelle app lancer entre FireFighter et PaperScissorRock il faut changer la ligne en commentaire avec elle du dessus.
***
### **Explication**
****
**Patron de conception utilisés**
* **Visitor :** On utilise deux fois Visitor Pour `InterfaceVisitorPaint` qui visit les Entités pour les peindre, et
`VisitorGroundInterface` qui implemente `RockeryVisitor`, `RoadVisitor`, `MontanVisitor` celle-ci visite les Entité pour savoir si elle est accepté par la case.
interface en plus `AcceptGround` permet d'implementer dans les manager la methode qui accepte les visitor et donc de savoir si une case est accepté ou non.
* **Template Methode :** On utilise template Methode 4 fois dans le code pour `Entity`,`EntityManger`,`AbstractGrid`,`GroundAbstract`, celle-ci permette de ne pas dupliquer le code mais peuvent aussi etre remplacer par
des Interface pour Utiliser Strategy. Elle est implementer Respectivement par les `Entity`, les `EntityManger`, les `Grid`, le `GroundManager`.
* **Strategy :** On Utilise Strategy Pour implementer les Model et donc Pour pouvoir changer de model facilement.

**Structure**
  
* **generalPackage :** ce package contient les classe général, il Permet d'implementer le necessaire a la creation d'une autre App. Il contient Le Visitor et sont implementation pour peindre chaque entité de n'importe quelle App
L'implementation des Entités et des Manager, de La grid, du Ground et du Model.
* **fireFighters et RockPaperScissor :** c'est deux Package implement respectivement la tache 1 et 2 du Projet a l'aide du package general, chaque classe étende ou implemente une classe de ce package.

**Commentaire :** 

Je pense quoin a fait ce qu'on pouvait pour respecter au maximum les Principe Solide meme si certain changement sont encore possible pour améliorer le code et le rendre plus SOLIDE comme l'implementation de grid et de Model qui pourrait être mieux faite et donc au lieux d'implementé les deux pour crée
une nouvelle App nous aurons seulement la grid ou le Model a Implementer.
