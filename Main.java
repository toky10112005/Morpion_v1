package aff;

import vue.*;
import jeu.*;

public class Main {
    public static void main(String[] args){
         Jeu j = new Jeu();
        Fenetre f=new Fenetre(j);
       f.setVisible(true);
    }
}
