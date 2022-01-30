public class App extends Thread {
    /** Création d'un affichage **/
    public Affichage affichage;
    /** Création d'un état **/
    public Etat etat;


    /** Affichage
     * @param af
     * @param et
     */
    public App(Affichage af, Etat et) {
        this.affichage = af;
        this.etat = et;

    }

    /** Effectue differentes taches décrites ci dessous
     */
    @Override
    public void run() {
        //Try and catch dans le but d'avoir un petit temps
        // avant le debut du jeu
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Vérifie si il y a une collision entre
        //l'anneau et le chemin sinon il affiche
        //la fenetre de fin de jeu
        while (!etat.testPerdu()) {
            affichage.revalidate();
            affichage.repaint();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        affichage.affichageFinPartie();
    }
}

