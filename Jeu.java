package jeu;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Insets;
//import javax.swing.AbstractButton;

public class Jeu extends JPanel {
    private final int PLATEAU_SIZE = 500; // Taille carrée du plateau
    private JButton[][] cases;

    private int joueur=1;
    private int winner=0;
   // private boolean draw=false;

    Ecoute ecoute = new Ecoute(this);
    
    public Jeu() {
        setLayout(null); // Utilisation de null pour positionner les boutons manuellement
        setOpaque(true); // Fond opaque pour voir le plateau
        setBackground(new Color(240, 240, 240)); // Fond gris clair
        
        // Initialisation des boutons
        cases = new JButton[3][3];
        creerBoutons();
    }

    public int getjoueur(){
        return this.joueur;
    }
    public void setjoueur(int joueur){
        this.joueur=joueur;
    }

     public int getwinner(){
        return this.winner;
    }
    public void setwinner(int Winner){
        this.winner=Winner;
    }


    public JButton[][] getbutton(){
        return this.cases;
    }

   
    
    private void creerBoutons() {
        int caseSize = PLATEAU_SIZE / 3; // Taille d'une case
        
        // Position de départ du plateau (centré)
        int plateauX = (getWidth() - PLATEAU_SIZE) / 2;
        int plateauY = (getHeight() - PLATEAU_SIZE) / 2;
        
        for (int ligne = 0; ligne < 3; ligne++) {
            for (int colonne = 0; colonne < 3; colonne++) {
                if (cases[ligne][colonne] == null) {
                    cases[ligne][colonne] = new JButton();
                    add(cases[ligne][colonne]);
                }
                
                // Configuration du bouton
                cases[ligne][colonne].setContentAreaFilled(false);//fond transparent
               // cases[ligne][colonne].setBorderPainted(false);//pas de bordure
               // cases[ligne][colonne].setMargin(new Insets(0, 0, 0, 0));//pas de marge
               cases[ligne][colonne].addActionListener(ecoute);
                
                // Positionnement relatif au panel
                int x = plateauX + colonne * caseSize;
                int y = plateauY + ligne * caseSize;
                cases[ligne][colonne].setBounds(x, y, caseSize, caseSize);
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Joueur actuel: " + (joueur), 10, 20);

        if(winner!=0){
            g.setColor(Color.RED);
            g.drawString("winner: " + (winner), 100, 20);
            ecoute.redemmarer();
        }
      
        
        // Calcul du décalage pour centrer le plateau
        int xOffset = (getWidth() - PLATEAU_SIZE) / 2;
        int yOffset = (getHeight() - PLATEAU_SIZE) / 2;
        
        // Dessin du fond blanc du plateau
        g.setColor(Color.WHITE);
        g.fillRect(xOffset, yOffset, PLATEAU_SIZE, PLATEAU_SIZE);
        
        // Dessin des lignes du plateau
        g.setColor(Color.BLACK);
        // Lignes verticales
        g.drawLine(xOffset + PLATEAU_SIZE/3, yOffset, 
                  xOffset + PLATEAU_SIZE/3, yOffset + PLATEAU_SIZE);
        g.drawLine(xOffset + 2*PLATEAU_SIZE/3, yOffset, 
                  xOffset + 2*PLATEAU_SIZE/3, yOffset + PLATEAU_SIZE);
        // Lignes horizontales
        g.drawLine(xOffset, yOffset + PLATEAU_SIZE/3, 
                  xOffset + PLATEAU_SIZE, yOffset + PLATEAU_SIZE/3);
        g.drawLine(xOffset, yOffset + 2*PLATEAU_SIZE/3, 
                  xOffset + PLATEAU_SIZE, yOffset + 2*PLATEAU_SIZE/3);
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        repositionnerBoutons();
    }
    
    private void repositionnerBoutons() {
        if (cases == null) return;
        
        int caseSize = PLATEAU_SIZE / 3;
        int plateauX = (getWidth() - PLATEAU_SIZE) / 2;
        int plateauY = (getHeight() - PLATEAU_SIZE) / 2;
        
        for (int ligne = 0; ligne < 3; ligne++) {
            for (int colonne = 0; colonne < 3; colonne++) {
                if (cases[ligne][colonne] != null) {
                    int x = plateauX + colonne * caseSize;
                    int y = plateauY + ligne * caseSize;
                    cases[ligne][colonne].setBounds(x, y, caseSize, caseSize);
                }
            }
        }
    }

      


}