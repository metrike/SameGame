import javax.swing.*;
import java.awt.*;

/**
* La classe <b><code>Menu</code></b> affiche le menu.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

    

public class Menu extends JFrame {
    /**
    * Composante pour afficher l'image.
    */
    public JPanel panneau = new JPanel();

    /**
    * Composante pour recuperer l'image.
    */
    public ImageIcon icone = new ImageIcon("./image/image du menu.jpg");

    /**
    * Composante pour appeler l'image.
    */
    public JLabel images = new JLabel(icone);
    
    
   

    /**
     * Constructeur uniquement destin\u00e9 \u00e0  ajouter l'image \u00e0 afficher.
     */
    public Menu(){
        super("SameGame");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ajout_image();
        this.setVisible(true);
    } 
    /**
     * Affiche l'image du jeu. 
     */
    public void ajout_image(){
        Actionmenu m = new Actionmenu(this);
        panneau.add(images);
        panneau.addMouseListener(m);
        this.add(panneau);
    }
}