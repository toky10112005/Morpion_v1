package jeu;

import java.awt.event.*;

import javax.swing.JButton;
import java.awt.Component;

import jeu.Jeu;


public class Ecoute implements ActionListener{

    private Jeu jeu;
      private char joueurActuel = 'X';
      private boolean draw=false;

    public Ecoute(Jeu jeu) {
        this.jeu=jeu;
    }
      @Override
    public void actionPerformed(ActionEvent e) {
        JButton boutonClique = (JButton) e.getSource();
        
        if (boutonClique.getText().isEmpty()) {
            
            boutonClique.setText(String.valueOf(joueurActuel));
            boutonClique.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 60));
            
            joueurActuel = (joueurActuel == 'X') ? 'O' : 'X';

            draw=Draw(jeu.getbutton());

            if(draw==true){
                redemmarer();
                jeu.repaint();
                return;
            }

            if(joueurActuel == 'X') {
                jeu.setjoueur(1);

             int winner=win(jeu.getbutton());
             jeu.setwinner(winner);


            } else {
                jeu.setjoueur(2);
                int winner=win(jeu.getbutton());
             jeu.setwinner(winner);
            }
            jeu.repaint();
        }
    }


      public int win(JButton[][] cases){
        
            String X=String.valueOf('X');
             String O=String.valueOf('O');

            if(cases[0][0].getText().equals(X) && cases[0][1].getText().equals(X) && cases[0][2].getText().equals(X)){
                return 1;
            }
            else if(cases[0][0].getText().equals(O) && cases[0][1].getText().equals(O) && cases[0][2].getText().equals(O)){
                return 2;
            }

            if(cases[1][0].getText().equals(X) && cases[1][1].getText().equals(X) && cases[1][2].getText().equals(X)){
                return 1;
            }
            else if(cases[1][0].getText().equals(O) && cases[1][1].getText().equals(O) && cases[1][2].getText().equals(O)){
                return 2;
            }

            if(cases[2][0].getText().equals(X) && cases[2][1].getText().equals(X) && cases[2][2].getText().equals(X)){
                return 1;
            }
            else if(cases[2][0].getText().equals(O) && cases[2][1].getText().equals(O) && cases[2][2].getText().equals(O)){
                return 2;
            }


            if(cases[0][0].getText().equals(X) && cases[1][1].getText().equals(X) && cases[2][2].getText().equals(X)){
                return 1;
            }
            else if(cases[0][0].getText().equals(O) && cases[1][1].getText().equals(O) && cases[2][2].getText().equals(O)){
                return 2;
            }

            if(cases[0][2].getText().equals(X) && cases[1][1].getText().equals(X) && cases[2][0].getText().equals(X)){
                return 1;
            }
            else if(cases[0][2].getText().equals(O) && cases[1][1].getText().equals(O) && cases[2][0].getText().equals(O)){
                return 2;
            }

            if(cases[0][0].getText().equals(X) && cases[1][0].getText().equals(X) && cases[2][0].getText().equals(X)){
                return 1;
            }
            else if(cases[0][0].getText().equals(O) && cases[1][0].getText().equals(O) && cases[2][0].getText().equals(O)){
                return 2;
            }


            if(cases[0][1].getText().equals(X) && cases[1][1].getText().equals(X) && cases[2][1].getText().equals(X)){
                return 1;
            }
            else if(cases[0][1].getText().equals(O) && cases[1][1].getText().equals(O) && cases[2][1].getText().equals(O)){
                return 2;
            }


             if(cases[0][2].getText().equals(X) && cases[1][2].getText().equals(X) && cases[2][2].getText().equals(X)){
                return 1;
            }
            else if(cases[0][2].getText().equals(O) && cases[1][2].getText().equals(O) && cases[2][2].getText().equals(O)){
                return 2;
            }

            return 0; 
            
        }

        public boolean Draw(JButton[][] button){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(button[j][i].getText().isEmpty()){
                        return false;
                    }
                }
            }
            return true;
        }
   
        public void redemmarer(){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    jeu.getbutton()[j][i].setText("");
                    //cases[ligne][colonne].setEnabled(true); Réactive tout les bouttons
                }
            }
            jeu.setjoueur(1);
            jeu.setwinner(0);
            joueurActuel='X';
            //jeu.setdraw(false);
            jeu.repaint();
        }
   
}
