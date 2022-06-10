package jerome.entite;

import java.time.LocalDate;

/**
 * The type Assurance.
 */
public class Assurance {
    /**
     * The constant BLEU.
     */
    public static final int BLEU = 4;
    /**
     * The constant VERT.
     */
    public static final int VERT = 3;
    /**
     * The constant ORANGE.
     */
    public static final int ORANGE = 2;
    /**
     * The constant ROUGE.
     */
    public static final int ROUGE = 1;
    /**
     * The constant REFUSEE.
     */
    public static final int REFUSEE = 0;
    /**
     * The constant Avantage.
     */
    public static final int AVANTAGE = 1;
    private int valeurAssu;
    private LocalDate dateEntrer;

    /**
     * Instantiates a new Assurance.
     *
     * @param dateNaissV  the age v
     * @param datePermisV the duree permis v
     * @param nbAccidentV the nb accident v
     */
    public Assurance(final LocalDate dateNaissV,
                     final LocalDate datePermisV,
                     final int nbAccidentV) {
        dateEntrer = LocalDate.now();
        int valeur = calculAssu(dateNaissV, datePermisV, nbAccidentV);
        setValeurAssu(valeur);
    }

    public LocalDate getDateEntrer() {
        return dateEntrer;
    }

    public void setDateEntrer(LocalDate dateEntrer) {
        this.dateEntrer = dateEntrer;
    }

    /**
     * Sets valeur assu.
     *
     * @param valeurAssuV the valeur assu
     */
    public void setValeurAssu(final int valeurAssuV) {
        this.valeurAssu = valeurAssuV;
    }

    /**
     * Calcul assu int.
     *
     * @param dateNaiss  the age
     * @param datePermis the duree permis
     * @param nbAccident the nb accident
     * @return the int
     */
    public int calculAssu(final LocalDate dateNaiss,
                          final LocalDate datePermis,
                          final int nbAccident) {
        int age = LocalDate.now().getYear() - dateNaiss.getYear();
        int dureePerm = LocalDate.now().getYear() - datePermis.getYear();
        int valeur = VERT - nbAccident;
        if (age < 25) {
            valeur -= 1;
        }
        if (dureePerm < 2) {
            valeur -= 1;
        }
        if ((LocalDate.now().getYear() - dateEntrer.getYear()) >= 5) {
            valeur += AVANTAGE;
        }
        if (valeur < 0) {
            valeur = REFUSEE;
        }
        return valeur;
    }

    /**
     * Surcharge du toString.
     */
    @Override
    public String toString() {
        String txt = "tarif assurance : ";
        switch (valeurAssu) {
            case BLEU -> txt = String.format("%s Bleu", txt);
            case VERT -> txt = String.format("%s Vert", txt);
            case ORANGE -> txt = String.format("%s Orange", txt);
            case ROUGE -> txt = String.format("%s Rouge", txt);
            default -> {
                txt = String.format("non assuré  %n", txt);
                return txt;
            }
        }
        txt = String.format("%s %n"
                                    + "ancienneté : %d %n ",
                txt, LocalDate.now().getYear() - dateEntrer.getYear());
        return txt;
    }
}
