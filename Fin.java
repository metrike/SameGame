import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
* La classe <b><code>Fin</code></b> affiche la page de fin avec le score
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class Fin extends JFrame {
    /**
    * Composante qui gere le score. 
    */
    public int score=0;
    
    /**
    * Composante qui recupere l'image de fond.
    */
    public ImageIcon icone = new ImageIcon("./image/image de fin.jpg");
    
    /**
    * Composante pour l'image.
    */
    public JLabel images = new JLabel(icone);

    /**
    * Composante pour afficher l'image.
    */
    public JPanel fond = new JPanel();

    /**
    * Composante pour afficher le score.
    */
    public JPanel panscore= new JPanel();
    
    /**
    * Composante pour tout afficher.
    */
    public JPanel all= new JPanel();
    
    
    
    /**
     * Constructeur qui affiche la page de fin.
     *
     *@param scorefin le score a la fin de la partie 
     */
    
    public Fin(int scorefin){
        super("SameGame");
        ActionFin af = new ActionFin(this);
        this.score=scorefin;
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        all.setLayout(null);
        fond.setBounds(0,0,1024,768);
        panscore.setBounds(0,575,1024,60);
        fond.add(images);
        fond.addMouseListener(af);
        RecupScore();
        all.add(panscore);
        all.add(fond);
        this.add(all);
        this.setVisible(true); 
    }

    /**
    * Constante qui sert a recuperer le score de la class Grille
    */
    public void RecupScore(){
        JLabel affiscore = new JLabel("SCORE :"+score);
        affiscore.setFont(new Font("Sérif",Font.BOLD,40));
        panscore.setBackground(new Color(124,175,219));
        affiscore.setForeground(new Color(0,84,166));
        panscore.add(affiscore);
    }
}
