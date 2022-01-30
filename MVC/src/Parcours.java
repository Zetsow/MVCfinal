import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    /** Tableau de point de la ligne brisée **/
    public static ArrayList<Point> point = new ArrayList<Point>();
    /** Créer un random **/
    public static final Random random = new Random();
    /** Constante : Score du joueur **/
    public static int SCORE;
    /** Constante : Vitesse de la ligne **/
    public static int SPEED = 5;
    /** Parcours
     **/
    public Parcours() {
        InitialisationPoint();
        SCORE = 2;
    }

    /** Initialise le tableau de points de la ligne brisée
     */
    public void InitialisationPoint() {
        //Création du first point
        int y =  Affichage.getHauteurOvale()/2 + Etat.HAUTEUR ;
        int x = Affichage.getCentreXOvale();
        Point p1 = new Point(x,y);
        point.add(p1);

        while (x <= Etat.L_MAX) {
            x += 50 + random.nextInt(15);
            y = Etat.H_MIN + random.nextInt(Etat.H_MAX - Etat.H_MIN) ;
            Point p2 = new Point(x, y);
            point.add(p2);
        }
    }
    /** Donner le tableau contenant tous les points du
     * parcours en temps réel et met à jour le tableau de points
     * @return point2 un tableau
     */
    public Point[] getPoints() {
        Point[] point2 = new Point[point.size()];
        //On parcours point, si l'abcisse du point - la SPEED est inferieur a la
        //taille du cadre on le supprime et on en rajoute un autre
        for(int i = 0; i < point.size(); i++) {
            if ((point.get(i).x - SPEED) < Etat.L_MIN) {
                point.remove(point.get(i));
                //cree un point par rapport au dernier point de point
                Point p3 = CreationPoint(point.get(point.size() - 1).x);
                point.add(p3);
            }
        }
        //Rempli le tableau de point initialise plus haut que l'on va return
        for (int i = 0; i < point.size(); i++) {
            point2[i] = point.get(i);
        }
        return point2;
    }

    /** Creer un point avec un x qui depen du x precedent
     * et un y random avec les bonnes bornes
     * @param aftX un int
     * @return un point
     */
    public static Point CreationPoint(int aftX) {
        int newY = Etat.H_MIN + random.nextInt(Etat.H_MAX - Etat.H_MIN) ;
        int newX = aftX + 75 + random.nextInt(15);
        return new Point( newX, newY);
    }

    /** Donne le score du joueur
     * @return SCORE un int
     */
    public int getScore() {
        return SCORE;
    }

    /** Augmente le score et augmente la vitesse selon le score
     */
    public static void setPosition() {
        SCORE = SCORE + 2;
        for( Point p4 : point) {
            p4.x = p4.x - SPEED;
        }
    }


}

