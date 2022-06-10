package jerome.main;

import jerome.entite.Assure;

import java.time.LocalDate;

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
        Assure robert = new Assure("Robert Dupuy",
                LocalDate.parse("1963-05-03"),
                LocalDate.parse("1983-05-03"),
                0);
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
        robert.ajouterAccident();
        System.out.println(robert);
        robert.ajouterAccident();
        System.out.println(robert);

        Assure roger = new Assure("Roger Durand", LocalDate.parse("2000-05-03"), LocalDate.parse("2022-05-03"), 0);
        System.out.println(roger);

        Assure bruno = new Assure("bruno Durand", LocalDate.parse("2000-05-03"), LocalDate.parse("2017-05-03"), 0);
        System.out.println(bruno);

        Assure iza = new Assure("Isabelle Durand", LocalDate.parse("1990-05-03"), LocalDate.parse("2017-05-03"), 0);
        System.out.println(iza);

        Assure soph = new Assure("Sophie Durand", LocalDate.parse("1990-05-03"), LocalDate.parse("2009-05-03"), 1);
        System.out.println(soph);

    }
}
