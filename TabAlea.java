import java.util.*;

/**
* La classe <b><code>TabAlea</code></b> sert \u00e0 remplir un tableau al\u00e9atoirement.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/
public class TabAlea {
    /**
    * Composante d'un tableau muldimentionnel (R,V,B,r,v,b ou ' ').
    */
    public char[][] tab=new char[10][15];

    /**
    * Composante d'un valeur random (0,1 ou 2)
    */
    public Random choix=new Random();


    /**
    * Methode qui remplie un tableau al\u00e9atoirement.
    *
    *@return le tableau apr\u00e8s l'avoir remplie al\u00e9atoirement
    */
    public char[][] alea(){
        
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                int hasard=choix.nextInt(3);

                if(hasard==0){
                    tab[i][j]='R';
                }

                if(hasard==1){
                    tab[i][j]='B';
                }
                
                if(hasard==2){
                    tab[i][j]='V';
                }
            }
        }
        return tab;
    }
}