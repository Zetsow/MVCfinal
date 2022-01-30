import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
    /** Création d'un état **/
    public Etat et;
    /** Création d'un affichage **/
    public Affichage a;
    /** Controle
     * @param et un etat
     * @param af un affichage
     * **/
    public Control(Etat et , Affichage af) {
        this.et = et;
        this.a = af;
    }
    /** Quand un clic est fait par l'utilisateur
     * L'ovale saute et l'affichage est repaint
     * Il y a un compteur clic pour savoir quel oiseau sera affiché
     * @param e un MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (a.clic != 7 ){
            a.clic ++;
        }
        //On fait en sorte qu'après la dernière image
        // d'oiseau revienne à la premiere image
        else {
        a.clic = 0;
        }
        et.jump();
        a.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
