import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
* La classe <b><code>Grille</code></b> sert \u00e0 gerer les action sur la page du menu.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame implements MouseMotionListener,MouseListener {
    /**
    * Composante d'un tableau muldimentionnel (R,V,B,r,v,b,' ').
    */
    public char tab[][]=new char[10][15];

    /**
    * Composante d'un tableau au survol d'un groupe (0 ou 1).
    */
    public int tabsurvol[][]=new int[10][15];
    
    /**
    * Composante qui prend l'abscisse.
    */
    public int x;

    /**
    * Composante qui prend l'ordonn\u00e9e.
    */
    public int y;

    /**
    * Composante qui prend l'ancien abscisse.
    */
    public int ancienx;

    /**
    * Composante qui prend l'ancien ordonn\u00e9e.
    */
    public int ancieny;

    /**
    * Composante recupere les coordonn\u00e9e x de la souris.
    */
    public int posx;

    /**
    * Composante recupere les coordonn\u00e9e y de la souris.
    */
    public int posy;

    /**
    * Composante recupere temporairement les coordonn\u00e9e x de la souris.
    */
    public int tmpx;

    /**
    * Composante recupere temporairement les coordonn\u00e9e y de la souris.
    */
    public int tmpy;

    /**
    * Composante recupere temporairement la lettre dans le tableau de char.
    */
    public char tmplettre;

    /**
    * Composante recupere le score.
    */
    public double score=0.0;

    /**
    * Composante recupere le score en int.
    */
    public int intscore=0;

    /**
    * Composante recupere la taille du groupe.
    */
    public int boules=0;

    /**
    * Composante recupere la taille du groupe pour l'envoyer au calcul de score.
    */
    public int boulesscore=0;

    /**
    * Composante qui verifie si le groupe est de 1.
    */
    public boolean tupeutpascliquer;
    

    /**
    * Constructeur qui affiche la fenetre de jeu
    */
    public Grille(){
        super("SameGame");
        this.setSize(767,580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
    * Methode qui sert \u00e0 recup\u00e9rer le tableau si le mode de jeu choisie est Al\u00e9atoire.
    */    
    public void RecupTabAlea(){
        TabAlea ta = new TabAlea();
        tab=ta.alea();
    }

    /**
    * Methode qui sert \u00e0 recup\u00e9rer le tableau si le mode de jeu choisie est par fichier.
    *
    *@return si le fichier est correct (1 ou 0)
    */
    public int RecupTabChoix(){
        TabChoix t=new TabChoix();
        tab=t.choix();
        int validation=t.verif();
        if(validation==1){
            this.dispose();
            new Menu();
        }
        return validation;
    }
    
    /**
    * Methode qui affiche la page de jeux.
    */  
    public void ImageJeu(){

        JPanel panel =new JPanel();
        JPanel panscore = new JPanel();
        JLabel labscore = new JLabel("SCORE = "+ intscore);

        JPanel all= new JPanel();
        all.setLayout(null);
        panel.setBounds(0, 0, 750, 500);
        panscore.setBounds(0,500,750,40);
        labscore.setFont(new Font("Sérif",Font.BOLD,25));
        panscore.setBackground(new Color(124,175,219));
        labscore.setForeground(new Color(0,84,166));
        
        panel.setLayout(new GridLayout(10,15));
        
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                String lettre=Character.toString(tab[i][j]);
                
                new Remplir_Tab(lettre,panel);
                
            }
        }
        panscore.add(labscore);
        all.add(panel);
        all.add(panscore);
        this.add(all);
        panel.addMouseMotionListener(this);
        panel.addMouseListener(this);
        this.setVisible(true);
    }

    /**
    * Methode qui recup\u00e9re les Coordon\u00e9 x.
    *
    * @return la positon x de la souris
    */
    public int RecupX(){
        return x;
    }

    /**
    * Methode qui recup\u00e9re les Coordon\u00e9 y.
    *
    * @return la positon y de la souris
    */
    public int RecupY(){
        return y;
    }
    
    /**
    * Methode qui rafraichit le tableau de survol.
    */ 
    public void ResetTabSurvol(){
        for(int a=0; a<10;a++){  
            for(int b=0; b<15;b++){  
                tabsurvol[a][b]=0;
            }
        }
        boules=0;
        
    }

    /**
    * Methode qui verifie que la colonne est bien vide.
    *
    *@param colonnes position de la colonne (entre 0 et 14)
    *@return 1 si la colonne est vide et 0 si la colonne n'est pas vide 
    */ 
    public int VerifColonne(int colonnes) {
        for (int i=0; i<10; i++) {
            if (tab[i][colonnes]!=' ') {
                return 0;
            }
        }
        return 1;
    }

    /**
    * Methode qui decale la colonne \u00e0 gauche si celle-ci est vide. 
    */  
    public void BougeGauche () {
    	for (int k=0; k<10; k++) {
	        for (int j=0; j<14; j++) {
		        if (VerifColonne(j)==1) {
		            for (int i=0; i<10; i++) {
                        tab[i][j]= tab[i][j+1];
                        tab[i][j+1]=' ';
                    }
                }
            }
        }
        ImageJeu();
    }

    /**
    * Methode qui decale le pion vers le bas si le pion a \u00e9t\u00e9 cliqu\u00e9.
    */  
    public void ChuteBoule(){

        for (int k=0; k<10; k++) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<15; j++) {
                    if ((tab[i+1][j]==' ') && (tab[i][j]!=' ')) {
                        tab[i+1][j]= tab[i][j];
                        tab[i][j]=' ';
                    }
                }
            }
        }
        
    }

    /**
    * Methode qui recupere la taille du groupe et verifie qu'il soit superieure \u00e0 1.
    */  
    public void TailleGroupe(){
        
        for (int i=0; i<10; i++) {
            for (int j=0; j<15; j++) {
                if(tabsurvol[i][j]==1){
                    boules++;
                    boulesscore++;
                    tupeutpascliquer=false;
                    
                }
            }
        }
        if(boules==1){
            tab[RecupY()][RecupX()]=Character.toUpperCase(tab[RecupY()][RecupX()]);
            tabsurvol[RecupY()][RecupX()]=0;
            tupeutpascliquer=true;
        }
        Score(RecupX(), RecupY());
    }

    /**
    * Methode qui modifie le tableau lors du survol et change l'\u00e9tat et l'affichage de la grille
    */ 
    public void ModifTAb(){ 
        posx=RecupX();
        posy=RecupY();
        RefreshTab();
        if(tab[posy][posx]=='R'){
            tab[posy][posx]='r';
            tabsurvol[posy][posx]=1;
            tmplettre=tab[tmpy][tmpx];
            tmplettre=Character.toUpperCase(tmplettre);
            tab[tmpy][tmpx]=tmplettre;
            tmpx=posx;
            tmpy=posy;
        }
        if(tab[posy][posx]=='V'){
            tab[posy][posx]='v';
            tabsurvol[posy][posx]=1;
            tmplettre=tab[tmpy][tmpx];
            tmplettre=Character.toUpperCase(tmplettre);
            tab[tmpy][tmpx]=tmplettre;
            tmpx=posx;
            tmpy=posy;
        }
        if(tab[posy][posx]=='B'){
            tab[posy][posx]='b';
            tabsurvol[posy][posx]=1;
            tmplettre=tab[tmpy][tmpx];
            tmplettre=Character.toUpperCase(tmplettre);
            tab[tmpy][tmpx]=tmplettre;
            tmpx=posx;
            tmpy=posy;
        }
        AutourCase(posx, posy);
        TailleGroupe();
        ResetTabSurvol();
    }

    /**
    * Methode r\u00e9cursive qui regarde si les pions autour de lui dont de la m\u00eame couleur.
    *
    *@param x l'abcisse (entre 0 et 14)
    *@param y l'ordonn\u00e9e (entre 0 et 9)
    */  
    public void AutourCase(int x,int y){
        char tempL;
        tempL=tab[y][x];

        if(x>0){
            if (tab[y][x]==Character.toLowerCase(tab[y][x-1]) && tabsurvol[y][x-1]==0 && tab[y][x]!=' '){
                tab[y][x-1]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y][x-1]=1;
                AutourCase((x-1),y);
            }      
        }
        

        if(y>0){
            if (tab[y][x]==Character.toLowerCase(tab[y-1][x]) && tabsurvol[y-1][x]==0 && tab[y][x]!=' '){
                tab[y-1][x]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y-1][x]=1;
                AutourCase(x, (y-1));

            }

        }

        if(y<9){
            if (tab[y][x]==Character.toLowerCase(tab[y+1][x]) && tabsurvol[y+1][x]==0 && tab[y][x]!=' '){
                tab[y+1][x]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y+1][x]=1;
                AutourCase(x, (y+1));

            }
        }

        if(x<14){
            if (tab[y][x]==Character.toLowerCase(tab[y][x+1]) && tabsurvol[y][x+1]==0 && tab[y][x]!=' '){
                tab[y][x+1]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y][x+1]=1;
                AutourCase(x+1, y);

            }
        }
    }

    /**
    * Methode qui rafraichit le tableau de pion.
    */
    public void RefreshTab(){
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                char lettre_en_cours=tab[i][j];
                tab[i][j]=Character.toUpperCase(lettre_en_cours);
            }
        }
    }

    /**
    * Methode qui vide le tableau une fois cliquer 
    */  
    public void changerfond(){
        for(int dx=0; dx<10;dx++){  
            for(int dy=0; dy<15;dy++){
                if(Character.isLowerCase(tab[dx][dy])){
                    tab[dx][dy]=' '; 
                }
            }

        }
    }

    /**
    * Methode qui calcul le score
    *
    *@param x l'abcisse (entre 0 et 14)
    *@param y l'ordonn\u00e9e (entre 0 et 9)
    */
    public void Score(int x,int y){
        if(tab[y][x]!=' '){
            score=intscore+Math.pow(boulesscore-2.0, 2.0);
            if(boulesscore==1){
                score=intscore;
            }
            boulesscore=0;
        }
        RecupScore();
    }

    /**
    * Methode qui renvoie le score
    *
    *@return le score en jeu 
    */ 
    public int RecupScore(){
        int scoreajout=(int)score;
        return scoreajout;
    }

    /**
    * Methode qui verifie si c'est la fin du jeu 
    */ 
    public void VerifFin(){
        
        int fin=1;


         for (int y=9;y>1;y--){
            for(int x=0;x<14;x++){

                


                if(x>0){
                    if (tab[y][x]==tab[y][x-1] &&tab[y][x]!=' '){
                       fin=0;
                    }     
                }
                
        
                if(y>0){
                    if (tab[y][x]==tab[y-1][x] &&tab[y][x]!=' '){
                        fin=0;                       
                    }   
                }
        
                if(y<9){
                    if (tab[y][x]==tab[y+1][x] &&tab[y][x]!=' ' ){
                        fin=0;
                    }  
                }
        
                if(x<14){
                    if (tab[y][x]==tab[y][x+1] &&tab[y][x]!=' ') {
                        fin=0;
                    }
                }
            }
        }
                
        Fin(fin);      
    }

    /**
    * Methode qui affiche la page de fin et renvoie le score \u00e0 celle-ci
    *
    *@param fin une variable fin (1 ou 0)
    */ 
    public void Fin(int fin){

        if(fin==1){
            new Fin(intscore);
            this.dispose();
        }
    }

    
    /**
    * Methode qui s'execute apres un  clique sur la souris.
    */
    @Override
    public void mouseClicked(MouseEvent e)  {
        intscore=RecupScore();
        if(tupeutpascliquer!=true){
            changerfond();
            ChuteBoule();
            BougeGauche();
            TailleGroupe();
            score=score+0;
        }
        VerifFin();
        ModifTAb();
    }


    /**
    * Methode qui s'execute apres un deplacement de la souris.
    */
    @Override
    public void mouseMoved(MouseEvent e) {
            
        if((e.getX()/50>=0)&&(e.getX()/50<15)&&(e.getY()/50>=0)&&(e.getY()/50<10)){
            if(x==ancienx && y==ancieny){
                x=(e.getX()/50);
                y=(e.getY()/50);
            } 
            else{  
                ancienx=x;
                ancieny=y;
                RecupX();
                RecupY();
                
                ModifTAb();
            }
            ImageJeu();
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseDragged(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}