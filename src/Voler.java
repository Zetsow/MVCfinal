public class Voler extends Thread{
    /** Création d'un état **/
    private Etat et;
    /** Voler
     * @param etat un etat
     * **/
    public Voler(Etat etat) {
        this.et = etat;
    }
    /** Effectue differentes taches décrites ci dessous
     */
    public void run() {
        //Try and catch dans le but d'avoir un petit temps
        // avant le debut du jeu
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Boucle pour l'ovale descende
        //si il n'y a pas de clic
        while (!et.testPerdu()) {
            et.down();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

