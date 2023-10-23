import java.io.*;
import java.util.*;

/**
* La classe <b><code>TabChoix</code></b> sert \u00e0 remplir un tableau a l'aide d'un fichier.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/


public class TabChoix {

    /**
    * Composante d'un tableau muldimentionnel (R,V,B,r,v,b,' ').
    */
    char[][] tab=new char[10][15];

    /**
    * Composante pour savoir si le choix du fichier est bien fait.
    */
    int valider=0;

    /**
    * Composante pour savoir si le nombre de ligne est bon.
    */
    int ligne=0;

    /**
    * Composante pour savoir si le nombre de colonne est bon.
    */
    int colonne=0;

    /**
    * Methode qui remplie un tableau.
    *
    *@return le tableau apr\u00e8s l'avoir remplie avec un fichier
    */
    public char[][] choix() {
        String chemin;
        RecupFichier t=new RecupFichier();
        chemin=t.recuperation();
        
        int i=0;
        int j=0;
        try
        {
        FileInputStream file = new FileInputStream(chemin);   
        Scanner scanner = new Scanner(file);  
    
        
        while(colonne!=10){
            String s=scanner.next();
            
            if(s.length()==15){
                for(i=0; i<15;i++){  
                    char c = s.charAt(i);  
                    tab[j][i]=c;  
                }
                j++;
            }
            else{
                ligne=1;
            }
            colonne++;
        }
        if(ligne==1){
            System.err.println("Fichier mal écrit, il doit etre de 15 par 10 ! ");            
            valider=1;
        }
        
        scanner.close();    
        }
        catch(IOException e)
        {
            System.err.println("Fichier introuvable");
            valider=1;
        }
        return tab;
    }


    /**
    * Methode qui retourne une validation.
    *
    *@return valider (0 ou 1)
    */
    public int verif(){
        return valider;
    }
}