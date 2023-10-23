### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 
JVDC = javadoc

### REGLES ESSENTIELLES ###

Main.class : Main.java Menu.class
	${JC} ${JCFLAGS} Main.java

Menu.class : Menu.java Actionmenu.class
	${JC} ${JCFLAGS} Menu.java

Actionmenu.class : Actionmenu.java Grille.class
	${JC} ${JCFLAGS} Actionmenu.java

Grille.class : Grille.java TabAlea.class TabChoix.class Remplir_Tab.class Fin.class
	${JC} ${JCFLAGS} Grille.java

TabAlea.class : TabAlea.java
	${JC} ${JCFLAGS} TabAlea.java

TabChoix.class : TabChoix.java RecupFichier.class
	${JC} ${JCFLAGS} TabChoix.java

Remplir_Tab.class : Remplir_Tab.java
	${JC} ${JCFLAGS} Remplir_Tab.java

Fin.class : Fin.java ActionFin.class
	${JC} ${JCFLAGS} Fin.java

RecupFichier.class : RecupFichier.java
	${JC} ${JCFLAGS} RecupFichier.java

ActionFin.class : ActionFin.java
	${JC} ${JCFLAGS} ActionFin.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main
	
javadoc : ActionFin.class Actionmenu.class Fin.class Grille.class Main.class Menu.class RecupFichier.class Remplir_Tab.class TabAlea.class TabChoix.class
	${JVDC} ActionFin.java Actionmenu.java Fin.java Grille.java Main.java Menu.java RecupFichier.java Remplir_Tab.java TabAlea.java TabChoix.java

clean :
	$(RM) *.class
	$(RM) *.js
	$(RM) *.css
	$(RM) *.html
	$(RM) element-list
	$(RM) -r resources
	$(RM) -r script-dir
	$(RM) *.zip
	$(RM) -r jquery


### FIN ###