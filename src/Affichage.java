import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Affichage extends JPanel {
    /** Création d'un état **/
    public Etat e;
    /** Constante : Centre de l'ovale **/
    public static int Xo = 120 ;
    /** Constante : Largeur de l'ovale' **/
    public static int wo = 20 ;
    /** Constante : Hauteur de l'ovale **/
    public static int ho = 100;
    /** Constante : Largeur de la fenetre **/
    public static final int LARG = 600;
    /** Constante : Hauteur de la fenetre **/
    public static final int HAUT = 400;
    /** Constante : Initialisation du nombre de clic fait
     * par l'utilisateur **/
    public int clic =0;
    /** Initialisation de la JFrame **/
    JFrame test = new JFrame("flappy");
    /** Image de fond **/
    private BufferedImage image;
    /** Images des oiseaux du gif animé  **/
    private BufferedImage oiseau0;
    private BufferedImage oiseau1;
    private BufferedImage oiseau2;
    private BufferedImage oiseau3;
    private BufferedImage oiseau4;
    private BufferedImage oiseau5;
    private BufferedImage oiseau6;
    private BufferedImage oiseau7;

    /** Initialisation de l'affichage
     * Génère une fenetre
     * Chargement des images (fond + oiseaux)
     * ATTENTION : le path doit d'un ordinateur à l'autre
     * changer, il suffit de le récupérer en clic droit sur
     * les images
     * @param et un etat
     *  **/
    public Affichage(Etat et) throws IOException {
        this.e = et;
        image = ImageIO.read(new File("image/fond.jpg"));
        (new App(this, this.e)).start();
        setPreferredSize(new Dimension(LARG, HAUT));
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.addMouseListener(new Control(this.e, this));
        test.add(this);
        test.pack();
        test.setVisible(true);
        oiseau0 = ImageIO.read(new File("image/oiseau/0.jpg"));
        oiseau1 = ImageIO.read(new File("image/oiseau/1.jpg"));
        oiseau2 = ImageIO.read(new File("image/oiseau/2.jpg"));
        oiseau3 = ImageIO.read(new File("image/oiseau/3.jpg"));
        oiseau4 = ImageIO.read(new File("image/oiseau/4.jpg"));
        oiseau5 = ImageIO.read(new File("image/oiseau/5.jpg"));
        oiseau6 = ImageIO.read(new File("image/oiseau/6.jpg"));
        oiseau7 = ImageIO.read(new File("image/oiseau/7.jpg"));

    }

    /** Affichage de la fenetre lorsque la partie est fini
     * Ferme le jeu une fois cette fenetre fermée
     */
    public void affichageFinPartie() {
        //Cree une fenetre de dialogue qui affiche le score et qui empeche de cliquer sur le jeu tant qu'elle est visible
        JOptionPane.showMessageDialog(test,"Votre Score : " + e.parcours.getScore()/2, "FIN DE PARTIE", JOptionPane.PLAIN_MESSAGE);
        //Exit le jeu
        System.exit(0);
    }

    /** Affiche le fond, l'oiseau et l'ovale
     * Nettoie l'affichage avant d'afficher l'oiseau et l'ovale suivant
     * @param graph un graphic
     */
    @Override
    public void paint(Graphics graph) {
        //Nettoyage
        super.revalidate();
        super.repaint();
        super.paint(graph);
        //Affiche le fond
        Graphics2D g2 = (Graphics2D) graph;
        graph.drawImage(image, 0, 0, LARG, HAUT, null);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Affiche un ovale
        graph.drawOval(Xo, e.getHauteur()+20, wo, ho);
        //Affiche les oiseaux selon le nombre de clic qu'a fait l'utilisateur
        if (clic ==0){
            graph.drawImage(oiseau0, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==1){
            graph.drawImage(oiseau1, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==2){
            graph.drawImage(oiseau2, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==3){
            graph.drawImage(oiseau3, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==4){
            graph.drawImage(oiseau4, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==5){
            graph.drawImage(oiseau5, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==6){
            graph.drawImage(oiseau6, 0, e.getHauteur()-80, 300,300 , null);
        }
        if (clic ==7){
            graph.drawImage(oiseau7, 0, e.getHauteur()-80, 300,300 , null);
        }

        //Initialise le tableau de point qui compose le parcours
        Point[] points = e.getParcours();
        //Dessine la ligne du chemin
        graph.setColor(Color.blue);
        for (int i = 1; i < points.length; i++) {
            Point previousPoint = points[i-1];
            Point currentPoint = points[i];
            graph.drawLine(previousPoint.x, previousPoint.y, currentPoint.x, currentPoint.y);
        }
        //Affiche le score en noir en haut a gauche
        graph.setColor(Color.BLACK);
        graph.drawString("Score : " + (e.parcours.getScore())/2, 40, 40 );
    }
    /** Donner la valeur de la hauteur de l'ovale
     * @return ho un int
     */
    public static int getHauteurOvale() {
        return ho;
    }
    /** Donner la valeur du centre de l'ovale
     * @return Xo un int
     */
    public static int getCentreXOvale() {
        return Xo;
    }


}
