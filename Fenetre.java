package vue;

import jeu.Jeu;
import javax.swing.JFrame;

public class Fenetre extends JFrame{
    
    int width=800;
    int height=800;

    public Fenetre(Jeu j){
        setTitle("Morpion");
        setSize(this.width,this.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(j);
        setVisible(true);
    }
}