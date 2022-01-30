import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Création des objets qui contiennent les autres objets
        Etat etat = new Etat();
        Affichage affichage = new Affichage(etat);
    }
}
