package jerome.main;

import jerome.entite.Assure;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Assure robert = new Assure("Robert Dupuy", 55, 30, 0);
        robert.ajouterAnciennete();
        robert.ajouterAnciennete();
        robert.ajouterAnciennete();
        robert.ajouterAnciennete();
        robert.ajouterAnciennete();
        System.out.println(robert);
        robert.ajouterAccident();
        System.out.println(robert);
        robert.ajouterAccident();
        System.out.println(robert);
        robert.ajouterAccident();
        System.out.println(robert);

        Assure roger = new Assure("Roger Durand", 18, 0, 0);
        System.out.println(roger);

        Assure bruno = new Assure("bruno Durand", 24, 3, 0);
        System.out.println(bruno);

        Assure iza = new Assure("Isabelle Durand", 26, 1, 0);
        System.out.println(iza);

        Assure soph = new Assure("Sophie Durand", 25, 2, 1);
        System.out.println(soph);

    }
}
