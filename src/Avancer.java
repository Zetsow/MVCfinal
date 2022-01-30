public class Avancer extends Thread{
    /** Création d'un parcours **/
    public Parcours parcours;
    /** Création d'un état **/
    public Etat et;
    /** Constante : Temps de Vol **/
    public static int tempsVol = 100;
    /** Avancer l'anneau
     * @param et un etat
     * @param parcours un parcours
     * **/
    public Avancer(Etat et,Parcours parcours) {
        this.parcours = parcours;
        this.et = et;
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
        //l'anneau et le chemin
        while(!et.testPerdu()) {
            Parcours.setPosition();
            try {
                Thread.sleep(tempsVol);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
