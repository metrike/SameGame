import javax.swing.*;
import java.awt.event.*;

/**
* La classe <b><code>Actionmenu</code></b> sert \u00e0 gerer les action sur la page du menu.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class Actionmenu implements MouseListener {
  
  JFrame framemenu;
  /**
  * Composante d'un tableau muldimentionnel (R,V,B,r,v,b,' ').
  */
  public char tab[][]=new char[10][15];
  /**
  * Composante de verification (0 ou 1).
  */
  public int validation=0;
  

  /**
  * Constructeur qui recupere le fenetre du menu.
  *
  *@param frame fenetre de la page menu
  */

  public Actionmenu(JFrame frame){
    this.framemenu=frame;
  }
  
  
  /**
  * Methode qui s'execute apres un clique sur la souris.
  */
  @Override
  public void mouseClicked(MouseEvent e){
    if((e.getX()>120 && e.getX()<337) &&(e.getY()>500 && e.getY()<600)){  // ZONE FICHIER
      Grille grille=new Grille();
      grille.setVisible(false);
      validation = grille.RecupTabChoix();
      if(validation==0){
        grille.setVisible(true);
        grille.ImageJeu();
      }
      framemenu.dispose();
    }

    if((e.getX()>415 && e.getX()<625) &&(e.getY()>490 && e.getY()<600)){  // ZONE ALEATOIRE
      Grille grille=new Grille();
      grille.RecupTabAlea();
      grille.ImageJeu();
      framemenu.dispose();
    }

    if((e.getX()>720 && e.getX()<935) &&(e.getY()>490 && e.getY()<600)){ // ZONE QUITTER
      framemenu.dispose();
    }
    
  }

  public void mousePressed(MouseEvent e){}
  public void mouseExited(MouseEvent e) {}
  public void mouseEntered(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
}