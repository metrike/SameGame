import javax.swing.*;
/**
* La classe <b><code>TabChoix</code></b> sert \u00e0 affciher les images en jeu.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class Remplir_Tab {
    /**
    * Composante pour recuperer le pion rouge.
    */
    public ImageIcon rouge = new ImageIcon("./image/rouge.png");

    /**
    * Composante pour recuperer le pion bleu.
    */
    public ImageIcon bleu = new ImageIcon("./image/bleu.png");

    /**
    * Composante pour recuperer le pion vert.
    */
    public ImageIcon vert = new ImageIcon("./image/vert.png");

    /**
    * Composante pour recuperer le pion rouge au survol.
    */
    public ImageIcon rouge_survol = new ImageIcon("./image/rouge_select.png");

    /**
    * Composante pour recuperer le pion bleu au survol.
    */
    public ImageIcon bleu_survol = new ImageIcon("./image/bleu_select.png");

    /**
    * Composante pour recuperer le pion vert au survol.
    */
    public ImageIcon vert_survol = new ImageIcon("./image/vert_select.png");

    /**
    * Composante pour recuperer l'image apres avoir clique\u00e9.
    */
    public ImageIcon fond = new ImageIcon("./image/fond_b.png");

    /**
    * Composante pour afficher la boule rouge.
    */
    public JLabel labrouge = new JLabel(rouge);

    /**
    * Composante pour afficher la boule bleu.
    */
    public JLabel labbleu = new JLabel(bleu);

    /**
    * Composante pour afficher la boule vert.
    */
    public JLabel labvert = new JLabel(vert);

    /**
    * Composante pour afficher la boule rouge au survol.
    */
    public JLabel labrouge_survol = new JLabel(rouge_survol);

    /**
    * Composante pour afficher la boule bleu au survol.
    */
    public JLabel labbleu_survol = new JLabel(bleu_survol);

    /**
    * Composante pour afficher le pion vert au survol.
    */
    public JLabel labvert_survol = new JLabel(vert_survol);

    /**
    * Composante pour afficher l'image apres avoir cliqu\u00e9.
    */
    public JLabel labfond = new JLabel(fond);


    /**
    * Constructeur qui affiche les images.
    *
    *@param lettre lettre au cordon\u00e9e de la souris
    *@param panel fenetre de jeu 
    */
    public Remplir_Tab(String lettre,JPanel panel){
        if(lettre.equals("R")){
            panel.add(labrouge);
        }
        
        if(lettre.equals("V")){
            panel.add(labvert);
        }
        
        if(lettre.equals("B")){
            panel.add(labbleu);
        }
        if(lettre.equals("r")){
            panel.add(labrouge_survol);
        }
        
        if(lettre.equals("v")){
            panel.add(labvert_survol);
        }
        
        if(lettre.equals("b")){
            panel.add(labbleu_survol);
        }

        if(lettre.equals(" ")){
            panel.add(labfond);
        }
    }
}
