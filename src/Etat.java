import java.awt.*;
import java.util.ArrayList;


public class Etat {
    /** Constante : Defini un cadre que l'ovale
     * ne devra pas depasser **/
    public static final int H_MAX = 280;
    /** Constante : Defini un cadre que l'ovale
     * ne devra pas depasser **/
    public static final int H_MIN = 120;
    /** Constante : Defini un cadre que l'ovale
     * ne devra pas depasser **/
    public static final int L_MAX = 630;
    /** Constante : Defini un cadre que l'ovale
     * ne devra pas depasser **/
    public static final int L_MIN = -100;
    /** Constante : Hauteur du centre de l'ovale **/
    public static int HAUTEUR = H_MAX/2;
    /** Constante : Taille du saut **/
    public static int JUMP = Affichage.getHauteurOvale()/2;
    /** Constante : Hauteur de la chute **/
    public static int DOWN = Affichage.getHauteurOvale()/10;
    /** Création d'un parcours **/
    public Parcours parcours;
    /** Etat **/
    public Etat(){
        (new Voler(this)).start();
        this.parcours = new Parcours();
        (new Avancer(this,this.parcours)).start();

    }
    /** Vérifie si l'ovale et le ligne rentre en collision
     * @return un boolean
     */
    public boolean testPerdu() {
        //Variable qui correspond a l'abscisse de notre ovale
        ArrayList<Point> absc = Parcours.point;
        //Centre de l'ovale
        int centre = Affichage.getCentreXOvale();
        //Deux points pour obtenir l'equation de la droite
        Point prePoint = new Point();
        Point aftPoint = new Point();


        for(int i = 1; i < absc.size(); i++) {
            if(absc.get(i).x > centre) {
                prePoint = absc.get(i-1);
                aftPoint = absc.get(i);
                break;
            }
        }

        //Coefficient directeur
        float a = (float) ((aftPoint.y - prePoint.y)/(aftPoint.x - prePoint.x));
        //Ordonnee a l'origine
        float b = (prePoint.y - a * prePoint.x);
        //Ordonnee du point
        int y = (int) (a * centre + b);
        //Creation d'un point
        Point currentPoint = new Point(centre, y);
        //On compare les y des points avec
        // le point le haut et le bas de l'ovale
        return (getHauteur() > currentPoint.y) ^ ((getHauteur() + Affichage.getHauteurOvale()) < currentPoint.y);
    }

    /** Change la hauteur de l'ovale (saut)
     */
    public void jump(){
        if ( HAUTEUR > 0 ) {
            HAUTEUR = HAUTEUR - JUMP;
        }
    }
    /** Donner la valeur de la hauteur de l'ovale
     * @return HAUTEUR un int
     */
    public int getHauteur(){
        return HAUTEUR;
    }

    /** Change la hauteur de l'ovale (chute)
     */
    public void down() {
        if (HAUTEUR + DOWN <= H_MAX) {
            HAUTEUR += DOWN;
        }
    }
    /** Donner le tableau de point du parcours
     * @return un tableau
     */
    public Point[] getParcours() {
        return this.parcours.getPoints();
    }


}

