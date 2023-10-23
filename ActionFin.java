import javax.swing.*;
import java.awt.event.*;
/**
* La classe <b><code>ActionFin</code></b> gere les actions de la page de fin
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class ActionFin implements MouseListener{
    JFrame f = new JFrame();

    /**
    * Constructeur qui gere les actions de la page de fin
    *
    *@param frame Fenetre de fin
    */
    public ActionFin(JFrame frame){
        this.f=frame; 
    }


    /**
    * Methode qui gere les cliques de la page
    *
    */
    @Override
    public void mouseClicked(MouseEvent e){

        if((e.getX()>260 && e.getX()<475) &&(e.getY()>455 && e.getY()<555)){ // ZONE REJOUER
            f.dispose();
            new Menu();
        }

        if((e.getX()>520 && e.getX()<740) &&(e.getY()>455 && e.getY()<555)){ // ZONE QUITTER
           f.dispose();
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
